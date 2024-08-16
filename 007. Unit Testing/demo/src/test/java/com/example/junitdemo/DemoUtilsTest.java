package com.example.junitdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

@DisplayName("Tests for DemoUtils Class")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(2)
public class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeAll
    public static void initOnce() {
        System.out.println("BeforeAll executes only once in the beginning!");
    }

    @BeforeEach
    public void init() {

        // SETUP
        demoUtils = new DemoUtils();
        System.out.println("BeforeEach executes before the execution of each test method!");
    }

    @AfterEach
    public void cleanup() {
        System.out.println("AfterEach executes after the execution of each test method! \n");
    }

    @AfterAll
    public static void cleanupOnce() {
        System.out.println("AfterAll executes only once in the beginning!");
    }


    @Test
    @DisplayName("Equals Test for add() method")
    @Order(3)
    public void testAddEquals() {

        System.out.println("Running test: testAddEquals");

        // EXECUTE
        int actual = demoUtils.add(2,4);

        // ASSERT
        assertEquals(6, actual, "2 + 4 must be 6");
    }

    @Test
    @DisplayName("Not Equals Test for add() method")
    @Order(5)
    public void testAddNotEquals() {

        System.out.println("Running test: testAddNotEquals");

        // EXECUTE
        int actual = demoUtils.add(2,4);

        // ASSERT
        assertNotEquals(8, actual, "2 + 4 must not be 8");
    }

    @Test
    @DisplayName("Null & Not Null Test for checkNull() method")
    @Order(4)
    public void testCheckNull() {

        System.out.println("Running test: testCheckNull");

        // EXECUTE
        Object obj1 = null;
        Object obj2 = "Hello World";

        Object actual1 = demoUtils.checkNull(obj1);
        Object actual2 = demoUtils.checkNull(obj2);

        // ASSERT
        assertNull(obj1, "Object 1 must be null");
        assertNotNull(obj2, "Object 2 must not be null");
    }

    @Test
    @DisplayName("Array Equals test for getFirstThreeLettersOfAlphabet()")
    @Order(1)
    public void testGetFirstThreeLettersOfAlphabetEquals() {

        System.out.println("Running test: testGetFirstThreeLettersOfAlphabetEquals");

        String[] stringArray = {"A", "B", "C"};

        // ASSERT
        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");

    }

    @Test
    @DisplayName("List Equals test for getAcademyInList()")
    @Order(2)
    public void testGetAcademyInListEquals() {

        System.out.println("Running test: testGetAcademyInListEquals");

        List<String> list = List.of("hello", "world", "123");

        // ASSERT
        assertIterableEquals(list, demoUtils.getAcademyInList(), "Arrays should be the same");

    }
}
