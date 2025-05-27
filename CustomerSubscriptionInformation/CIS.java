package CustomerSubscriptionInformation;

import java.time.LocalDate;
import java.util.Arrays;

public class CIS {
     static class Price {
        int[] arr = new int[12];
        int yearlyCost;

        @Override
        public String toString() {
            return "Price{" +
                    "arr=" + Arrays.toString(arr) +
                    ", yearlyCost=" + yearlyCost +
                    '}';
        }
    }

    private final Customer customer;
    private final Product product;
    private final Subscription subscription;
    private final LocalDate date;

    public CIS(Customer customer, Product product, Subscription subscription, LocalDate date) {
        this.customer = customer;
        this.product = product;
        this.subscription = subscription;
        this.date = date;
    }

    public Price calculatePrice() {
        int cost = subscription.getPrice();
        Price price = new Price();
        int month = date.getMonthValue() - 1;
        for (int i = month; i < price.arr.length; i++) {
            price.arr[i] = cost;
            price.yearlyCost += cost;
        }
        return price;
    }
}
