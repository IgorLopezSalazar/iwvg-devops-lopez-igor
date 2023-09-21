package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    Fraction fraction;
    @BeforeEach
    void createFraction() {
        fraction = new Fraction(1, 2);
    }
    @Test
    void testGetNumerator() {
        assertEquals(1, fraction.getNumerator());
    }
    @Test
    void testSetNumerator() {
        fraction.setNumerator(10);
        assertEquals(10, fraction.getNumerator());
    }
    @Test
    void testGetNDenominator() {
        assertEquals(2, fraction.getDenominator());
    }
    @Test
    void testSetNDenominator() {
        fraction.setDenominator(20);
        assertEquals(20, fraction.getDenominator());
    }
    @Test
    void createBlankFraction() {
        Fraction f = new Fraction();
        assertEquals(1, f.getNumerator());
        assertEquals(1, f.getDenominator());
    }
    @Test
    void testDecimal() {
        assertEquals(0.5, fraction.decimal());
    }
    @Test
    void testToString() {
        assertEquals("Fraction{numerator=1, denominator=2}",
                    fraction.toString());
    }
}
