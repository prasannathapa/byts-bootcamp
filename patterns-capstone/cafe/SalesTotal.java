package cafe;

// TODO: an OBSERVER that keeps a running total of every order it hears about.
public final class SalesTotal implements OrderObserver {

    private int totalCents = 0;

    @Override
    public void onOrder(String description, int cents) {
        throw new UnsupportedOperationException("TODO: add cents to totalCents");
    }

    public int totalCents() {
        return totalCents;
    }
}
