package models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static int nextRestrauntID=0;
    private int restrauntID;
    private String name;
    private String address;
    List<MenuList> dishes = new ArrayList<>();

    public Restaurant(String name, String address){
        this.name=name;
        this.address=address;
        this.restrauntID=++nextRestrauntID;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public List<MenuList> getDishes(){
        return dishes;
    }

    public void addDish(MenuList dish){
        dishes.add(dish);
    }

    public int getRestrauntID(){
        return restrauntID;
    }

    public void setAddress(String address){
        this.address=address;
    }
}
