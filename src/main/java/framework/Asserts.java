package framework;

public class Asserts {

    public static void assertTrue(Object object) {
        if (object.equals(true)) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
            System.out.println("expected: "+ true);
            System.out.println("actual: "+ object.toString());
        }
    }

    public static void assertEquals(Object object1, Object object2) {
        if (object1.equals(object2)) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
            System.out.println("expected: "+ object1.toString());
            System.out.println("actual: "+ object2.toString());

        }
    }

    public static void assertNotNull(Object object) {
        if (object != null) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
            System.out.println("expected: not null");
            System.out.println("actual: null");
        }
    }

}
