package domain.strategy;

public class LeasingPayment implements PaymentStrategy {

    private final int months = 36;
    private final double annualRate = 0.05; // 5% yearly interest

    @Override
    public boolean pay(double amount) {
        double monthlyRate = annualRate / 12.0;
        double monthly = (amount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
        System.out.println("Processing leasing for $" + String.format("%.2f", amount) + " over " + months + " months.");
        System.out.println("Estimated monthly payment: $" + String.format("%.2f", monthly));
        System.out.println("Leasing contract simulated (no real payment). ");
        return true;
    }

    @Override
    public String getName() {
        return "Leasing (36 months)";
    }
}
