package app.product.ss01.Service;

import app.product.ss01.modal.entity.InventoryRepository;
import app.product.ss01.modal.entity.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderFoodService {

    private final InventoryRepository inventoryRepository;
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public OrderFoodService(InventoryRepository inventoryRepository,
                            UserAccountRepository userAccountRepository) {
        this.inventoryRepository = inventoryRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public String orderFood(String username, String foodName, int quantity) {

        int stock = inventoryRepository.getStock(foodName);

        if (stock < quantity) {
            return "Hết hàng";
        }

        double price = 50000;
        double total = price * quantity;

        double balance = userAccountRepository.getBalance(username);

        if (balance < total) {
            return "Không đủ tiền";
        }

        inventoryRepository.reduceStock(foodName, quantity);
        userAccountRepository.deductBalance(username, total);

        return "Đặt món thành công";
    }
}