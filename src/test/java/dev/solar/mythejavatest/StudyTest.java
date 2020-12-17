package dev.solar.mythejavatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {
    @Test
    @DisplayName("스터디 만들기 ╯°□°）╯ ")
    @EnabledOnOs({OS.MAC, OS.LINUX}) //해당 운영체제애서만 활성화
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9, JRE.JAVA_10, JRE.JAVA_11}) //해당 Java 버전환경에서만 활성화
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "SOLAR")
    void create_new_study() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println("TEST_ENV : " + test_env);

        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @Test
    @DisplayName("스터디 만들기 \uD83D\uDE31")
    @EnabledOnJre(JRE.OTHER) //JRE.OTHER : 상수로 지정된 값이 아닌 경우
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void create_new_study_again() {
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @Test
    @DisabledOnOs(OS.MAC) //해당 운영체제에서 비활성화
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
