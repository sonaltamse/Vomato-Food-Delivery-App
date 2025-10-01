package Factories;

import Strategies.PaymentStrategy;
import models.*;

import java.util.List;

public class ScheduledDeliveryFactory implements OrderFactory{
    private String scheduleTime;

    public ScheduledDeliveryFactory(String scheduleTime){
        this.scheduleTime=scheduleTime;
    }

    @Override
    public Order createOrder(User user, Cart cart, Restaurant restraunt, List<MenuList> menuItems, PaymentStrategy paymentStrategy, double totalAmount, String orderType){
        Order order = null;
        if(orderType.equals("Delivery")){
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setAddress(user.getAddress());
            deliveryOrder.setScheduled(scheduleTime);
            order = deliveryOrder;
        }
        else{
            PickUpOrder pickUpOrder = new PickUpOrder();
            pickUpOrder.setRestrauntLocation(restraunt.getAddress());
            pickUpOrder.setScheduled(scheduleTime);
            order = pickUpOrder;
        }
        order.setItems(menuItems);
        order.setTotal(totalAmount);
        order.setUser(user);
        order.setRestraunt(restraunt);
        order.setPaymentStrategy(paymentStrategy);
        return order;
    }
}
