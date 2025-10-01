package Strategies;

public class CardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;

    public CardPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying using Card an amount of " + amount + " Rs." + " from card number: " + cardNumber);
    }
}
