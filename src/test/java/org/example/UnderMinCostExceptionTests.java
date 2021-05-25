package org.example;

import org.junit.Test;

public class UnderMinCostExceptionTests {

    MainStorage mainStorage = MainStorage.getInstance();

    @Test(expected = UnderMinCostException.class)
    public void LegoUnderMinCostException() throws CanNotPayException, UnderMinCostException {
        Product product = new Product(ProductTypeEnum.Lego, "Lego Hedwig", 14990);
        mainStorage.ProductImported(product, new ProductSupplier("Lego","Budapest","06205667894"), 500);
        Customer customer = new Customer("Kockashop", "Budapest", 1000000, new ShopCustomerStrategy(mainStorage));
        customer.Order(product, customer.getBalance(),10);
    }

    @Test(expected = UnderMinCostException.class)
    public void BoardGameUnderMinCostException() throws CanNotPayException, UnderMinCostException {
        Product product = new Product(ProductTypeEnum.BoardGame, "Dixit", 10990);
        mainStorage.ProductImported(product, new ProductSupplier("Reflex Shop","Budapest","06304558756"), 500);
        Customer customer = new Customer("Kockashop", "Budapest", 500000, new ShopCustomerStrategy(mainStorage));
        customer.Order(product, customer.getBalance(),5);
    }
}
