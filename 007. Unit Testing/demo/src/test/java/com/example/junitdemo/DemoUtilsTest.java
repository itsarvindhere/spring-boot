package com.example.junitdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DemoUtilsTest {

    @Test
    public void testAdd() {

        // SETUP
        DemoUtils demoUtils = new DemoUtils();

        // EXECUTE
        int actual = demoUtils.add(2,4);

        // ASSERT
        Assertions.assertEquals(6, actual, "2 + 4 must be 6");
    }
}
