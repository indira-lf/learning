package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author
 * @time 2022/8/13 14:04
 * @Description- TODO
 */
public class CgLibProxy {

    public static<T> T creatProxy(T t) {
        //1、创建一个增强器
        Enhancer enhancer = new Enhancer();
        //2、设置要增强哪个类的功能，增强器为这个类动态创建一个子类
        enhancer.setSuperclass(t.getClass());
        //3、设置方法回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o,
                                    Method method,  //为了获取原方法的一些原数据信息
                                    Object[] objects, MethodProxy methodProxy) throws Throwable {
                //编写拦截器的逻辑
                System.out.println("cglib[-----start------]");

                Object invoke = methodProxy.invokeSuper(o, objects);

                System.out.println("cglib[-----end------]");
                return invoke;
            }
        });

        Object o = enhancer.create();
        return (T) o;
    }
}
