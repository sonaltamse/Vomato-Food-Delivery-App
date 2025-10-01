package Factories;

import Strategies.PaymentStrategy;
import models.*;
import java.util.List;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restraunt, List<MenuList> menuItems, PaymentStrategy paymentStrategy, double totalCost, String orderType);
}
