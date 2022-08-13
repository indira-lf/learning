package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author
 * @time 2022/8/13 13:33
 * @Description- TODO
 */
public class JDKTikTokProxy<T> implements InvocationHandler {

    private T target;

    /**
     * 接收被代理对象
     * @param target
     */
    public JDKTikTokProxy(T target) {
        this.target = target;
    }

    /**
     * 获取被代理对象的代理对象
     * @param t
     * @param <T>
     * @return
     */
    public static<T> T getProxy(T t){
        /**
         * ClassLoader loader,              当前被代理对象的类加载器
         * @NotNull Class<?>[] interfaces,  当前被代理对象所实现的所有接口
         * @NotNull reflect.InvocationHandler h 当前被代理对象执行目标方法的时候我们使用h可以定义拦截增强方法
         */
        Object o = Proxy.newProxyInstance(t.getClass().getClassLoader(),
                t.getClass().getInterfaces(),
                new JDKTikTokProxy(t));
        return (T) o;
    }

    /**
     * 定义目标方法的拦截器逻辑
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("真正执行被代理对象的方法");
        Object invoke = method.invoke(target, args);
        System.out.println("返回值："+invoke);
        return invoke;
    }
}
