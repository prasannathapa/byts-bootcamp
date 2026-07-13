package systems;

import java.util.function.LongSupplier;

/**
 * CP2 - token-bucket rate limiter.
 * The bucket refills at a steady rate up to a capacity; each allowed request spends one token.
 * Time comes from the injected clock (millis) so tests are deterministic. Fields and constructor
 * are given; implement allow() and refill().
 */
public final class TokenBucket {

    private final double capacity;
    private final double refillPerMilli;
    private final LongSupplier clock;
    private double tokens;
    private long last;

    public TokenBucket(double capacity, double refillPerSecond, LongSupplier clockMillis) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be positive");
        this.capacity = capacity;
        this.refillPerMilli = refillPerSecond / 1000.0;
        this.clock = clockMillis;
        this.tokens = capacity;               // start full
        this.last = clockMillis.getAsLong();
    }

    public boolean allow() {
        // TODO: refill to now; if at least one token, spend it and return true; else return false
        throw new UnsupportedOperationException("TODO: implement allow()");
    }

    public double available() {
        refill();
        return tokens;
    }

    private void refill() {
        // TODO: add (now - last) * refillPerMilli tokens, capped at capacity, then advance last
        throw new UnsupportedOperationException("TODO: implement refill()");
    }
}
