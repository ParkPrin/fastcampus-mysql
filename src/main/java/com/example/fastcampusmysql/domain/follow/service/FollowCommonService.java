package com.example.fastcampusmysql.domain.follow.service;

import com.example.fastcampusmysql.domain.follow.dto.FollowDto;
import com.example.fastcampusmysql.domain.follow.entity.Follow;
import org.springframework.stereotype.Service;

@Service
public class FollowCommonService {
    public FollowDto toDTo(Follow follow){
        return new FollowDto(
                follow.getId(),
                follow.getFromMemberId(),
                follow.getToMemberId()
        );
    }
}
