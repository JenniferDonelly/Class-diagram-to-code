package org.example;

import java.util.ArrayList;
import java.util.List;

public class SupplyOrder {
    private static int nextOrderId = 1;
    private int orderId;
    private Manager orderedBy;
    private Medication medication;
    private Supplier supplier;
    private SupplyOrderStatus status;

    // Constructor
    private SupplyOrder(Manager orderedBy, Medication medication, Supplier supplier) {
        this.orderId = nextOrderId++;
        this.orderedBy = orderedBy;
        this.medication = medication;
        this.supplier = supplier;
        this.status = SupplyOrderStatus.ORDERED;
    }

    public int getOrderId() {
        return orderId;
    }

    public Manager getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(Manager orderedBy) {
        this.orderedBy = orderedBy;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public SupplyOrderStatus getStatus() {
        return status;
    }

    public void setStatus(SupplyOrderStatus status) {
        this.status = status;
    }

    public static SupplyOrder orderMedicine(Manager manager, Medication medication, Supplier supplier) {
        return new SupplyOrder(manager, medication, supplier);
    }
}

enum SupplyOrderStatus {
    ORDERED,
    INTRANSIT,
    DELIVERED,
    CANCELLED
}
