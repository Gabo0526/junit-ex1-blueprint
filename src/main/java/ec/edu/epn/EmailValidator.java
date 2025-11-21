package ec.edu.epn;

public class EmailValidator {
    /**
     * Validates if the provided email address is in a correct format.
     * @param email The email address to validate.
     * @return true if the email is valid, false otherwise.
     */
    public boolean isValidEmail(String email) {
        // Simple regex for demonstration purposes. In production, consider using a more robust solution.
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }
}
