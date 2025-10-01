package models;

public class MenuList {
    private String name, code;
    private double price;

    public MenuList(String name, String code, double price) {
        this.name = name;
        this.price = price;
        this.code = code;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
