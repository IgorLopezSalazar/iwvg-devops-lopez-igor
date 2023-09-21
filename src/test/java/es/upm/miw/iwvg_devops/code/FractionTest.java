package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    Fraction fraction;
    Fraction fraction1;
    Fraction fraction2;
    @BeforeEach
    void createFraction() {
        fraction = new Fraction(1, 2);
        fraction1 = new Fraction(3, 53);
        fraction2 = new Fraction(27, 31);
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
    void testisProper() {
        assertTrue(fraction.isProper());
    }
    @Test
    void testisImproper() {
        assertTrue(new Fraction(2,1).isImproper());
    }
    @Test
    void testisEquivalent() {
        assertTrue(fraction.isEquivalent(new Fraction(3, 6)));
    }
    @Test
    void testSimplifyFraction() {
        Fraction frac1 = new Fraction(6, 12);
        frac1.simplifyFraction();
        assertEquals(fraction, frac1);
    }
    @Test
    void testAdd() {
        assertEquals(new Fraction(1524, 1643), fraction1.add(fraction2));
    }
    @Test
    void testMultiply() {
        assertEquals(new Fraction(81, 1643), fraction1.multiply(fraction2));
    }
    @Test
    void testDivide() {
        assertEquals(new Fraction(31, 477), fraction1.divide(fraction2));
    }
    @Test
    void testToString() {
        assertEquals("Fraction{numerator=1, denominator=2}",
                    fraction.toString());
    }
}
