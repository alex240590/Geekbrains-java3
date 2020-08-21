package lesson7;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method
import java.util.ArrayList;


public class ReflectionTest {

    public static void testStart(Class clazz) throws InvocationTargetException, IllegalAccessException {
        Method startMethod = null;
        Method stopMethod = null;
        ArrayList<Method> testMethods = new ArrayList<Method>();

        Object someClass;
        try {
            someClass = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (startMethod != null) {
                    throw new RuntimeException("To much BeforeSuite methods");
                }
                startMethod = method;
            }

            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (stopMethod != null) {
                    throw new RuntimeException("To much AfterSuite methods");
                }
                stopMethod = method;
            }

            if (method.isAnnotationPresent(Test.class) && method.getAnnotation(Test.class).priority()<11) {
                testMethods.add(method);
            }
        }

        if (testMethods.isEmpty()) {
            return;
        }

        testMethods.sort((method1, method2) -> {
            int priority1 = method1.getAnnotation(Test.class).priority();
            int priority2 = method2.getAnnotation(Test.class).priority();
            return priority2-priority1;
        });

        if (startMethod != null) {
            startMethod.invoke(someClass);
        }

        for (Method method : testMethods) {
            try {
                method.invoke(someClass);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        if (stopMethod != null) {
            stopMethod.invoke(someClass);
        }
    }
}
