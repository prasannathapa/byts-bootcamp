package editor;

import java.util.ArrayDeque;
import java.util.Deque;

// The editor is the shared context for three patterns:
//   CP1 Command - run/undo/redo drive Command objects and keep two history stacks
//   CP2 Memento - snapshot/restore capture and put back the whole buffer
//   CP3 State   - type(c) delegates to the current Mode, which decides what a keystroke does
public final class Editor {
    final StringBuilder buf = new StringBuilder();          // package-private: commands and modes edit it
    private final Deque<Command> undo = new ArrayDeque<>();
    private final Deque<Command> redo = new ArrayDeque<>();
    private Mode mode = new InsertMode();

    public String text() {
        return buf.toString();
    }

    // ---- CP1: Command ----
    public void run(Command c) {
        throw new UnsupportedOperationException("TODO CP1: execute the command, push it on the undo stack, and clear the redo stack");
    }

    public void undo() {
        throw new UnsupportedOperationException("TODO CP1: pop the last command off undo, undo() it, and push it on redo (do nothing if undo is empty)");
    }

    public void redo() {
        throw new UnsupportedOperationException("TODO CP1: pop from redo, execute() it again, and push it back on undo (do nothing if redo is empty)");
    }

    // ---- CP2: Memento ----
    public Memento snapshot() {
        throw new UnsupportedOperationException("TODO CP2: capture the current text as a new Memento");
    }

    public void restore(Memento m) {
        throw new UnsupportedOperationException("TODO CP2: replace the buffer with the snapshot's text, and reset the undo/redo history");
    }

    // ---- CP3: State ----
    public void setMode(Mode m) {
        this.mode = m;
    }

    public String mode() {
        return mode.name();
    }

    public void type(char c) {
        mode.type(this, c);    // the current state decides what happens
    }
}

// An opaque snapshot of the editor's text. Only the editor can read its state back.
final class Memento {
    private final String state;

    Memento(String state) {
        this.state = state;
    }

    String state() {
        return state;
    }
}
