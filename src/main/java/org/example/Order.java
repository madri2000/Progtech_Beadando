package org.example;

public class Order{
    MainStorage mainStorage;
    ICustomerStrategy customerStrategy;

    public Order(MainStorage mainStorage, ICustomerStrategy customerStrategy) {
        this.mainStorage = mainStorage;
        this.customerStrategy = customerStrategy;
    }

    public void order(Product product, double balance, int quantity) throws CanNotPayException,UnderMinCostException{
        customerStrategy.pay(product,balance,quantity);
    }

    public void delete() {
        customerStrategy.deleteOrder();
    }
}

