package cafe;

// An OBSERVER: something that wants to hear about each order the counter places.
// One method, so a small class (or even a lambda) can subscribe. The counter does
// not know or care who is listening, or how many - it just calls onOrder on each.
@FunctionalInterface
public interface OrderObserver {
    void onOrder(String description, int cents);
}
