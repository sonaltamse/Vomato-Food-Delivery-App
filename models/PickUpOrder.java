package models;

public class PickUpOrder extends Order{
    private String restrauntLocation;

    public PickUpOrder(){
        restrauntLocation="";
    }
    public String getRestrauntLocation(){
        return restrauntLocation;
    }
    public void setRestrauntLocation(String address){
        this.restrauntLocation=address;
    }
    @Override
    public String getOrderType(){
        return "Pick Up";
    }
}
