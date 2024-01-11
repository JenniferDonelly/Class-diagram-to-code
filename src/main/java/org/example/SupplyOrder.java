package org.example;

public class SupplyOrder {
    private Medication medication;
    private Supplier supplier;
    private SupplyOrderStatus status;

    // Constructor
    public SupplyOrder(Medication medication, Supplier supplier) {
        this.medication = medication;
        this.supplier = supplier;
        this.status = SupplyOrderStatus.ORDERED;
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
}

enum SupplyOrderStatus {
    ORDERED,
    INTRANSIT,
    DELIVERED,
    CANCELLED
}
