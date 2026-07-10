package finale;

import java.util.List;
import java.util.Objects;

// The finale spec - do not edit it. It proves the two halves of the day working
// together: OOP (encapsulation) plus SOLID (OCP, DIP, ISP) in one small file.
// Fill in the TODOs until all six tests pass.
public class RunTests {

    public static void main(String[] args) {

        check("plain format: one 'id: balance' line per account", () ->
            expectEquals("A: 500\nB: 0",
                new PlainFormat().format(List.of(new Account("A", 500), new Account("B", 0)))));

        check("csv format: a header, then one row per account", () ->
            expectEquals("id,balance\nA,500\nB,0",
                new CsvFormat().format(List.of(new Account("A", 500), new Account("B", 0)))));

        check("the exporter delegates to the plain format it was injected with", () -> {
            List<Account> accts = List.of(new Account("A", 500));
            expectEquals(new PlainFormat().format(accts),
                new StatementExporter(new PlainFormat()).export(accts));
        });

        check("the exporter delegates to the csv format it was injected with", () -> {
            List<Account> accts = List.of(new Account("A", 500), new Account("B", 250));
            expectEquals(new CsvFormat().format(accts),
                new StatementExporter(new CsvFormat()).export(accts));
        });

        check("the exporter accepts a brand new format it has never seen (OCP / DIP)", () -> {
            StatementFormat totalCount = accounts -> "accounts:" + accounts.size();
            expectEquals("accounts:2",
                new StatementExporter(totalCount).export(List.of(new Account("A", 1), new Account("B", 2))));
        });

        check("the account still guards its balance: overdraw throws (encapsulation)", () ->
            expectThrows(IllegalStateException.class, () -> {
                Account a = new Account("A", 100);
                a.withdraw(150);
            }));

        System.out.println();
        System.out.println(passed + " passed, " + failed + " failed");
        if (failed > 0) System.exit(1);
    }

    interface Body { void run() throws Throwable; }
    static int passed = 0, failed = 0;

    static void check(String name, Body body) {
        try {
            body.run();
            passed++;
            System.out.println("  PASS  " + name);
        } catch (Throwable t) {
            failed++;
            System.out.println("  FAIL  " + name + "  ->  " + t);
        }
    }

    static void expectEquals(Object expected, Object actual) {
        if (!Objects.equals(expected, actual))
            throw new AssertionError("expected [" + expected + "] but was [" + actual + "]");
    }

    static void expectThrows(Class<? extends Throwable> type, Body body) {
        try {
            body.run();
        } catch (Throwable t) {
            if (type.isInstance(t)) return;
            throw new AssertionError("expected " + type.getSimpleName() + " but threw " + t);
        }
        throw new AssertionError("expected " + type.getSimpleName() + " but nothing was thrown");
    }
}
