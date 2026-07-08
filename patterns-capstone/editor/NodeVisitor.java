package editor;

// CP6: the Visitor pattern. Add a new operation over the document tree without touching the
// Node classes - each node dispatches to the matching visit method (double dispatch).
public interface NodeVisitor {
    void visitParagraph(Paragraph p);
    void visitSection(Section s);
}

final class WordCountVisitor implements NodeVisitor {
    private int total = 0;

    int total() {
        return total;
    }

    public void visitParagraph(Paragraph p) {
        throw new UnsupportedOperationException("TODO CP6: add p.wordCount() to the running total");
    }

    public void visitSection(Section s) {
        throw new UnsupportedOperationException("TODO CP6: visit every child - call n.accept(this) so each node dispatches back");
    }
}
