package org.example;

public class ShopCustomerStrategy implements ICustomerStrategy {

    MainStorage mainStorage;

    private boolean deleteOrder=false;
    private Product product;
    private int quantity;

    public ShopCustomerStrategy(MainStorage mainStorage) {
        this.mainStorage = mainStorage;
    }

    @Override
    public void pay(Product product, double balance, int quantity) throws CanNotPayException, UnderMinCostException {
        int minCostLego=300000;
        int minCostBoardGame=100000;
        this.product=product;
        this.quantity=quantity;

        if (product.getType() == ProductTypeEnum.Lego){
            if (product.getPrice()*quantity>balance){
                throw new CanNotPayException("You don't have enough money to pay for the order.");
            }
            if (product.getPrice()*quantity < minCostLego){
                throw new UnderMinCostException("The cost of an order must be at least " +minCostLego+"Ft.");
            }
            for (int i = 0; i < quantity; i++) {
                mainStorage.getLegoStorage().removeProduct(product.getName());
            }
        }
        else if (product.getType()==ProductTypeEnum.BoardGame){
            if (product.getPrice()*quantity>balance){
                throw new CanNotPayException("You don't have enough money to pay for the order.");
            }
            if (product.getPrice()*quantity < minCostBoardGame){
                throw new UnderMinCostException("The cost of an order must be at least " +minCostBoardGame+"Ft.");
            }
            for (int i = 0; i < quantity; i++) {
                mainStorage.getBoardGameStorage().removeProduct(product.getName());
            }
        }
        deleteOrder = true;
    }

    @Override
    public void deleteOrder() {
        if (deleteOrder){
            if (product.getType()==ProductTypeEnum.Lego){
                for (int i = 0; i < quantity; i++) {
                    mainStorage.getLegoStorage().addProduct(product);
                }
            }
            else if (product.getType()==ProductTypeEnum.BoardGame){
                for (int i = 0; i < quantity; i++) {
                    mainStorage.getBoardGameStorage().addProduct(product);
                }
            }
            deleteOrder = true;
        }
    }
}
