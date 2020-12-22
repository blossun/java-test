package dev.solar.mythejavatest.member;

import dev.solar.mythejavatest.domain.Member;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);
}
