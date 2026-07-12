package cafe;

// TODO: a DECORATOR. It IS a Beverage, and it WRAPS a Beverage (already stored for you below).
// Implement the two methods by delegating to the wrapped drink, then adding milk's bit:
//   description() -> base.description() + ", milk"
//   cents()       -> base.cents() + 50
// Note you wrap a Beverage, not a specific drink - that is exactly why milk works on an
// espresso OR a tea OR another decorator. Do NOT make Milk extend Espresso.
public final class Milk implements Beverage {

    private final Beverage base;

    public Milk(Beverage base) {
        this.base = base;
    }

    @Override
    public String description() {
        throw new UnsupportedOperationException("TODO: base.description() + \", milk\"");
    }

    @Override
    public int cents() {
        throw new UnsupportedOperationException("TODO: base.cents() + 50");
    }
}
