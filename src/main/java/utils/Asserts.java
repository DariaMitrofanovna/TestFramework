package utils;

public class Asserts {

    public static void assertTrue(Object object) {
        if (object.equals(true)) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }
    }

    public static void assertEquals(Object object1, Object object2) {
        if (object1.equals(object2)) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }
    }

    public static void assertNotNull(Object object) {
        if (object == null) {
            System.out.println("test failed");
        } else {
            System.out.println("test passed");
        }
    }

}
