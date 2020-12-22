package dev.solar.mythejavatest.Study;

import dev.solar.mythejavatest.domain.Member;
import dev.solar.mythejavatest.domain.Study;
import dev.solar.mythejavatest.member.MemberService;
import dev.solar.mythejavatest.study.StudyRepository;
import dev.solar.mythejavatest.study.StudyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Test
    void createStudyService(@Mock MemberService memberService, @Mock StudyRepository studyRepository) {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("solar@test.com");

        //PMcok Stubbing
        //같은 메서드로 동일하게 여러번 호출되더라도 호출되는 순서에 따라 다르게 모킹
        when(memberService.findById(any()))
                .thenReturn(Optional.of(member)) //첫번째 호출된 경우 member 반환
                .thenThrow(new RuntimeException()) //두번째 호출된 경우 예외 발생
                .thenReturn(Optional.empty()); //세번쨰 호출된 경우 비어있는 값 반환

        Optional<Member> byId = memberService.findById(1L);
        assertEquals("solar@test.com", byId.get().getEmail());

        assertThrows(RuntimeException.class, () -> {
            memberService.findById(2L);
        });

        assertEquals(Optional.empty(), memberService.findById(3L));

    }

    @Test
    void practiceTest(@Mock MemberService memberService, @Mock StudyRepository repository) {
        StudyService studyService = new StudyService(memberService, repository);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("solar@test.com");

        Study study = new Study(10, "테스트");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));

        when(repository.save(study)).thenReturn(study);

        studyService.createNewStudy(1L, study);

        assertEquals(member, study.getOwner());
    }

}
