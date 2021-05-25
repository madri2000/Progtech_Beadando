package org.example;

public class Customer {
    private String name;
    private String address;
    private double balance;
    Order orders;

    public Customer(String name, String address, double balance, ICustomerStrategy customerStrategy) {
        this.name = name;
        this.address = address;
        this.balance = balance;
        this.orders = new Order(MainStorage.getInstance(),customerStrategy);
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Invoice Order(Product product, double balance, int quantity) throws CanNotPayException,UnderMinCostException {
        Invoice invoice = new Invoice(getName(),getAddress(),quantity,product);
        orders.order(product,balance,quantity);
        return invoice;
    }

    public void deleteOrder(){orders.delete();
    }
}
