package dev.solar.mythejavatest;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {
    @Test
    @DisplayName("스터디 만들기 ╯°□°）╯ ")
    void create_new_study() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300); // 일부러 실패하도록 실행을 일정시간 멈춤
        }); //10초 안에 실행이 끝나는지 확인
        // TODO ThreadLocal
    }

    @Test
    @DisplayName("스터디 만들기 \uD83D\uDE31")
    void create_new_study_again() {
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @Test
    @Disabled
    void create2() {
        System.out.println("create2");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each");
    }
}
