package in.codebuffdev.unittesting;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD) // default
// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running math utils")
class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    static void beforeAllInit(){
        System.out.println("MathUtilsTest.beforeAllInit");
    }

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanUp() {
        System.out.println("before cleaning" + mathUtils);
        mathUtils = null;
        System.out.println("Cleaning Up..." + mathUtils);
    }

    @Test
    void testComputeCircleArea() {
        double computedCircleArea = mathUtils.computeCircleArea(10);
        assertEquals(314.1592653589793, computedCircleArea, () -> "Should return right circle area");
    }

    @Test
    void testDivide() {
        boolean serverIsUp = false;
        assumeTrue(serverIsUp);
        assertThrows(ArithmeticException.class, () -> {
            mathUtils.divide(5, 0);
        }, () -> "Different exception occurred");
    }

    @Test
    @DisplayName("failing intentionally")
    @Disabled
    void deliberatelyFailing(){
        fail("deliberatelyFailing");
    }

    @Test
    @RepeatedTest(3) // repeat the test for 3 times
    void multiplyTest(){
        assertAll(
                ()-> assertEquals(200, mathUtils.multiply(10,20)),
                ()-> assertEquals(20, mathUtils.multiply(1,20)),
                ()-> assertEquals(2, mathUtils.multiply(1,2)),
                ()-> assertEquals(-20, mathUtils.multiply(-1,20))
        );
    }

    @Nested
    @DisplayName("Testing add() in different ways")
    class AddTest{
        @Test
        @DisplayName("Testing add method for + ")
        void testAddPositive() {
            int result = mathUtils.add(1, 1);
            int expectedValue = 2;
            assertEquals(expectedValue, result, () -> "actual value is not matched with expected value");
        }

        @Test
        @DisplayName("Testing add method for - ")
        void testAddNegative() {
            int result = mathUtils.add(-1, -1);
            int expectedValue = -2;
            assertEquals(expectedValue, result, () -> "actual value is not matched with expected value");
        }

        @Test
        @DisplayName("Testing add method for - & + ")
        void testAddNegativePositive() {
            int result = mathUtils.add(1, -1);
            int expectedValue = 0;
            assertEquals(expectedValue, result, () -> "actual value is not matched with expected value");
        }
    }
}
