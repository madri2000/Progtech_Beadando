package org.example;

import org.junit.Assert;
import org.junit.Test;

public class StorageTests
{
    MainStorage mainStorage = MainStorage.getInstance();

    @Test
    public void MainStorageSingleton() {
        MainStorage mainStorage1 = MainStorage.getInstance();
        Object expected = mainStorage;
        Object actual = mainStorage1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void LegoStorageTest() {
        int expected = mainStorage.getLegoStorage().getListSize() + 500;
        mainStorage.ProductImported(new Product(ProductTypeEnum.Lego,"Lego Hedwig", 14990),
                new ProductSupplier("Lego","Budapest","06205667894"), 500);
        int actual = mainStorage.getLegoStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void BoardGameStorageTest() {
        int expected = mainStorage.getBoardGameStorage().getListSize() + 500;
        mainStorage.ProductImported(new Product(ProductTypeEnum.BoardGame,"Dixit", 10990),
                new ProductSupplier("Reflex Shop","Budapest","06304558756"), 500);
        int actual = mainStorage.getBoardGameStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

}
