package org.example;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceTest {

    MainStorage mainStorage = MainStorage.getInstance();

    @Test
    public void GiveInvoice() throws CanNotPayException,UnderMinCostException {
        Product product = new Product(ProductTypeEnum.BoardGame, "Dixit", 10990);
        mainStorage.ProductImported(product, new ProductSupplier("Reflex Shop","Budapest","06304558756"), 500);
        Customer customer = new Customer("Adrienn", "Bárna", 100000, new PersonCustomerStrategy(mainStorage));
        Invoice actual = customer.Order(product, customer.getBalance(),4);
        Invoice expected = new Invoice("Adrienn", "Bárna", 4, product);
        Assert.assertEquals(expected, actual);
    }
}
