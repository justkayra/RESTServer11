package io.kaira.test.test1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Map;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TestsForStep3 {

    @Test
    public void test_getOutput() {
        Step3 step = new Step3(1, 5);
        String result = step.getOutput();
        assertTrue(result.contains("1"));
        assertTrue(result.contains("2"));
        assertTrue(result.contains("good"));
        assertTrue(result.contains("4"));
        assertTrue(result.contains("systems"));
      }

    @Test
    public void test_getCounts() {
        Step3 step = new Step3(1, 5);
        Object[] result = step.getCounts();
        assertNotNull(result[0]);
        assertEquals(((Map)result[1]).get("good"), 1);
        assertEquals(((Map)result[1]).get("integer"), 3);

    }
}
