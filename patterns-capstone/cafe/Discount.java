package cafe;

// A pricing STRATEGY: given a price in cents, return the price after this discount.
// One method, so an order can hold a Discount and swap which one without changing.
@FunctionalInterface
public interface Discount {
    int applyTo(int cents);
}
