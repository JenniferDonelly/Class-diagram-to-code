package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

    @Test
    public void testManagerCreation() {
        Manager manager = new Manager("Jane", "Doe", "987654321", "86011123456", 120, 500);
        assertEquals("Jane", manager.getName());
        assertEquals(500, manager.getBonus());
    }

    @Test
    public void testCalculateSalary() {
        Manager manager = new Manager("Jane", "Doe", "987654321", "86011123456", 120, 500);
        int expectedSalary = 120*8*5*4 + 500;
        assertEquals(expectedSalary, manager.calculateSalary());
    }
}
