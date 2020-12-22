package dev.solar.mythejavatest.Study;

import dev.solar.mythejavatest.domain.Member;
import dev.solar.mythejavatest.domain.Study;
import dev.solar.mythejavatest.member.MemberService;
import dev.solar.mythejavatest.study.StudyRepository;
import dev.solar.mythejavatest.study.StudyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class StudyServiceTest {

    //StudyService 인스턴스를 만드는 테스트
    //MemberService와 StudyRepository가 있어야 만들 수 있다.
    //인터페이스만 있고 구현체가 없는 상황에서 목을 사용하면 된다.

    @Test
    void createStudyService() {
        //인터페이스의 구현체가 없으므로 여기서 인라인으로 바로 생성해서 넣어준다.
        // 2. Mockito.mock() 을 이용해서 목객체를 생성
        MemberService memberService = mock(MemberService.class);
        StudyRepository studyRepository = mock(StudyRepository.class);

        StudyService studyService = new StudyService(memberService, studyRepository);

        assertNotNull(studyService);

    }


}
