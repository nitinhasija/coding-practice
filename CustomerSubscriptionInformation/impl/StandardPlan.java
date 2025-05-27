package CustomerSubscriptionInformation.impl;

import CustomerSubscriptionInformation.Subscription;

public class StandardPlan implements Subscription {
    @Override
    public String getName() {
        return "Standard Plan";
    }

    @Override
    public Integer getPrice() {
        return 50;
    }
}
