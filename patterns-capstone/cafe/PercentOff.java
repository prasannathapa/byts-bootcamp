package cafe;

// TODO: a "percent off" STRATEGY. Constructed with a percentage (e.g. 20 means 20% off).
//   applyTo(500) with 20% off  ->  400
//   Use integer maths: cents - (cents * percent / 100).
public final class PercentOff implements Discount {

    private final int percent;

    public PercentOff(int percent) {
        this.percent = percent;
    }

    @Override
    public int applyTo(int cents) {
        throw new UnsupportedOperationException("TODO: subtract percent% of cents");
    }
}
