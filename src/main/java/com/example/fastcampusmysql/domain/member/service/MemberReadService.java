package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberReadService {
    final private MemberRepository memberRepository;
    final private MemberCommonService memberCommonService;

    public MemberDto getMember(Long id) {
        return memberCommonService.toDto(memberRepository.findById(id).orElseThrow());
    }
}
