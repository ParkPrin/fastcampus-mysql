package com.example.fastcampusmysql.util;

import com.example.fastcampusmysql.domain.member.entity.Member;
import java.util.Random;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class MemberFixtureFactory {
    static public Member create(){
        var param = new EasyRandomParameters().seed(new Random().nextLong());
        return new EasyRandom(param).nextObject(Member.class);
    }
}
