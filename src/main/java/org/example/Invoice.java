package org.example;

import java.util.Objects;

public class Invoice {
    private String costumerName;
    private String address;
    private int quantity;
    private Product product;

    public Invoice(String costumerName, String address, int quantity, Product product) {
        this.costumerName = costumerName;
        this.address = address;
        this.quantity = quantity;
        this.product = product;
    }

    double GetFullPrice() {
        return product.getPrice() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "costumerName='" + costumerName + '\'' +
                ", address='" + address + '\'' +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return quantity == invoice.quantity &&
                Objects.equals(costumerName, invoice.costumerName) &&
                Objects.equals(address, invoice.address) &&
                Objects.equals(product, invoice.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(costumerName, address, quantity, product);
    }
}
