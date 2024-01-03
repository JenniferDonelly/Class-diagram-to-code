package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testPersonCreation() {
        Person person = new Employee("John", "Doe", "123456789", "95012212345", 100);
        assertEquals("John", person.getName());
        assertEquals("Doe", person.getSurname());
        assertEquals("123456789", person.getPhone());
        assertEquals("95012212345", person.getPesel());
        assertEquals(100, person.getHourlyRate());
    }

    @Test
    public void testCalculateSalary() {
        // Assuming salary is hourlyRate * 8 hours * 5 days * 4 weeks
        Person person = new Employee("John", "Doe", "123456789", "95012212345", 100);
        assertEquals(100*8*5*4, person.calculateSalary());
    }
}
