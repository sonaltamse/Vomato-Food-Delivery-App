package models;

public class DeliveryOrder extends Order{
    private String address;

    public DeliveryOrder(){
        address="";
    }

    @Override
    public String getOrderType(){
        return "Delivery";
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address=address;
    }
}
