package editor;

// CP7: the Chain of Responsibility pattern. Each filter does its bit, then hands the text to
// the next filter in the chain. Build a pipeline once, then run any text straight through it.
public abstract class TextFilter {
    TextFilter next;   // package-private: wired up by chain()

    public static TextFilter chain(TextFilter... filters) {
        for (int i = 0; i < filters.length - 1; i++) filters[i].next = filters[i + 1];
        return filters[0];   // the head of the chain
    }

    public final String process(String text) {
        throw new UnsupportedOperationException("TODO CP7: apply(text), then if there is a next filter pass the result to next.process(...); otherwise return it");
    }

    protected abstract String apply(String text);
}

final class TrimFilter extends TextFilter {
    protected String apply(String text) {
        throw new UnsupportedOperationException("TODO CP7: return text with leading and trailing whitespace removed");
    }
}

final class CollapseSpaces extends TextFilter {
    protected String apply(String text) {
        throw new UnsupportedOperationException("TODO CP7: collapse every run of whitespace down to a single space");
    }
}

final class Censor extends TextFilter {
    private final String bad;

    Censor(String bad) {
        this.bad = bad;
    }

    protected String apply(String text) {
        throw new UnsupportedOperationException("TODO CP7: replace every occurrence of bad with ***");
    }
}
