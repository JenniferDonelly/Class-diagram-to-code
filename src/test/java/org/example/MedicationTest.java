package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MedicationTest {

    private Medication medication;
    private Purchase mockPurchase;
    private Employee mockEmployee;
    private Prescription mockPrescription;

    @BeforeEach
    public void setup() {
        mockEmployee = new Employee("John", "Doe", "1234567890", "1234567890123", 15); // Assuming Employee has a simple constructor
        mockPrescription = new Prescription(LocalDate.now(), "12345678901"); // Assuming Prescription has a simple constructor
        mockPurchase = new Purchase(LocalDate.now(), mockEmployee, mockPrescription);

        medication = new Medication("Paracetamol", 365, mockPurchase);
    }

    @Test
    public void testMedicationCreation() {
        assertNotNull(medication);
        assertEquals("Paracetamol", medication.getName());
        assertEquals(365, medication.getShelfLife());
        assertFalse(medication.isForDisposal());
        assertTrue(medication.getPurchases().contains(mockPurchase));
    }

    @Test
    public void testAddPurchase() {
        Purchase newPurchase = new Purchase(LocalDate.now(), mockEmployee, mockPrescription); // Assuming Purchase has a constructor with LocalDate, Employee, Prescription
        medication.addPurchase(newPurchase);
        assertTrue(medication.getPurchases().contains(newPurchase));
    }

    @Test
    public void testForDisposalFlag() {
        assertFalse(medication.isForDisposal()); // Initially not for disposal
        medication.setForDisposal(true);
        assertTrue(medication.isForDisposal());
    }
}
