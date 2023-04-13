package Apex;

import java.util.*;

public class FoodDistribution {

    public static int foodDistribution(int[] arr, int size) {
        int numSandwiches = arr[0]; // Number of Sandwiches
        int difference = 0; // Use to store the difference
        boolean give; // Signal each time a distribution takes place

        List<Integer> newList = new ArrayList<>(); // list used to sort our values

        // Checking for the difference of the original
        // In some cases we might not need to do food distribution if the difference across is 0
        for (int x = 1; x < size - 1; x++) {
            int temp = arr[x] - arr[x + 1];
            if (temp < 0) {
                temp *= -1;
            }
            difference += temp;

            newList.add(arr[x]);
        }
        if (difference == 0) {
            return 0;
        }

        // adding last element
        newList.add(arr[size - 1]);

        // sorting in descending order
        Collections.sort(newList, Collections.reverseOrder());

        // loop to balance hunger levels of each
        do {
            give = false;
            for (int x = 0; x < newList.size() - 1; x++) {
                // check the difference between the 2 neighbors
                int temp = newList.get(x) - newList.get(x + 1);

                // condition to check if hunger level for current person can be updated
                if (temp != 0 && numSandwiches > 0) {
                    if (temp < 0) {
                        // give this person the remaining sandwiches we had
                        newList.set(x, newList.get(x) - numSandwiches);
                        give = true;
                    } else {
                        // give this person the total difference between the their neighbor
                        // also update our sandwich count
                        newList.set(x, newList.get(x) - temp);
                        numSandwiches -= temp;
                        give = true;
                    }

                    break;
                }
            }
        } while (give);


        // final pass to get difference after our greedy approach
        difference = 0;
        for (int x = 0; x < newList.size() - 1; x++) {
            int temp = newList.get(x) - newList.get(x + 1);
            if (temp < 0) {
                temp *= -1;
            }
            difference += temp;
        }

        return difference;
    }

    public static void main(String[] args) {
        int[] A = {5, 3, 1, 2, 1};
        int[] B = {4, 5, 2, 3, 1, 0};
        int[] C = {5, 2, 2, 2, 2, 2};
        int[] D = {5, 2, 3, 4, 5};
        int[] E = {3, 2, 1, 0, 4, 1, 0};
        int[] F = {4, 5, 4, 5, 2, 3, 1, 2};
        int[] G = {7, 5, 4, 3, 4, 5, 2, 3, 1, 4, 5};
        int[] H = {7, 1, 1, 1, 1, 1};

        System.out.println(foodDistribution(A, A.length)); // 0
        System.out.println(foodDistribution(B, B.length)); // 2
}
}