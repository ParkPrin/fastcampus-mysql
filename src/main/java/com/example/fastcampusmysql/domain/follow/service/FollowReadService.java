package com.example.fastcampusmysql.domain.follow.service;

import com.example.fastcampusmysql.domain.follow.dto.FollowDto;
import com.example.fastcampusmysql.domain.follow.repository.FollowRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FollowReadService {
    final private FollowRepository followRepository;
    private final FollowCommonService followCommonService;

    public List<FollowDto> getFollowings(Long memberId){
        return followRepository.findAllByFromMemberId(memberId)
                .stream()
                .map(followCommonService::toDTo)
                .toList();
    }


}
