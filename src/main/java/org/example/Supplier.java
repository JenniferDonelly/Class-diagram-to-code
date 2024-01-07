package org.example;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
    private static ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
    private static int supplierIdCounter = 1;
    private int supplierId;
    private String name;
    private String address;

    public Supplier(String name, String address) {
        this.supplierId = supplierIdCounter++;
        suppliers.add(this);

        this.name = name;
        this.address = address;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static List<Supplier> getAllSuppliers() {
        return new ArrayList<>(suppliers);
    }
}
