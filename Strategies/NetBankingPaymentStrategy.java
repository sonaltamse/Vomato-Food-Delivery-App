package Strategies;

public class NetBankingPaymentStrategy implements PaymentStrategy {
    private String accountNumber;

    public NetBankingPaymentStrategy(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println(
                "Paying using Net Banking an amount of " + amount + " Rs." + " from account number: " + accountNumber);
    }
}
