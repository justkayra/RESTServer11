package io.kaira.test.test1;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Step1 {
    static Map<Integer, String> sequence = new HashMap();
    List<Integer> range;
    private static String TEXT_ONE = "FAFA",
            TEXT_TWO = "TUTU",
            TEXT_THREE = "GAGA";


    public Step1(int start, int end) {
        range = IntStream.rangeClosed(start, end)
                .boxed().collect(Collectors.toList());
        buildSquence(TEXT_ONE,  3);
        buildSquence(TEXT_TWO,  5);
        buildSquence(TEXT_THREE, 15);
    }

    public String getOutput() {
        StringBuilder result = new StringBuilder();
        range.stream().forEachOrdered((i) -> result.append(" " + sequence.getOrDefault(i, String.valueOf(i)) + " "));
        return result.toString();
    }

    public void buildSquence(String name, int shouldBeMultiples) {
        range.stream().forEach((i) -> {
            if (i % shouldBeMultiples == 0) {
                sequence.put(i, name);
            }
        });
    }

    public static void main(String[] args) {
        int start = 1;
        int end = 20;
        if (args.length == 2) {
            start = Integer.parseInt(args[0]);
            end = Integer.parseInt(args[1]);
        }


        System.out.print(new Step1(start, end).getOutput());
    }
}


