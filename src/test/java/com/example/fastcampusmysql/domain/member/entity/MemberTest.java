package com.example.fastcampusmysql.domain.member.entity;

import static org.junit.jupiter.api.Assertions.*;

import com.example.fastcampusmysql.util.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberTest {

    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    @Test
    public void testChangeMain() {
        Member member = MemberFixtureFactory.create();
        String expectedNicname = "Park";

        Member changeMember = member.changeNicName(expectedNicname);
        Assertions.assertEquals(expectedNicname, changeMember.getNickname());
    }

    @DisplayName("회원은 닉네임은 10자를 초과할 수 없다")
    @Test
    public void testNicknameMaxLength() {
        Member member = MemberFixtureFactory.create();
        String overMaxLengthNicname = "Parkjonghoon";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> member.changeNicName(overMaxLengthNicname)
        );
    }
}