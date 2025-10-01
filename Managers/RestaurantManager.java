package Managers;

import models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {
    List<Restaurant> restraunts = new ArrayList<>();
    private static RestaurantManager instance = null;

    private RestaurantManager() {
    }

    public static RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Restaurant restraunt) {
        restraunts.add(restraunt);
    }

    public void addRestraunts() {
        for (Restaurant restraunt : restraunts) {
            System.out.println(restraunt.getName() + " " + restraunt.getAddress());
        }
    }

    public List<Restaurant> getRestrauntsByLocation(String location) {
        List<Restaurant> restrauntsResults = new ArrayList<>();
        location = location.toLowerCase();
        for (Restaurant restraunt : restraunts) {
            String rl = restraunt.getAddress().toLowerCase();
            if (rl.equals(location)) {
                restrauntsResults.add(restraunt);
            }
        }
        return restrauntsResults;
    }
}
