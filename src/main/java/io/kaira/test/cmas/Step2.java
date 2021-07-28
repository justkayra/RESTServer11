package io.kaira.test.cmas;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Step2 {
    static Map<Integer, String> sequence = new HashMap();
    List<Integer> range;
    private static String CMAS_TEXT = "CMAS",
            SYSTEMS_TEXT = "systems",
            CMAS_SYSTEMS_TEXT = "CMASsystems",
            GOOD_TEXT = "good";

    public Step2(int start, int end) {
        range = IntStream.rangeClosed(start, end)
                .boxed().collect(Collectors.toList());
        buildSquence(CMAS_TEXT, 3);
        buildSquence(SYSTEMS_TEXT, 5);
        buildSquence(CMAS_SYSTEMS_TEXT,  15);
    }

    public String getOutput() {
        StringBuilder result = new StringBuilder();
        range.stream().forEachOrdered((i) -> {
            String val = sequence.get(i);
            if (hasThree(i)) {
                result.append(" ").append(GOOD_TEXT).append(" ");
            } else if (val == null) {
                result.append(" ").append(i).append(" ");
            } else {
                result.append(" ").append(val).append(" ");
            }
        });
        return result.toString();
    }

    public void buildSquence(String name, int shouldBeMultiples) {
        range.stream().forEach((i) -> {
            if (i % shouldBeMultiples == 0) {
                sequence.put(i, name);
            }
        });
    }

    public boolean hasThree(int number) {
        while (number > 0) {
            if (number % 10 == 3)
                return true;
            number = number / 10;
        }
        return false;
    }


    public static void main(String[] args) {
        int start = 1;
        int end = 20;
        if (args.length == 2) {
            start = Integer.parseInt(args[0]);
            end = Integer.parseInt(args[1]);
        }
        System.out.print(new Step2(start, end).getOutput());
    }
}


