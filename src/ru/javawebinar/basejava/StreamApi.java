package ru.javawebinar.basejava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        StreamApi streamAPI = new StreamApi();
        int[] values = new int[]{1, 2, 3, 3, 2, 3};
        int[] values2 = new int[]{9, 8};
        System.out.println(streamAPI.minValue(values));
        System.out.println(streamAPI.minValue(values2));
        System.out.println();

        List<Integer> integers = Arrays.asList(1, 2, 3, 3, 2, 3);
        List<Integer> integers2 = Arrays.asList(9, 8);

        System.out.println(streamAPI.oddOrEven(integers));
        System.out.println(streamAPI.oddOrEven(integers2));
    }

    int minValue(int[] values) {
        return Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce(0, (left, right) -> left * 10 + right);
    }

    List<Integer> oddOrEven(List<Integer> integers) {
        int sum = integers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        return integers.stream()
                .filter(integer -> (sum % 2 == 0) == (integer % 2 != 0))
                .collect(Collectors.toList());
    }
}
