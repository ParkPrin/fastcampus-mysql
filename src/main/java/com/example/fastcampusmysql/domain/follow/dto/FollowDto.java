package com.example.fastcampusmysql.domain.follow.dto;

public record FollowDto(
        Long id,
        Long fromMemberId,
        Long toMemberId
    ) {
}
