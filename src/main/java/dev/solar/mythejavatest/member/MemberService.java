package dev.solar.mythejavatest.member;

import dev.solar.mythejavatest.domain.Member;
import dev.solar.mythejavatest.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newStudy);
}
