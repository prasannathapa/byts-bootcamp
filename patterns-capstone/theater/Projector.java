package theater;

// TODO: a TEMPLATE-METHOD subclass. Do NOT (and cannot) touch startUp() - it is final on
// purpose. Fill ONLY the hook: a projector warms its bulb, so warmUp() returns "warming the bulb".
public final class Projector extends Appliance {
    @Override
    protected String warmUp() {
        throw new UnsupportedOperationException("TODO: return \"warming the bulb\"");
    }
}
