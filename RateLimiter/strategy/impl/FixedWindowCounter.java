package RateLimiter.strategy.impl;

import RateLimiter.strategy.interfaces.RateLimiterStrategy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * The type Fixed window counter.
 */
public class FixedWindowCounter implements RateLimiterStrategy {
    private int counter;
    private final int maxRequest;


    /**
     * Instantiates a new Fixed window counter.
     *
     * @param capacity   the capacity
     * @param windowSize the window size
     */
    public FixedWindowCounter(int capacity, int windowSize) {
        this.counter = capacity;
        this.maxRequest = counter;
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this::refill, 0, windowSize, TimeUnit.SECONDS);
    }

    private synchronized void refill() {
        counter = maxRequest;
    }


    @Override
    public boolean allowRequest() {
        if (counter == 0)
            return false;

        else {
            counter--;
            return true;
        }
    }
}
