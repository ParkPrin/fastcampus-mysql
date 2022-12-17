package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.dto.MemberNicknameHistoryDto;
import com.example.fastcampusmysql.domain.member.repository.MemberNicnameHistoryRepository;
import com.example.fastcampusmysql.domain.member.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberReadService {
    final private MemberRepository memberRepository;
    final private MemberCommonService memberCommonService;
    final private MemberNicnameHistoryRepository memberNicnameHistoryRepository;

    public MemberDto getMember(Long id) {
        return memberCommonService.toDto(memberRepository.findById(id).orElseThrow());
    }

    public List<MemberNicknameHistoryDto> getNicknameHistories(Long memberId){
        return memberNicnameHistoryRepository
                .findAllByMemberId(memberId)
                .stream()
                .map(memberCommonService::toDto)
                .toList();
    }

    public List<MemberDto> getMembers(List<Long> ids){
        var members = memberRepository.findAllByIdIn(ids);
        return members
                .stream()
                .map(memberCommonService::toDto)
                .toList();
    }
}
