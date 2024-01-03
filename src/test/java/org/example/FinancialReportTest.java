package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.LocalDate;

public class FinancialReportTest {

    private FinancialReport report;

    @BeforeEach
    public void setup() {
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 1, 31);
        report = FinancialReport.generateFinancialReport(startDate, endDate);
    }

    @Test
    public void testReportCreation() {
        assertNotNull(report);
        assertEquals("Financial Report from 2022-01-01 to 2022-01-31", report.getTitle());
        assertEquals(LocalDate.of(2022, 1, 1), report.getStartDate());
        assertEquals(LocalDate.of(2022, 1, 31), report.getEndDate());
        assertEquals(0.0, report.getTotalRevenue()); // and similarly for other numerical fields
    }

    @Test
    public void testAttachmentManagement() {
        File mockFile = new File("mock/path/to/file.txt");
        report.addAttachment(mockFile);
        assertTrue(report.getAttachments().contains(mockFile));

        report.removeAttachment(mockFile);
        assertFalse(report.getAttachments().contains(mockFile));
    }

    @Test
    public void testReportVerification() {
        assertFalse(report.isVerified()); // Assuming isVerified() is a method returning the verified status
        report.verifyReport();
        assertTrue(report.isVerified());
    }

    @Test
    public void testReportIdIncrement() {
        int initialId = report.getReportId();
        FinancialReport anotherReport = FinancialReport.generateFinancialReport(LocalDate.now(), LocalDate.now());
        assertEquals(1, anotherReport.getReportId() - initialId); // IDs should increment by 1
    }
}
