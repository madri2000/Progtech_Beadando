package org.example;

import java.util.ArrayList;

public class LegoStorage implements IObserver, IProductOperations{

    private final ArrayList<Product> legoList = new ArrayList<>();
    private MainStorage mainStorage;

    public LegoStorage(MainStorage mainStorage) {
        this.mainStorage=mainStorage;
        mainStorage.ObserverAdd(this);}

    @Override
    public void update(Product product, int quantity) {
        if (product.getType() == ProductTypeEnum.Lego)
            for (int i=0;i<quantity;i++){legoList.add(product);}
    }

    @Override
    public void addProduct(Product product) {
        this.legoList.add(product);
    }

    @Override
    public void removeProduct(String name) {
        ArrayList<Product> list = mainStorage.getLegoStorage().legoList;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getName().equals(name)){
                list.remove(i);
                return;
            }
        }
    }

    @Override
    public int getListSize() {
        return legoList.size();
    }
}
