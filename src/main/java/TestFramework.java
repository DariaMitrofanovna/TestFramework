import utils.After;
import utils.Before;
import utils.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestFramework {

    public static void start(String path) throws Exception {
        List<Class> classes;
        classes = new ArrayList<>(new Reflections(path, new SubTypesScanner(false)).getSubTypesOf(Object.class));
        for (Class cl : classes) {
            Object object = cl.getConstructor().newInstance();
            List<Method> methodsTest = getMethods(cl, Test.class);
            List<Method> methodsBefore = getMethods(cl, Before.class);
            List<Method> methodsAfter = getMethods(cl, After.class);

            for (Method method : methodsTest) {
                System.out.println("Testing: " + method.getName());
                for (Method m : methodsBefore) {
                    m.invoke(object);
                }
                method.invoke(object);
                for (Method m : methodsAfter) {
                    m.invoke(object);
                }
            }
        }
    }

    private static List<Method> getMethods(Class cl, Class annotation) {
        ArrayList<Method> methods = new ArrayList<>();
        for (Method method : cl.getMethods()) {
            if (!(method.getAnnotation(annotation) == null)) {
                methods.add(method);
            }
        }
        return methods;
    }
}

