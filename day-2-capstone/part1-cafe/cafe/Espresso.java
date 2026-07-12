package cafe;

// A base drink. Given to you, complete, as an example of the shape.
public final class Espresso implements Beverage {
    @Override public String description() { return "Espresso"; }
    @Override public int cents() { return 200; }
}
