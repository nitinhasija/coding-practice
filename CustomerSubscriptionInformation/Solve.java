package CustomerSubscriptionInformation;

import CustomerSubscriptionInformation.impl.BasicPlan;
import CustomerSubscriptionInformation.impl.PremiumPlan;

import java.time.LocalDate;

public class Solve {

    private CIS.Price getPrice(Customer custName, Product productName,
                           Subscription subscription, LocalDate date) {

        return new CIS(custName, productName, subscription, date).calculatePrice();

    }


    public static void main(String[] args) {

        System.out.println(new Solve().getPrice(
                new Customer("nittin"), new Product("jira"),
                new PremiumPlan(), LocalDate.parse("2024-02-10")));

    }
}
