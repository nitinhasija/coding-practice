package RateLimiter.strategy.impl;

import RateLimiter.strategy.interfaces.RateLimiterStrategy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * The type Leaky bucket.
 */
public class LeakyBucket implements RateLimiterStrategy {
    private final Queue<Long> queue;
    private final int capacity;

    /**
     * Instantiates a new Leaky bucket.
     *
     * @param capacity  the capacity
     * @param intervals the intervals
     */
    public LeakyBucket(int capacity, int intervals) {
        queue = new LinkedList<>();
        this.capacity = capacity;
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this::refill, 0, intervals, TimeUnit.SECONDS);
    }

    private void refill() {
        if (!queue.isEmpty())
            queue.poll();
    }

    @Override
    public boolean allowRequest() {
        if (queue.size() >= capacity)
            return false;

        else {
            queue.add(System.currentTimeMillis());
            return true;
        }
    }
}
