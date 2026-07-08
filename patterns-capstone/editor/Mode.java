package editor;

// CP3: the State pattern. The editor holds a Mode; the mode decides what a keystroke does.
// Swapping the object swaps the behaviour - no if/else on a "current mode" flag.
public interface Mode {
    void type(Editor ed, char c);
    String name();
}

final class InsertMode implements Mode {
    public void type(Editor ed, char c) {
        throw new UnsupportedOperationException("TODO CP3: INSERT mode - append the character to ed.buf");
    }

    public String name() {
        return "INSERT";
    }
}

final class ReadOnlyMode implements Mode {
    public void type(Editor ed, char c) {
        throw new UnsupportedOperationException("TODO CP3: READONLY mode - ignore the keystroke and leave the buffer unchanged (the body can simply be empty)");
    }

    public String name() {
        return "READONLY";
    }
}
