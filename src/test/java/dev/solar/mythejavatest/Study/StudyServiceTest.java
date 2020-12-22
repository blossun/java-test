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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Test
    void createNewStudy(@Mock MemberService memberService, @Mock StudyRepository studyRepository) {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("solar@test.com");

        Study study = new Study(10, "테스트");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);

        studyService.createNewStudy(1L, study);
        assertEquals(member, study.getOwner());

        // 특정 시점 이후에 아무 일도 벌어지지 않았는지 검증
        verify(memberService, times(1)).notify(study);
        verifyNoMoreInteractions(memberService);
    }

}
