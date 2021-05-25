package org.example;

import java.util.ArrayList;

public class BoardGameStorage implements IObserver, IProductOperations{

    private final ArrayList<Product> boardGameList = new ArrayList<>();
    private MainStorage mainStorage;

    public BoardGameStorage(MainStorage mainStorage) {
        this.mainStorage=mainStorage;
        mainStorage.ObserverAdd(this);}

    @Override
    public void update(Product product, int quantity) {
        if (product.getType() == ProductTypeEnum.BoardGame)
            for (int i=0;i<quantity;i++){boardGameList.add(product);}
    }

    @Override
    public void addProduct(Product product) {
        this.boardGameList.add(product);
    }

    @Override
    public void removeProduct(String name) {
        ArrayList<Product> list = mainStorage.getBoardGameStorage().boardGameList;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getName().equals(name)){
                list.remove(i);
                return;
            }
        }
    }

    @Override
    public int getListSize() {
        return boardGameList.size();
    }
}
