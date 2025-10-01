import Factories.InstantDeliveryFactory;
import Factories.OrderFactory;
import Factories.ScheduledDeliveryFactory;
import Managers.OrderManager;
import Managers.RestaurantManager;
import Services.NotificationService;
import Strategies.PaymentStrategy;
import models.*;

import java.util.List;

public class VomatoApp {

    public VomatoApp() {
        initializeRestaurants();
    }

    public void initializeRestaurants() {
        Restaurant restaurant1 = new Restaurant("Shree Rathnam", "Karnataka");
        restaurant1.addDish(new MenuList("P1", "Paneer Tikka", 150));
        restaurant1.addDish(new MenuList("P2", "Veg Biryani", 130));

        Restaurant restaurant2 = new Restaurant("Anand Bhavan", "Hyderabad");
        restaurant2.addDish(new MenuList("P1", "Gongura Pickle", 40));
        restaurant2.addDish(new MenuList("P2", "Mirchi Bajji", 25));
        restaurant2.addDish(new MenuList("P3", "Hyderabadi Dum Biryani", 180));

        Restaurant restaurant3 = new Restaurant("Aromas of Kerala", "Kochi");
        restaurant3.addDish(new MenuList("P1", "Appam with Stew", 90));
        restaurant3.addDish(new MenuList("P2", "Puttu Kadala", 70));
        restaurant3.addDish(new MenuList("P3", "Banana Chips", 50));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        restaurantManager.addRestaurant(restaurant3);
    }

    public List<Restaurant> searchRestaurants(String location) {
        return RestaurantManager.getInstance().getRestrauntsByLocation(location);
    }

    public void selectRestaurant(User user, Restaurant restaurant) {
        user.getCart().setRestraunt(restaurant);
        System.out.println("Restaurant Selected: " + restaurant.getName());
    }

    public void addToCart(User user, String itemCode) {
        Restaurant restaurant = user.getCart().getRestraunt();
        if (restaurant == null) {
            System.out.println("Please select a restaurant first");
            return;
        }
        for (MenuList item : restaurant.getDishes()) {
            if (item.getName().equals(itemCode)) {
                user.getCart().addDish(item);
                break;
            }
        }
    }

    public Order checkoOutInstant(User user, String orderType, PaymentStrategy paymentStrategy) {
        return checkOut(user, orderType, paymentStrategy, new InstantDeliveryFactory());
    }

    public Order checkoOutScheduled(User user, String orderType, PaymentStrategy paymentStrategy, String scheduleTime) {
        return checkOut(user, orderType, paymentStrategy, new ScheduledDeliveryFactory(scheduleTime));
    }

    public Order checkOut(User user, String orderType, PaymentStrategy paymentStrategy, OrderFactory orderFactory) {
        if (user.getCart().isEmpty())
            return null;
        Order order = orderFactory.createOrder(user, user.getCart(), user.getCart().getRestraunt(),
                user.getCart().getItems(),
                paymentStrategy, user.getCart().getTotal(), orderType);
        OrderManager.getInstance().addOrder(order);
        System.out.println(
                "Order placed with order id: " + order.getOrderID() + " and total amount: " + order.getTotal());
        return order;
    }

    public void payOrder(User user, Order order) {
        boolean paymentStatus = order.processPayment();
        if (paymentStatus) {
            System.out.println("Payment successful");
            NotificationService.sendNotification(order);
            user.getCart().clear();
        } else {
            System.out.println("Payment failed");
        }
    }

    public void printCart(User user) {
        System.out.println("Items in cart:");
        System.out.println("------------------------------------");
        for (MenuList item : user.getCart().getItems()) {
            System.out.println(item.getName() + " : " + item.getCode() + " : Rs" + item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : Rs" + user.getCart().getTotal());
    }
}
