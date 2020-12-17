package dev.solar.mythejavatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {
    @Test
    void create() {
        System.out.println("create");
        Study study = new Study();
        assertNotNull(study);
    }

    @Test
    void create1() {
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
