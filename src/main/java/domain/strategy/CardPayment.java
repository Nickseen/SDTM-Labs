package domain.strategy;

public class CardPayment implements PaymentStrategy {

    private final double cardFeeRate = 0.02; // 2% fee

    @Override
    public boolean pay(double amount) {
        double fee = amount * cardFeeRate;
        double total = amount + fee;
        System.out.println("Processing card payment: amount=$" + String.format("%.2f", amount)
                + ", fee=$" + String.format("%.2f", fee) + ", total=$" + String.format("%.2f", total));
        System.out.println("Payment completed via card.");
        return true;
    }

    @Override
    public String getName() {
        return "Card (2% fee)";
    }
}
