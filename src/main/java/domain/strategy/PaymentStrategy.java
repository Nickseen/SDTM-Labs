package domain.strategy;

public interface PaymentStrategy {
    /**
     * Execute payment for the given amount. Returns true if payment succeeded.
     */
    boolean pay(double amount);

    /**
     * Human-friendly name/description of the strategy
     */
    String getName();
}
