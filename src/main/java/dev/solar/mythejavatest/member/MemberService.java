package dev.solar.mythejavatest.member;

import dev.solar.mythejavatest.domain.Member;

public interface MemberService {
    void validate(Long memberId) throws InvalidMemberException;

    Member findById(Long memberId) throws MemberNotFoundException;
}
