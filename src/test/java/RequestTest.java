package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class RequestTest {
    Employee creator;
    Manager reviewer;

    @BeforeEach
    public void setup() {
        // Initialize with mock data
        creator = new Employee("John", "Doe", "1234567890", "1234567890123", 15);
        reviewer = new Manager("Jane", "Doe", "0987654321", "9876543210987", 20, 0);
    }

    @Test
    public void testRequestCreation() {
        Request request = Request.requestNewMedicine(creator, "Paracetamol", "For headaches");

        assertEquals("Paracetamol", request.getName());
        assertEquals("For headaches", request.getDescription());
        assertEquals(RequestType.NEW_MED, request.getRequestType());
        assertEquals(creator, request.getCreator());
        assertFalse(request.isReviewed());
    }

    @Test
    public void testReviewProcess() {
        Request request = Request.requestResupply(creator, "Ibuprofen", "For inflammation");
        assertFalse(request.isReviewed()); // Should not be reviewed yet

        request.review(reviewer, true); // Reviewing the request

        assertTrue(request.isReviewed());
        assertEquals(reviewer, request.getReviewer());
        assertTrue(request.isAccepted());
        assertNotNull(request.getReviewDate());
    }

    @Test
    public void testRequestIdIncrement() {
        int initialId = Request.requestNewMedicine(creator, "Drug A", "Description A").getRequestId();
        int nextId = Request.requestNewMedicine(creator, "Drug B", "Description B").getRequestId();
        assertEquals(1, nextId - initialId); // IDs should increment by 1
    }
}
