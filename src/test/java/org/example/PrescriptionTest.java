package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class PrescriptionTest {

    private Prescription prescription;

    @BeforeEach
    public void setup() {
        prescription = new Prescription(LocalDate.of(2022, 1, 1), "12345678901");
    }

    @Test
    public void testPrescriptionCreation() {
        assertNotNull(prescription);
        assertEquals(LocalDate.of(2022, 1, 1), prescription.getDate());
        assertEquals("12345678901", prescription.getPesel());
    }

    @Test
    public void testPrescriptionIdIncrement() {
        int initialId = prescription.getPrescriptionId();
        Prescription anotherPrescription = new Prescription(LocalDate.now(), "98765432109");
        assertEquals(initialId + 1, anotherPrescription.getPrescriptionId());
    }
}
