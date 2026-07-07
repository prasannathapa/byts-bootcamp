package cafe;

import java.util.ArrayList;
import java.util.List;

// TODO: the SUBJECT in Observer. Keep the list of subscribers (given below); when an
// order is placed, price the drink and then tell every subscriber about it.
// Notice placeOrder uses all three earlier patterns at once:
//   drink.cents() / drink.description() -> DECORATOR
//   discount.applyTo(...)               -> STRATEGY
//   telling each subscriber             -> OBSERVER
public final class Counter {

    private final List<OrderObserver> observers = new ArrayList<>();

    public void subscribe(OrderObserver observer) {
        throw new UnsupportedOperationException("TODO: observers.add(observer)");
    }

    public int placeOrder(Beverage drink, Discount discount) {
        // TODO: price = discount.applyTo(drink.cents());
        //       for each observer: observer.onOrder(drink.description(), price);
        //       return price;
        throw new UnsupportedOperationException("TODO: price it, notify every observer, return the price");
    }
}
