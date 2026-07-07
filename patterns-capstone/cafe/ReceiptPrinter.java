package cafe;

// TODO: an OBSERVER that remembers the most recent order as a receipt line,
// formatted as  "<description> = <cents>c"  (for example, "Tea = 120c").
public final class ReceiptPrinter implements OrderObserver {

    private String lastReceipt = "";

    @Override
    public void onOrder(String description, int cents) {
        throw new UnsupportedOperationException("TODO: lastReceipt = description + \" = \" + cents + \"c\"");
    }

    public String lastReceipt() {
        return lastReceipt;
    }
}
