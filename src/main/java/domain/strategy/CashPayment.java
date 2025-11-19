package domain.strategy;

public class CashPayment implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing cash payment of $" + String.format("%.2f", amount) + " — completed.");
        return true;
    }

    @Override
    public String getName() {
        return "Cash";
    }
}
