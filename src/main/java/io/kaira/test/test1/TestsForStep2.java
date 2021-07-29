package io.kaira.test.test1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class TestsForStep2 {

    @Test
    public void test() {
        Step2 step = new Step2(1, 5);
        String result = step.getOutput();
        assertTrue(result.contains("1"));
        assertTrue(result.contains("2"));
        assertTrue(result.contains("good"));
        assertTrue(result.contains("4"));
        assertTrue(result.contains("systems"));
      }

    @Test
    public void test_1_400() {
        Step2 step = new Step2(1, 400);
        String result = step.getOutput();
        assertTrue(result.contains("1"));
        assertTrue(result.contains("2"));
        assertTrue(result.contains("good  good"));
        assertTrue(result.contains("4"));
        assertTrue(result.contains("systems"));
    }
}
