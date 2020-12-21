package dev.solar.mythejavatest;

import dev.solar.mythejavatest.domain.Study;
import dev.solar.mythejavatest.study.StudyStatus;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudyTest {

    int value = 1;

    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension =
            new FindSlowTestExtension(1000L);

    @Order(2)
    @FastTest
    @DisplayName("스터디 만들기 fast")
    @Disabled
    void create_new_study() {
        Study actual = new Study(1, "테스트 스터디");
        assertAll(
                () -> assertEquals(1, actual.getLimitCount()),
                () -> assertEquals("테스트 스터디", actual.getName()),
                () -> assertEquals(StudyStatus.DRAFT, actual.getStatus())
        );
    }

    @Order(1)
    @SlowTest
    @DisplayName("스터디 만들기 slow")
    void create_new_study_again() throws InterruptedException {
        Thread.sleep(1005L);
        System.out.println(this);
        System.out.println(value++);
    }

    @Order(1)
    @Test
    @DisplayName("스터디 만들기 slow ?")
    void create_slow_study() throws InterruptedException {
        Thread.sleep(1005L);
        System.out.println("is slow?? ");
    }

    @Order(5)
    @DisplayName("반복 테스트")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println("test" + repetitionInfo.getCurrentRepetition() + "/" +
                repetitionInfo.getTotalRepetitions());
    }

    @Order(3)
    @DisplayName("반복 테스트 2 - 암시적 변환")
    @ParameterizedTest
    @ValueSource(strings = {"2017-03-14", "2020-01-20"})
    void testWith_implicit_conversion(LocalDate localDate) {
        System.out.println("localDate => " + localDate.toString());
        assertTrue(localDate != null);
    }

    @Order(4)
    @DisplayName("반복 테스트 3 - 인자값 조합")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10, 자바 스터디", "20, '스프링'"})
    void parameterizedTest(@AggregateWith(StudyAggregator.class) Study study) {
        System.out.println(study);
    }

    static class StudyAggregator implements ArgumentsAggregator {
        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        }
    }

    static class StudyConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "Can only convert to Study");
            return new Study(Integer.parseInt(source.toString()));
        }
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
