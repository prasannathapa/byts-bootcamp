package bank;

import java.util.Objects;

/**
 * An account whose balance must NEVER go negative.  (pillar: encapsulation)
 *
 * The balance is private on purpose: the ONLY way to change it is through
 * deposit / withdraw, which enforce the rules. Implement the TODOs so no caller
 * can ever put this object into an illegal state.
 */
public final class Account {

    private final String id;
    private long balanceCents;

    public Account(String id, long openingCents) {
        // TODO: reject a negative opening balance (IllegalArgumentException),
        //       then store the id and the opening balance.
        throw new UnsupportedOperationException("TODO: Account(id, openingCents)");
    }

    public String id() {
        throw new UnsupportedOperationException("TODO: id()");
    }

    public long balanceCents() {
        throw new UnsupportedOperationException("TODO: balanceCents()");
    }

    public void deposit(long cents) {
        // TODO: reject a non-positive amount, then add it to the balance.
        throw new UnsupportedOperationException("TODO: deposit(cents)");
    }

    public void withdraw(long cents) {
        // TODO: reject a non-positive amount AND an overdraft, then subtract.
        throw new UnsupportedOperationException("TODO: withdraw(cents)");
    }
}
