package editor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// CP4: the Composite pattern. A document is a tree - a Paragraph is a leaf, a Section holds
// other Nodes - and wordCount() works the same whether you call it on one leaf or a whole tree.
public interface Node {
    int wordCount();
    void accept(NodeVisitor v);   // CP6: Visitor
}

final class Paragraph implements Node {
    private final String text;

    Paragraph(String text) {
        this.text = text;
    }

    String text() {
        return text;
    }

    public int wordCount() {
        throw new UnsupportedOperationException("TODO CP4: count the words in text (trim, then split on whitespace; blank text is 0 words)");
    }

    public void accept(NodeVisitor v) {
        throw new UnsupportedOperationException("TODO CP6: dispatch to v.visitParagraph(this)");
    }
}

final class Section implements Node, Iterable<Paragraph> {
    private final String title;
    private final List<Node> children = new ArrayList<>();

    Section(String title) {
        this.title = title;
    }

    String title() {
        return title;
    }

    Section add(Node n) {
        children.add(n);
        return this;
    }

    List<Node> children() {
        return children;
    }

    public int wordCount() {
        throw new UnsupportedOperationException("TODO CP4: sum wordCount() over every child (works recursively for nested sections)");
    }

    public void accept(NodeVisitor v) {
        throw new UnsupportedOperationException("TODO CP6: dispatch to v.visitSection(this)");
    }

    // CP5: the Iterator pattern. Walk every Paragraph in the tree, depth-first, in document order.
    public Iterator<Paragraph> iterator() {
        return new ParaIterator(this);
    }
}

final class ParaIterator implements Iterator<Paragraph> {
    private final Deque<Node> stack = new ArrayDeque<>();

    ParaIterator(Node root) {
        stack.push(root);
    }

    public boolean hasNext() {
        throw new UnsupportedOperationException("TODO CP5: pop and expand Sections (push their children so document order is kept) until a Paragraph is on top; return whether any Paragraph remains");
    }

    public Paragraph next() {
        throw new UnsupportedOperationException("TODO CP5: return the next Paragraph - call hasNext() first, and throw NoSuchElementException if there is none");
    }
}
