package ec.edu.epn;

import java.math.BigDecimal;

public class TaxCalculator {

    public BigDecimal calculateTax(BigDecimal amount, BigDecimal taxRate) {
        if (amount.compareTo(BigDecimal.ZERO) < 0 || taxRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount and tax rate must be non-negative.");
        }
        return amount.multiply(BigDecimal.ONE.add(taxRate));
    }
}
