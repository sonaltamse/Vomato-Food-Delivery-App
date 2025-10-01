package Services;

import models.MenuList;
import models.Order;

import java.util.List;

public class NotificationService {
        public static void sendNotification(Order order) {
                System.out.println(
                                "\nNotification: " + order.getOrderType() + " Order for " + order.getTotal()
                                                + " Rs. has been placed.");
                System.out.println(
                                "********************************************************************************************");
                System.out.println("Order Details: ");
                System.out.println("Order Id: " + order.getOrderID());
                System.out.println("Restraunt: " + order.getRestrauntName().getName());
                System.out.println(
                                "********************************************************************************************");
                System.out.println("Cutomer Details: ");
                System.out.println(
                                "Name: " + order.getUser().getName() + " | Address: " + order.getUser().getAddress());
                System.out.println(
                                "********************************************************************************************");
                System.out.println("Menu Details: ");
                List<MenuList> items = order.getItems();
                for (MenuList item : items) {
                        System.out.println(item.getName() + " " + item.getPrice() + " Rs.");
                }
                System.out.println(
                                "********************************************************************************************");
                System.out.println("Thank you for ordering at " + order.getRestrauntName().getName() + "!\n");
        }
}
