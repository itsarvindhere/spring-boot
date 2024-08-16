package com.example.junitdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DemoUtilsTest {

    @Test
    public void testAddEquals() {

        // SETUP
        DemoUtils demoUtils = new DemoUtils();

        // EXECUTE
        int actual = demoUtils.add(2,4);

        // ASSERT
        assertEquals(6, actual, "2 + 4 must be 6");
    }

    @Test
    public void testAddNotEquals() {

        // SETUP
        DemoUtils demoUtils = new DemoUtils();

        // EXECUTE
        int actual = demoUtils.add(2,4);

        // ASSERT
        assertNotEquals(8, actual, "2 + 4 must not be 8");
    }

    @Test
    public void testCheckNull() {

        // SETUP
        DemoUtils demoUtils = new DemoUtils();

        // EXECUTE
        Object obj1 = null;
        Object obj2 = "Hello World";

        Object actual1 = demoUtils.checkNull(obj1);
        Object actual2 = demoUtils.checkNull(obj2);

        // ASSERT
        assertNull(obj1, "Object 1 must be null");
        assertNotNull(obj2, "Object 2 must not be null");
    }
}
