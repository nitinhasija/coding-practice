package CustomerSubscriptionInformation.impl;

import CustomerSubscriptionInformation.Subscription;

public class BasicPlan implements Subscription {
    @Override
    public String getName() {
        return "Basic Plan";
    }

    @Override
    public Integer getPrice() {
        return 10;
    }
}
