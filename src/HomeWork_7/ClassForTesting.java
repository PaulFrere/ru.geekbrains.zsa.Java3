package HomeWork_7;

import HomeWork_7.Testing.Test;
import org.junit.After;
import org.junit.Before;

public class ClassForTesting {
    @Test(priority = 5)
    public void testMethod1() {
        System.out.println("Test method priority = 5");
    }

    @Test(priority = 1)
    public void testMethod2() {
        System.out.println("Test method priority = 1");
    }

    @Test(priority = 10)
    public void testMethod3() {
        System.out.println("Test method priority = 10");
    }

    @Test(priority = 7)
    private void testMethod4() {
        System.out.println("Test method priority = 7 (private)");
    }

    @Test
    public void testMethod5() {
        System.out.println("Test method priority = default");
    }

    @After
    public void afterMethod() {
        System.out.println("AfterSuite method");
    }

    @Before
    public void beforeSuiteMethod() {
        System.out.println("BeforeSuite method");
    }
}
