package app.product.ss01.modal.entity;

public interface InventoryRepository {
    int getStock(String foodName);
    void reduceStock(String foodName, int quantity);
}