package ec.edu.epn;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    private static TaxCalculator taxCalculator;

    @BeforeAll
    static void setInstance() {
        taxCalculator = new TaxCalculator();
    }

    @ParameterizedTest
    @CsvSource
    ({
        "100.0, 0.15, 115.000",
        "200.0, 0.10, 220.000",
        "50.0, 0.20, 60.000",
        "0.0, 0.05, 0.000",
        "150.0, 0.00, 150.000"
    })
    void testCalculateTax(BigDecimal amount, BigDecimal taxRate, BigDecimal expected) {
        assertEquals(expected, taxCalculator.calculateTax(amount, taxRate));
    }

    private static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(new BigDecimal("12"), new BigDecimal("0.15"), new BigDecimal("13.80")),
                Arguments.of(new BigDecimal("50"), new BigDecimal("0.10"), new BigDecimal("55.00")),
                Arguments.of(new BigDecimal("80"), new BigDecimal("0.20"), new BigDecimal("96.00"))
        );
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void methodSourceTestCalculateTax (BigDecimal amount, BigDecimal taxRate, BigDecimal expected) {
        assertEquals(expected, taxCalculator.calculateTax(amount, taxRate));
    }
}