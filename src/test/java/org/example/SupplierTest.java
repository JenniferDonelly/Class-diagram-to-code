package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SupplierTest {

    private Supplier supplier;

    @BeforeEach
    public void setup() {
        // Resetting the static suppliers list before each test
        supplier = new Supplier("Generic Pharmaceuticals", "123 Medicine Lane");
    }

    @Test
    public void testSupplierCreation() {
        assertNotNull(supplier);
        assertEquals("Generic Pharmaceuticals", supplier.getName());
        assertEquals("123 Medicine Lane", supplier.getAddress());
    }

    @Test
    public void testSupplierListManagement() {
        List<Supplier> allSuppliers = Supplier.getAllSuppliers();
        assertTrue(allSuppliers.contains(supplier));

        // Assuming new suppliers are added
        Supplier anotherSupplier = new Supplier("Another Supplier", "456 Another St");
        allSuppliers = Supplier.getAllSuppliers();
        assertTrue(allSuppliers.contains(anotherSupplier));
        assertTrue(allSuppliers.contains(supplier)); // Still contains the first supplier
    }

    @Test
    public void testSupplierIdIncrement() {
        int initialId = supplier.getSupplierId();
        Supplier anotherSupplier = new Supplier("Another Supplier", "456 Another St");
        assertEquals(1, anotherSupplier.getSupplierId() - initialId); // IDs should increment by 1
    }
}
