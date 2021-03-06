package calculatortests;

import annotations.After;
import calculator.Calculator;
import framework.Asserts;
import annotations.Before;
import annotations.Test;

public class CalculatorTests {
    @Before
    public void doSthBeforeTest() {
        System.out.println("Something before test");
    }

    @After
    public void doSthAfterTest() {
        System.out.println("Something after test \n -------------");
    }

    @Test
    public void assertEqualsTest1() { Asserts.assertEquals(5, Calculator.add(2, 3)); }

    @Test
    public void assertEqualsTest2() { Asserts.assertEquals(6, Calculator.add(2, 3)); }

    @Test
    public void assertTrueTest1() { Asserts.assertTrue(5 == 5); }

    @Test
    public void assertTrueTest2() {
        Asserts.assertTrue(6 == 5);
    }

    @Test
    public void assertNotNull1() { Asserts.assertNotNull(5); }

    @Test
    public void assertNotNull2() {
        Asserts.assertNotNull(null);
    }
}
