package ec.edu.epn;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    private static EmailValidator emailValidator;

    @BeforeAll
    static void setUp() {
        emailValidator = new EmailValidator();
    }

    private static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of("gabriel.vasconez@epn.edu.ec", true),
                Arguments.of("invalid-email@", false)
        );
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void givenValidEmails_whenIsValidEmail_thenReturnsTrue(String email, boolean expectedResult) {
        assertEquals(expectedResult, emailValidator.isValidEmail(email));
    }
}