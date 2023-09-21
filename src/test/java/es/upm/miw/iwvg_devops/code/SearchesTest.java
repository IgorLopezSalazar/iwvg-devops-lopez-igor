package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {
    @Test
    void testFindFamilyNameByFractionDenominator() {
        assertEquals(List.of("Oscar", "Ana", "Oscar", "Antonio", "Paula"), new Searches().findUserNameBySomeImproperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFractionAdditionByUserId() {
        assertEquals(new Fraction(3, 1), new Searches().findFractionAdditionByUserId("1"));
    }
    @Test
    void testFindHighestFraction() {
        assertEquals(new Fraction(2, 1), new Searches().findHighestFraction());
    }
}
