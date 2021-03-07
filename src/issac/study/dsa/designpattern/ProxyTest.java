package issac.study.dsa.designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author issac.hu
 */
public class ProxyTest {

    public static void main(String[] args) {
        jdkProxyTest();
    }

    private static void jdkProxyTest() {
        IDao myDao = new MyDao();
        myDao = new JdkProxy<IDao>(myDao).proxyInstance();
        myDao.doSth();
    }





    public static class JdkProxy<T> implements InvocationHandler {

        private Object target;

        public JdkProxy(Object target) {
            this.target = target;
        }

        public T proxyInstance() {
            return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("im proxy...");
            Object invoke = method.invoke(target, args);
            return invoke;
        }
    }
}
