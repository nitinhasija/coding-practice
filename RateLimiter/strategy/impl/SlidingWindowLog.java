package RateLimiter.strategy.impl;

import RateLimiter.strategy.interfaces.RateLimiterStrategy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The type Sliding window log.
 */
public class SlidingWindowLog implements RateLimiterStrategy {
    private final int maxRequests;
    private final Queue<Long> queue;
    private final long windowSizeInMillies;


    /**
     * Instantiates a new Sliding window log.
     *
     * @param capacity  the capacity
     * @param intervals the intervals
     */
    public SlidingWindowLog(int capacity, int intervals) {
        this.maxRequests = capacity;
        this.windowSizeInMillies = intervals * 60_000L;
        this.queue = new LinkedList<>();
    }

    @Override
    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        while (!queue.isEmpty() && currentTime - queue.peek() > windowSizeInMillies)
            queue.remove();

        if (queue.size() < maxRequests) {
            queue.add(currentTime);
            return true;
        }

        return false;
    }
}
