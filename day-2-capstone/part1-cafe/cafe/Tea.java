package cafe;

// A base drink. Given to you, complete.
public final class Tea implements Beverage {
    @Override public String description() { return "Tea"; }
    @Override public int cents() { return 150; }
}
