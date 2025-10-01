import Factories.InstantDeliveryFactory;
import Strategies.UPIPaymentStrategy;
import models.Order;
import models.Restaurant;
import models.User;

public class Main {
    public static void main(String[] args) {
        VomatoApp vomato = new VomatoApp();

        User user = new User(1, "Sonal", "Karnataka");
        System.out.println("User: " + user.getName() + " is active.");

        java.util.List<Restaurant> restaurantList = vomato.searchRestaurants("Kochi");

        if (restaurantList.isEmpty()) {
            System.out.println("No restaurants found!");
            return;
        }

        System.out.println("Found Restaurants:");
        for (Restaurant restaurant : restaurantList) {
            System.out.println(" - " + restaurant.getName());
        }

        vomato.selectRestaurant(user, restaurantList.get(0));

        vomato.addToCart(user, "P1");
        vomato.addToCart(user, "P2");
        vomato.printCart(user);
        Order order = vomato.checkOut(user, "Delivery", new UPIPaymentStrategy("1234567890"),
                new InstantDeliveryFactory());
        vomato.payOrder(user, order);
    }
}
