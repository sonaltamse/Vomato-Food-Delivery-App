package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restaurant restraunt;
    private List<MenuList> items = new ArrayList<>();

    public Cart() {
        restraunt = null;
    }

    public void addDish(MenuList menu) {
        if(restraunt == null){
            System.out.println("Please select a restraunt first");
            return;
        }
        items.add(menu);
    }

    public double getTotal() {
        double total = 0;
        for(MenuList menu:items){
            total += menu.getPrice();
        }
        return total;
    }

    public boolean isEmpty() {
        return restraunt==null || items.isEmpty();
    }

    public void clear(){
        items.clear();
        restraunt = null;
    }

    public Restaurant getRestraunt() {
        return restraunt;
    }

    public void setRestraunt(Restaurant restraunt) {
        this.restraunt = restraunt;
    }

    public List<MenuList> getItems() {
        return items;
    }
}
