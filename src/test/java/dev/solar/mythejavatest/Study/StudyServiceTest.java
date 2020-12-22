package dev.solar.mythejavatest.Study;

import dev.solar.mythejavatest.domain.Member;
import dev.solar.mythejavatest.member.MemberService;
import dev.solar.mythejavatest.study.StudyRepository;
import dev.solar.mythejavatest.study.StudyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Test
    void createStudyService(@Mock MemberService memberService, @Mock StudyRepository studyRepository) {
        Member member = new Member();
        member.setId(1L);
        member.setEmail("solar@test.com");

        //PMcok Stubbing
        //memberService.findById(1L)를 했을 때, 앞서정의한 member를 반환해라
        //1L이 아닌 값으로 findById()를 호출하는 경우에는 반환하지 않음
        when(memberService.findById(1L)).thenReturn(Optional.of(member));

        Optional<Member> findById = memberService.findById(1L);
        assertEquals("solar@test.com", findById.get().getEmail());

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
    }

}
