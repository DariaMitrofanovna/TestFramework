package framework;

import annotations.After;
import annotations.Before;
import annotations.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestFramework {

    String path;
    List<Method> methodsTest;
    Method methodBefore;
    Method methodAfter;

    public void start(String path) throws Exception {
        this.path = path;
        List<Class> classes = getClassesFromPath();
        for (Class cl : classes) {
            Object object = cl.getConstructor().newInstance();
            methodsTest = getMethods(cl, Test.class);
            methodBefore = getMethod(cl, Before.class);
            methodAfter = getMethod(cl, After.class);

            for (Method method : methodsTest) {
                System.out.println("Testing: " + method.getName());

                methodBefore.invoke(object);
                method.invoke(object);
                methodAfter.invoke(object);
            }
        }
    }

    private List<Class> getClassesFromPath() {
        return new ArrayList<>(new Reflections(this.path, new SubTypesScanner(false)).getSubTypesOf(Object.class));
    }

    private List<Method> getMethods(Class cl, Class annotation) {
        List<Method> methods = new ArrayList<>();
        for (Method method : cl.getMethods()) {
            if (!(method.getAnnotation(annotation) == null)) {
                methods.add(method);
            }
        }
        return methods;
    }

    private Method getMethod(Class cl, Class annotation) {
        for (Method method : cl.getMethods()) {
            if (!(method.getAnnotation(annotation) == null)) {
                return method;
            }
        }
        return null;
    }
}

