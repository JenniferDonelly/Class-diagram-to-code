package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IncidentReportTest {

    private Employee employee;
    private IncidentReport incidentReport;

    @BeforeEach
    public void setup() {
        employee = new Employee("John", "Doe", "1234567890", "1234567890123", 15); // Assuming a simple constructor or mock for Employee
        incidentReport = IncidentReport.enterAnIncidentReport("Accident at Lab", "Chemical spill occurred", employee);
    }

    @Test
    public void testIncidentReportCreation() {
        assertNotNull(incidentReport);
        assertEquals("Accident at Lab", incidentReport.getName());
        assertEquals("Chemical spill occurred", incidentReport.getDescription());
    }

    @Test
    public void testIncidentReportIdIncrement() {
        IncidentReport anotherReport = IncidentReport.enterAnIncidentReport("Equipment Failure", "Microscope not working", employee);
        assertNotEquals(incidentReport.getReportId(), anotherReport.getReportId()); // Each report should have a unique ID
    }
}
