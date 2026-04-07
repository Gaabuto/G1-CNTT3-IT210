package app.product.ss01.modal.entity;

public interface UserAccountRepository {
    double getBalance(String username);
    void deductBalance(String username, double amount);
}