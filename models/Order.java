package models;

import Strategies.PaymentStrategy;

import java.util.List;

public abstract class Order {
    private static int nextOrderID=0;

    protected int orderID;
    protected double total;
    protected String scheduled;
    protected User user;
    protected Restaurant restraunt;
    protected List<MenuList> items;
    protected PaymentStrategy paymentStrategy;

    public Order(){
        this.user=null;
        this.restraunt=null;
        this.items=null;
        this.orderID=++nextOrderID;
        this.total=0;
        this.scheduled="pending";
    }

    public boolean processPayment(){
        if(paymentStrategy != null){
            paymentStrategy.pay(total);
            return true;
        }
        else{
            System.out.println("Please select your payment mode!");
            return false;
        }
    }

    public abstract String getOrderType();

    public int getOrderID() {
        return orderID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getScheduled(){
        return scheduled;
    }

    public void setScheduled(String scheduled){
        this.scheduled=scheduled;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User u){
        this.user=u;
    }

    public Restaurant getRestrauntName(){
        return restraunt;
    }

    public void setRestraunt(Restaurant r){
        this.restraunt=r;
    }

    public List<MenuList> getItems(){
        return items;
    }

    public void setItems(List<MenuList> itemList){
        items = itemList;
        total=0;
        for(MenuList item:items){
            total+=item.getPrice();
        }
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }
}
