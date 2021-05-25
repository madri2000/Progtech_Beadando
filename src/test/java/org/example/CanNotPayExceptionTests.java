package org.example;

import org.junit.Assert;
import org.junit.Test;

public class CanNotPayExceptionTests {

    MainStorage mainStorage = MainStorage.getInstance();

    @Test
    public void PersonCanPayTest() throws CanNotPayException,UnderMinCostException {
        Product product = new Product(ProductTypeEnum.Lego, "Lego Hedwig", 14990);
        mainStorage.ProductImported(product, new ProductSupplier("Lego","Budapest","06205667894"), 500);
        int expected = mainStorage.getLegoStorage().getListSize() - 4;
        Customer customer = new Customer("Balázs", "Budapest", 60000, new PersonCustomerStrategy(mainStorage));
        customer.Order(product, customer.getBalance(),4);
        int actual = mainStorage.getLegoStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = CanNotPayException.class)
    public void PersonCanNotPayTest() throws CanNotPayException, UnderMinCostException {
        Product product = new Product(ProductTypeEnum.Lego, "Lego Hedwig", 14990);
        mainStorage.ProductImported(product, new ProductSupplier("Lego","Budapest","06205667894"), 500);
        Customer customer = new Customer("Adrienn", "Bárna", 30000, new PersonCustomerStrategy(mainStorage));
        customer.Order(product, customer.getBalance(),4);
    }

    @Test
    public void ShopCanPayTest() throws CanNotPayException,UnderMinCostException {
        Product product = new Product(ProductTypeEnum.Lego, "Lego Hedwig", 14990);
        mainStorage.ProductImported(product, new ProductSupplier("Lego","Budapest","06205667894"), 500);
        int expected = mainStorage.getLegoStorage().getListSize() - 65;
        Customer customer = new Customer("Kockashop", "Budapest", 1000000, new ShopCustomerStrategy(mainStorage));
        customer.Order(product, customer.getBalance(),65);
        int actual = mainStorage.getLegoStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = CanNotPayException.class)
    public void ShopCanNotPayTest() throws CanNotPayException, UnderMinCostException {
        Product product = new Product(ProductTypeEnum.Lego, "Lego Hedwig", 14990);
        mainStorage.ProductImported(product, new ProductSupplier("Lego","Budapest","06205667894"), 500);
        Customer customer = new Customer("Kockashop", "Budapest", 1000000, new ShopCustomerStrategy(mainStorage));
        customer.Order(product, customer.getBalance(),100);
    }


}
