package cafe;

// TODO: the "no discount" STRATEGY - return the price unchanged.
public final class NoDiscount implements Discount {
    @Override
    public int applyTo(int cents) {
        throw new UnsupportedOperationException("TODO: return cents unchanged");
    }
}
