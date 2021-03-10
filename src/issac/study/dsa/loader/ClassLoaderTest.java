package issac.study.dsa.loader;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author issac.hu
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String property = System.getProperty("sun.boot.class.path");
        System.out.println(property);
        Class<?> aClass = Class.forName("issac.study.dsa.jar.Test");
        System.out.println(aClass.getClassLoader());
        Object o = aClass.newInstance();
        Method main = aClass.getMethod("main", String[].class);
        main.invoke(null,(Object) args);
        System.out.println(ClassLoaderTest.class.getClassLoader());
    }
}
