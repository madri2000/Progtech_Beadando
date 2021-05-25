package org.example;

public class ProductSupplier {

    private String supplierName;
    private String address;
    private String phoneNumber;

    public String getSupplierName() {
        return supplierName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ProductSupplier(String supplierName, String address, String phoneNumber) {
        this.supplierName = supplierName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
