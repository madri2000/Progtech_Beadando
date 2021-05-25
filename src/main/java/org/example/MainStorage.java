package org.example;

import java.util.ArrayList;

public final class MainStorage implements IObserverInfo {

    static MainStorage mainStorage=null;

    public static MainStorage getInstance(){
        if(mainStorage==null) mainStorage = new MainStorage();
        return mainStorage;
    }
    private ArrayList<IObserver> observerList = new ArrayList<>();
    LegoStorage legoStorage;
    BoardGameStorage boardGameStorage;

    private MainStorage(){
        this.legoStorage=new LegoStorage(this);
        this.boardGameStorage=new BoardGameStorage(this);
    }

    public LegoStorage getLegoStorage() {
        return legoStorage;
    }

    public BoardGameStorage getBoardGameStorage() {
        return boardGameStorage;
    }

    public void ProductImported(Product product,ProductSupplier productSupplier, int quantity) {
        product.setProductSupplier(productSupplier);
        ObserverInform(product, quantity);}

    @Override
    public void ObserverAdd(IObserver observer) {
    observerList.add(observer);
    }

    @Override
    public void ObserverInform(Product product, int quantity) {
    for (IObserver observer:observerList){
        observer.update(product, quantity);
    }
    }
}
