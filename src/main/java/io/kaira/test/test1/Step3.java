package io.kaira.test.test1;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Step3 {
    static Map<Integer, String> sequence = new HashMap();
    private List<Integer> range;
    private static String TEXT_ONE = "FAFA",
            TEXT_TWO = "TUTU",
            TEXT_THREE = "GAGA",
            GOOD_TEXT = "good",
            INTEGER_TEXT = "integer";


    public Step3(int start, int end) {
        range = IntStream.rangeClosed(start, end)
                .boxed().collect(Collectors.toList());

        buildSquence(TEXT_ONE, 3);
        buildSquence(TEXT_TWO, 5);
        buildSquence(TEXT_THREE,  15);
    }

    public String getOutput() {
        Object[] coombainedResult = getCounts();
        StringBuilder result = new StringBuilder();
        result.append(coombainedResult[0] + "\n");
        for (Map.Entry<String, Integer> entry : ((Map<String, Integer>) coombainedResult[1]).entrySet()) {
            result.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        return result.toString();
    }

    public Object[] getCounts() {
        StringBuilder textResult = new StringBuilder();
        Map <String, Integer> counts = initEmptyMap();
        range.stream().forEachOrdered((i) -> {
            String val = sequence.get(i);
            if (hasThree(i)) {
                textResult.append(" ").append(GOOD_TEXT).append(" ");
                counts.put(GOOD_TEXT, counts.get(GOOD_TEXT) + 1);
            } else if (val == null) {
                textResult.append(" ").append(i).append(" ");
                counts.put(INTEGER_TEXT, counts.get(INTEGER_TEXT) + 1);
            } else {
                textResult.append(" ").append(val).append(" ");
                counts.put(val, counts.get(val) + 1);
            }
        });
        return new Object[]{textResult, counts};
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

    private Map<String, Integer> initEmptyMap() {
        Map<String, Integer> counts = new LinkedHashMap<>();
        counts.put(TEXT_ONE, 0);
        counts.put(TEXT_TWO, 0);
        counts.put(TEXT_THREE, 0);
        counts.put(GOOD_TEXT, 0);
        counts.put(INTEGER_TEXT, 0);
        return counts;
    }

    public static void main(String[] args) {
        int start = 1;
        int end = 20;
        if (args.length == 2) {
            start = Integer.parseInt(args[0]);
            end = Integer.parseInt(args[1]);
        }

        System.out.print(new Step3(start, end).getOutput());
    }
}


