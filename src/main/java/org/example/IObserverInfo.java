package org.example;

public interface IObserverInfo {
    void ObserverAdd(IObserver observer);
    void ObserverInform(Product product, int quantity);
}
