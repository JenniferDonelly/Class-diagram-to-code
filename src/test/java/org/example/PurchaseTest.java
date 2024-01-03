package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class PurchaseTest {

    private Employee employee;
    private Prescription prescription;
    private Purchase purchaseWithPrescription;
    private Purchase purchaseWithoutPrescription;

    @BeforeEach
    public void setup() {
        // Setting up mock Employee and Prescription objects
        employee = new Employee("John", "Doe", "1234567890", "1234567890123", 15); // Assuming Employee has a simple constructor
        prescription = new Prescription(LocalDate.now(), "12345678901"); // Assuming Prescription has a simple constructor

        // Creating two types of Purchase instances: one with and one without Prescription
        purchaseWithPrescription = new Purchase(LocalDate.of(2022, 1, 1), employee, prescription);
        purchaseWithoutPrescription = new Purchase(LocalDate.of(2022, 1, 1), employee);
    }

    @Test
    public void testPurchaseCreationWithPrescription() {
        assertNotNull(purchaseWithPrescription);
        assertEquals(LocalDate.of(2022, 1, 1), purchaseWithPrescription.getDate());
        assertEquals(employee, purchaseWithPrescription.getAssignee());
        assertEquals(prescription, purchaseWithPrescription.getPrescription());
    }

    @Test
    public void testPurchaseCreationWithoutPrescription() {
        assertNotNull(purchaseWithoutPrescription);
        assertEquals(LocalDate.of(2022, 1, 1), purchaseWithoutPrescription.getDate());
        assertEquals(employee, purchaseWithoutPrescription.getAssignee());
        assertNull(purchaseWithoutPrescription.getPrescription());
    }
}
