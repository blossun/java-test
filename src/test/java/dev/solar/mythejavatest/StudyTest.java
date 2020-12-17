package dev.solar.mythejavatest;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {
    @Test
    @DisplayName("스터디 만들기 ╯°□°）╯ ")
    void create_new_study() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println("TEST_ENV : " + test_env);

        assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
            System.out.println(">> local test");
            //조건이 맞는 경우 아래 코드 실행
            Study actual = new Study(100);
            assertThat(actual.getLimit()).isGreaterThan(0);

        });

        assumingThat("SOLAR".equalsIgnoreCase(test_env), () -> {
            System.out.println(">> solar test");
            //조건이 맞는 경우 아래 코드 실행
            Study actual = new Study(10);
            assertThat(actual.getLimit()).isGreaterThan(0);
        });
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
