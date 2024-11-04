package com.test_gits;

import java.util.HashSet;
import java.util.Set;

public class WeightedStrings {

    public static void main(String[] args) {
        String input = "abbcccd";
        int[] queries = {1, 3, 9, 8};
        String[] result = solveWeightedStrings(input, queries);

        for (String res : result) {
            System.out.println(res);
        }
    }

    public static String[] solveWeightedStrings(String input, int[] queries) {
        Set<Integer> weights = calculateWeights(input);
        String[] results = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            results[i] = weights.contains(queries[i]) ? "Yes" : "No";
        }

        return results;
    }

    private static Set<Integer> calculateWeights(String input) {
        Set<Integer> weights = new HashSet<>();
        int i = 0;

        while (i < input.length()) {
            char currentChar = input.charAt(i);
            int weight = currentChar - 'a' + 1;
            int count = 1;

            // Add weight of single character
            weights.add(weight);

            // Count consecutive occurrences of the same character
            int j = i + 1;
            while (j < input.length() && input.charAt(j) == currentChar) {
                count++;
                weights.add(weight * count);
                j++;
            }

            i = j;
        }

        return weights;
    }
}

