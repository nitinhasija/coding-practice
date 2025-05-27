package RateLimiter.strategy.interfaces;

/**
 * The interface Rate limiter strategy.
 */
public interface RateLimiterStrategy {
    /**
     * Allow request boolean.
     *
     * @return the boolean
     */
    boolean allowRequest();
}
