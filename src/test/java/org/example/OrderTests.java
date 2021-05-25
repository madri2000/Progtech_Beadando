package org.example;

import org.junit.Assert;
import org.junit.Test;

public class OrderTests {

    MainStorage mainStorage = MainStorage.getInstance();

    @Test
    public void OrderLegoTest() throws CanNotPayException,UnderMinCostException {
        mainStorage.ProductImported(new Product(ProductTypeEnum.Lego,"Lego Plane", 2000),
                new ProductSupplier("Lego","Budapest","06205667894"), 500);
        int expected = mainStorage.getLegoStorage().getListSize() - 5;
        Customer customer = new Customer("Balázs", "Budapest", 30000, new PersonCustomerStrategy(mainStorage));
        customer.Order(new Product(ProductTypeEnum.Lego,"Lego Plane", 2000), customer.getBalance(),5);
        int actual = mainStorage.getLegoStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void OrderBoardGameTest() throws CanNotPayException,UnderMinCostException {
        mainStorage.ProductImported(new Product(ProductTypeEnum.BoardGame,"Dixit", 10990),
                new ProductSupplier("Reflex Shop","Budapest","06304558756"), 500);
        int expected = mainStorage.getBoardGameStorage().getListSize() - 2;
        Customer customer = new Customer("Adrienn", "Bárna", 50000, new PersonCustomerStrategy(mainStorage));
        customer.Order(new Product(ProductTypeEnum.BoardGame,"Dixit", 10990), customer.getBalance(),2);
        int actual = mainStorage.getBoardGameStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void DeleteLegoOrder() throws CanNotPayException,UnderMinCostException {
        mainStorage.ProductImported(new Product(ProductTypeEnum.Lego,"Lego Colosseum", 150000),
                new ProductSupplier("Lego","Budapest","06205667894"), 500);
        int expected = mainStorage.getLegoStorage().getListSize();
        Customer customer = new Customer("Balázs", "Budapest", 400000, new PersonCustomerStrategy(mainStorage));
        customer.Order(new Product(ProductTypeEnum.Lego,"Lego Colosseum", 150000), customer.getBalance(),2);
        customer.deleteOrder();
        int actual = mainStorage.getLegoStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void DeleteBoardGameOrder() throws CanNotPayException,UnderMinCostException {
        mainStorage.ProductImported(new Product(ProductTypeEnum.BoardGame,"Hive", 8990),
                new ProductSupplier("Reflex Shop","Budapest","06304558756"), 500);
        int expected = mainStorage.getBoardGameStorage().getListSize();
        Customer customer = new Customer("Balázs", "Budapest", 400000, new PersonCustomerStrategy(mainStorage));
        customer.Order(new Product(ProductTypeEnum.BoardGame,"Hive", 8990), customer.getBalance(),4);
        customer.deleteOrder();
        int actual = mainStorage.getBoardGameStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }
}

