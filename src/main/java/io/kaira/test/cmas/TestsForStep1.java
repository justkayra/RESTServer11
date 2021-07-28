package io.kaira.test.cmas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class TestsForStep1 {
    @Test
    public void test() {
        Step1 step = new Step1(1, 5);
        String result = step.getOutput();
        assertTrue(result.contains("1"));
        assertTrue(result.contains("2"));
        assertTrue(result.contains("CMAS"));
        assertTrue(result.contains("4"));
        assertTrue(result.contains("systems"));
    }
}
