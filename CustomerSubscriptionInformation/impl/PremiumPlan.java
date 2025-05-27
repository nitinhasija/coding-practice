package CustomerSubscriptionInformation.impl;

import CustomerSubscriptionInformation.Subscription;

public class PremiumPlan implements Subscription {
    @Override
    public String getName() {
        return "Premium Plan";
    }

    @Override
    public Integer getPrice() {
        return 250;
    }
}
