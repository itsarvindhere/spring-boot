package com.example.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Second Test Class for DemoUtils Class")
@Order(1)
public class DemoUtilsTest2 {

    DemoUtils demoUtils;

    @BeforeEach
    public void init() {

        // SETUP
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("Test Exception for throwException()")
    @Order(2)
    public void testThrowException() {

        System.out.println("Running test: testThrowException");

        // ASSERT
        assertThrows(Exception.class, () -> demoUtils.throwException(-1), "Should throw exception!");
        assertDoesNotThrow(() -> demoUtils.throwException(0), "Should not throw exception!");

    }

    @Test
    @DisplayName("Test Timeout for checkTimeout()")
    @Order(1)
    public void testCheckTimeout() {

        System.out.println("Running test: testCheckTimeout");

        // ASSERT
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> demoUtils.checkTimeout(), "Method should execute in 3 seconds!");

    }
}
