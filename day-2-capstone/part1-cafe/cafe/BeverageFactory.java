package cafe;

// TODO: a FACTORY. Given a name, return the matching base Beverage:
//   "espresso" -> a new Espresso
//   "tea"      -> a new Tea
//   anything else -> throw new IllegalArgumentException("unknown beverage: " + name)
// Be forgiving about the input: trim spaces and ignore case, so " Espresso " still works.
// The caller asks by name and gets back a Beverage. It never writes `new Espresso()` itself.
public final class BeverageFactory {
    public Beverage create(String name) {
        throw new UnsupportedOperationException("TODO: build the beverage that matches name");
    }
}
