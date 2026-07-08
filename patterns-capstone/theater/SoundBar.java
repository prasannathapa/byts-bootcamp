package theater;

// TODO: another TEMPLATE-METHOD subclass. Same locked skeleton, a different hook:
// a sound bar has no warm-up, so warmUp() returns "instant on".
public final class SoundBar extends Appliance {
    @Override
    protected String warmUp() {
        throw new UnsupportedOperationException("TODO: return \"instant on\"");
    }
}
