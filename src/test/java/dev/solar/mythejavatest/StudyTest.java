package dev.solar.mythejavatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {
    @Test
    @DisplayName("스터디 만들기 ╯°□°）╯ ")
    void create_new_study() {
        assertThrows(IllegalArgumentException.class, () -> new Study(-10));
    }

    @Test
    @DisplayName("스터디 만들기 \uD83D\uDE31")
    void create_new_study_again() {
        System.out.println("create1");
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
