package Factories;

import Strategies.PaymentStrategy;
import Utils.TimeUtils;
import models.*;

import java.util.List;

public class InstantDeliveryFactory implements OrderFactory{
    @Override
    public Order createOrder(User user, Cart cart, Restaurant restraunt, List<MenuList> menuItems, PaymentStrategy paymentStrategy, double totalAmount, String orderType){
        Order order = null;
        if(orderType.equals("Delivery")){
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setAddress(user.getAddress());
            order = deliveryOrder;
        }
        else{
            PickUpOrder pickUpOrder = new PickUpOrder();
            pickUpOrder.setRestrauntLocation(restraunt.getAddress());
            order = pickUpOrder;
        }
        order.setItems(menuItems);
        order.setTotal(totalAmount);
        order.setUser(user);
        order.setRestraunt(restraunt);
        order.setScheduled(TimeUtils.getCurrentTime());
        order.setPaymentStrategy(paymentStrategy);
        return order;
    }
}
