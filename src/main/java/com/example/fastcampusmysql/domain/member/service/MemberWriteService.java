package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.entity.MemberNicknameHistory;
import com.example.fastcampusmysql.domain.member.repository.MemberNicnameHistoryRepository;
import com.example.fastcampusmysql.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberWriteService {
    final private MemberRepository memberRepository;
    final private MemberCommonService memberCommonService;
    final private MemberNicnameHistoryRepository memberNicnameHistoryRepository;
    public MemberDto register(RegisterMemberCommand command) {
        /*
            Goal - 회원정보(이메일, 닉네임, 생년월일)를 등록한다.
                 - 닉네임은 18자를 넘길 수 없다.
            파라미터 - memberRegisterCommand
            val member = Member.of(memberRegisterCommand)
            memberRepository.save(member)
         */
        var member = Member.builder()
                .nickname(command.nickname())
                .email(command.email())
                .birthday(command.birthday())
                .build();
        var saveMember = memberRepository.save(member);
        saveMemberNicnameHistory(saveMember);
        return memberCommonService.toDto(memberRepository.save(saveMember));
    }

    public MemberDto changeNicname(Long memberId, String nickname) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        Member changeMember = member.changeNicName(nickname);
        memberRepository.save(changeMember);
        saveMemberNicnameHistory(changeMember);
        return memberCommonService.toDto(changeMember);
    }

    private void saveMemberNicnameHistory(Member member){
        var history = MemberNicknameHistory
                .builder()
                .memberId(member.getId())
                .nickname(member.getNickname())
                .build();
        memberNicnameHistoryRepository.save(history);
    }


}
