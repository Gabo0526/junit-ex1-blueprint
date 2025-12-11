package ec.edu.epn;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    static Calculator calculator;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void simpleGivenTwoIntegersWhenAddThenReturnSum() {
        // Arrange
        int a = 1;
        int b = 1;
        int expected = 2;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void simpleGivenTwoIntegersWhenSubtractThenReturnSubstraction() {
        // Arrange
        int a = 1;
        int b = 1;
        int expected = 0;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void givenZeroAsParameterWhenMultiplyThenReturnsZero() {
        // Arrange
        int a = 1;
        int b = 0;
        int expected = 0;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void givenZeroAsDivisorWhenDivideThenReturnsError() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
        assertEquals("The divisor cannot be zero.", exception.getMessage());
    }

    @Test
    void givenAnOddNumberWhenIsEvenThenReturnsFalse() {
        assertFalse(calculator.isEven(1));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "0, 0, 0",
            "-1, 1, 0",
            "-2, -3, -5",
            "100, 200, 300"
    })
    void givenTwoIntegersWhenAddThenReturnSum(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 0",
            "2, 3, -1",
            "0, 0, 0",
            "-1, 1, -2",
            "-2, -3, 1",
            "100, 200, -100"
    })
    void givenTwoIntegersWhenSubtractThenReturnSubstraction(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1",
            "2, 3, 6",
            "0, 0, 0",
            "-1, 1, -1",
            "-2, -3, 6",
            "100, 200, 20000"
    })
    void givenTwoIntegersWhenMultiplyThenReturnMultiplication(int a, int b, int expected) {
        assertEquals(expected, calculator.multiply(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 2, 5.0",
            "9, 3, 3.0",
            "-8, -2, 4.0",
            "-9, 3, -3.0",
            "7, -1, -7.0"
    })
    void givenTwoIntegersWhenDivideThenReturnQuotient(int a, int b, double expected) {
        assertEquals(expected, calculator.divide(a, b));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10, -2, -4, -6})
    void givenAnEvenNumberWhenIsEvenThenReturnsTrue(int number) {
        assertTrue(calculator.isEven(number));
    }

    @Test
    void givenTwoIntegersWhenDivideThenReturnQuotientWithTolerance() {
        // Arrange
        int a = 11;
        int b = 2;

        // Act
        double result = calculator.divide(a, b);

        // Assert
        assertEquals(5.5, result, 0.0001, "The division result should be approximately 5.5");
        // Aqui el parametro de tolerancia es 0.0001
    }

    @Test
    void divide_TwoPositiveNumbers_ReturnCorrectQuotient() {
        // Arrange - Prepare
        int a = 10;
        int b = 2;
        // Act
        double result = calculator.divide(a, b);
        // Assert
        assertAll(
                () -> assertEquals(5.0, result),
                () -> assertTrue(result > 0)
        );
    }
}