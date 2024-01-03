package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SupplyOrderTest {

    private Manager manager;
    private Medication medication;
    private Supplier supplier;
    private SupplyOrder order;

    @BeforeEach
    public void setup() {
        manager = new Manager("Jane", "Doe", "123456789", "1234567890123", 20, 0);
        medication = new Medication("Med red", 90);
        supplier = new Supplier("Best Meds Supplier", "123 Pharma Street");
        order = SupplyOrder.orderMedicine(manager, medication, supplier);
    }

    @Test
    public void testOrderCreation() {
        assertNotNull(order);
        assertEquals(manager, order.getOrderedBy());
        assertEquals(medication, order.getMedication());
        assertEquals(supplier, order.getSupplier());
        assertEquals(SupplyOrderStatus.ORDERED, order.getStatus());
    }

    @Test
    public void testOrderIdIncrement() {
        SupplyOrder anotherOrder = SupplyOrder.orderMedicine(manager, medication, supplier);
        assertNotEquals(order.getOrderId(), anotherOrder.getOrderId()); // Each order should have a unique ID
    }

    @Test
    public void testStatusChange() {
        order.setStatus(SupplyOrderStatus.INTRANSIT);
        assertEquals(SupplyOrderStatus.INTRANSIT, order.getStatus());

        order.setStatus(SupplyOrderStatus.DELIVERED);
        assertEquals(SupplyOrderStatus.DELIVERED, order.getStatus());
    }
}
