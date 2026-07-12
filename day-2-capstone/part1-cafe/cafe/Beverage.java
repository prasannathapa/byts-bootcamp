package cafe;

// A drink. Everything - base drinks AND add-ons - is a Beverage. That single shared
// interface is what lets add-ons wrap drinks and still be treated as drinks (Decorator).
public interface Beverage {
    String description();
    int cents();            // price in whole cents (money in floating point rounds wrong)
}
