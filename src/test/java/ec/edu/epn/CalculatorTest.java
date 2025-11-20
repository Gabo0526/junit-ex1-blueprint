package ec.edu.epn;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
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
    void givenTwoIntegersWhenSubtractThenReturnSubstraction() {
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
}