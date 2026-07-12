package cafe;

// TODO: another DECORATOR, exactly like Milk but:
//   description() -> base.description() + ", syrup"
//   cents()       -> base.cents() + 75
public final class Syrup implements Beverage {

    private final Beverage base;

    public Syrup(Beverage base) {
        this.base = base;
    }

    @Override
    public String description() {
        throw new UnsupportedOperationException("TODO: base.description() + \", syrup\"");
    }

    @Override
    public int cents() {
        throw new UnsupportedOperationException("TODO: base.cents() + 75");
    }
}
