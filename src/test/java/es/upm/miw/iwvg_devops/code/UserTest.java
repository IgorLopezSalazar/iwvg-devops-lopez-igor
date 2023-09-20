package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserTest {
    AutoCloseable openMocks;
    @Mock
    private Fraction mockFraction;
    private User user;

    @BeforeEach
    void createUser() {
        mockFraction = mock(Fraction.class);
        user = new User("1", "UserTest",
                "FamilyName", new ArrayList<>());
        when(mockFraction.toString()).thenReturn("1/2");
    }
    @Test
    void testGetId() {
        assertEquals("1", user.getId());
    }
    @Test
    void testGetName() {
        assertEquals("UserTest", user.getName());
    }
    @Test
    void testSetName() {
        user.setName("NewUser");
        assertEquals("NewUser", user.getName());
    }
    @Test
    void testGetFamilyName() {
        assertEquals("FamilyName", user.getFamilyName());
    }
    @Test
    void testSetFamilyName() {
        user.setFamilyName("NewFamilyName");
        assertEquals("NewFamilyName", user.getFamilyName());
    }
    @Test
    void testGetFractions() {
        assertIterableEquals(List.of(), user.getFractions());
    }
    @Test
    void testSetFractions() {
        user.setFractions(List.of(mockFraction));
        assertIterableEquals(List.of(mockFraction), user.getFractions());
    }
    @Test
    void testAddFraction() {
        mockFraction = new Fraction();
        user.addFraction(mockFraction);
        assertIterableEquals(List.of(mockFraction), user.getFractions());
    }
    @Test
    void testFullName() {
        assertEquals("UserTest FamilyName", user.fullName());
    }
    @Test
    void testInitials() {
        assertEquals("U.", user.initials());
    }
    @Test
    void testToStringEmptyFractions() {
        assertEquals("User{id='1', name='UserTest', " +
                    "familyName='FamilyName', fractions=[]}", user.toString());
    }
    @Test
    void testToString() {
        user.addFraction(mockFraction);
        assertEquals("User{id='1', name='UserTest', " +
                "familyName='FamilyName', fractions=[1/2]}", user.toString());
    }
}
