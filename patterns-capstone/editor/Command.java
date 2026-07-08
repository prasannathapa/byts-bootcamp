package editor;

// CP1: the Command pattern. Each edit is an object that knows how to do AND undo itself,
// so the editor can keep a history and walk it backwards.
public interface Command {
    void execute();
    void undo();
}

// A concrete command: insert a string at the end of the editor's buffer.
final class InsertText implements Command {
    private final Editor ed;
    private final String s;

    InsertText(Editor ed, String s) {
        this.ed = ed;
        this.s = s;
    }

    public void execute() {
        throw new UnsupportedOperationException("TODO CP1: append s to the editor's buffer (ed.buf)");
    }

    public void undo() {
        throw new UnsupportedOperationException("TODO CP1: remove the s.length() characters this command added from the end of ed.buf");
    }
}
