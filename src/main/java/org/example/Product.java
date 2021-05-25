package org.example;

import java.util.Objects;

public class Product {

    private ProductTypeEnum type;
    private String name;
    private double price;
    ProductSupplier productSupplier;

    public Product(ProductTypeEnum type,String name,double price){
        this.type=type;
        this.name=name;
        this.price=price;
    }

    public void setProductSupplier(ProductSupplier productSupplier){this.productSupplier=productSupplier;}

    public ProductTypeEnum getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                type == product.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, type);
    }
}
