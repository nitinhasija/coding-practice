import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Solve {
    private final Map<String, Integer> countMap = new HashMap<>();
    private final Map<Integer, LinkedHashSet<String>> orderMap = new HashMap<>();
    int maxCount;

    private String getMostPopularContent() {
        String string = null;

        for (String s : orderMap.get(maxCount))
            string = s;

        return string;
    }

    private void decrement(String k) {
        int count = countMap.getOrDefault(k, 0) - 1;
        if (count == -1)
            return;

        orderMap.get(count + 1).remove(k);
        if (orderMap.get(count + 1).isEmpty())
            orderMap.remove(count + 1);

        if (count > 0) {
            countMap.put(k, count);

            LinkedHashSet<String> set = orderMap.getOrDefault(count, new LinkedHashSet<>());
            set.add(k);

            orderMap.put(count, set);
        }

        if (!orderMap.containsKey(maxCount))
            maxCount--;
    }

    private void increment(String k) {
        int count = countMap.getOrDefault(k, 0);
        countMap.put(k, count + 1);

        if (maxCount < count + 1)
            maxCount++;

        if (orderMap.containsKey(count)) {
            orderMap.get(count).remove(k);
            if (orderMap.get(count).isEmpty())
                orderMap.remove(count);
        }
        LinkedHashSet<String> set = orderMap.getOrDefault(count + 1, new LinkedHashSet<>());
        set.add(k);
        orderMap.put(count + 1, set);

    }

    public static void main(String[] args) {
        Solve solution = new Solve();

        solution.increment("k1"); // popularity counter for k1 becomes 1
        solution.increment("k2"); // popularity counter for k2 becomes 1
        solution.increment("k3"); // popularity counter for k3 becomes 1
        solution.increment("k2"); // popularity counter for k2 becomes 0
        solution.increment("k3"); // popularity counter for k3 becomes 2
        solution.increment("k3"); // popularity counter for k3 becomes 2
        solution.increment("k3"); // popularity counter for k3 becomes 2
        solution.decrement("k2"); // popularity counter for k3 becomes 2

        System.out.println(solution.getMostPopularContent());

        solution.decrement("k3"); // popularity counter for k3 becomes 2

        solution.decrement("k3"); // popularity counter for k3 becomes 2

        solution.decrement("k3"); // popularity counter for k3 becomes 2
        solution.decrement("k3");
        System.out.println(solution.getMostPopularContent());


    }

}
