package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testEmployeeCreation() {
        Employee employee = new Employee("John", "Smith", "123456789", "95012212345", 90);
        assertEquals("John", employee.getName());
        assertEquals("Smith", employee.getSurname());
        assertEquals(90, employee.getHourlyRate());
    }

    @Test
    public void testCalculateSalary() {
        Employee employee = new Employee("John", "Smith", "123456789", "95012212345", 90);
        int expectedSalary = 90*8*5*4; // hourlyRate * 8 * 5 * 4
        assertEquals(expectedSalary, employee.calculateSalary());
    }
}
