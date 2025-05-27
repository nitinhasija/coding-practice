package RateLimiter.strategy.impl;

import RateLimiter.strategy.interfaces.RateLimiterStrategy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * The type Token bucket.
 */
public class TokenBucket implements RateLimiterStrategy {
    private int tokens;
    private final int capacity;


    /**
     * Instantiates a new Token bucket.
     *
     * @param capacity  the capacity
     * @param intervals the intervals
     */
    public TokenBucket(int capacity, int intervals) {
        this.capacity = capacity;
        this.tokens = capacity;
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::refill, 0, intervals, TimeUnit.SECONDS);
    }

    private synchronized void refill() {
        if (tokens < capacity)
            tokens = capacity;
    }

    @Override
    public boolean allowRequest() {
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }
}
