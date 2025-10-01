package Strategies;

public class UPIPaymentStrategy implements PaymentStrategy {
    private String upiId;

    public UPIPaymentStrategy(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying using UPI an amount of " + amount + " Rs." + " from UPI ID: " + upiId);
    }
}
