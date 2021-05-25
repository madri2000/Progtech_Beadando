package org.example;

public interface ICustomerStrategy {
    void pay (Product product, double balance, int quantity) throws CanNotPayException, UnderMinCostException;
    void deleteOrder();
}
