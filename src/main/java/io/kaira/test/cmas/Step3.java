package io.kaira.test.cmas;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Step3 {
    static Map<Integer, String> sequence = new HashMap();
    private List<Integer> range;
    private static String CMAS_TEXT = "CMAS",
            SYSTEMS_TEXT = "systems",
            CMAS_SYSTEMS_TEXT = "CMASsystems",
            GOOD_TEXT = "good",
            INTEGER_TEXT = "integer";


    public Step3(int start, int end) {
        range = IntStream.rangeClosed(start, end)
                .boxed().collect(Collectors.toList());

        buildSquence(CMAS_TEXT, 3);
        buildSquence(SYSTEMS_TEXT, 5);
        buildSquence(CMAS_SYSTEMS_TEXT, 15);
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
        counts.put(CMAS_TEXT, 0);
        counts.put(SYSTEMS_TEXT, 0);
        counts.put(CMAS_SYSTEMS_TEXT, 0);
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


