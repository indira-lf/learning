package com.feng.jvm.classLoader;

/**
 * @author
 * @time 2022/7/14 19:36
 * @Description- TODO
 */
public class ClassLoaderTest {
    public static void main(String[] args) {

        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取扩展类加载器
        ClassLoader classLoaderParent = systemClassLoader.getParent();
        System.out.println(classLoaderParent);

        //引导类加载器
        ClassLoader bootstrapClassLoader = classLoaderParent.getParent();
        System.out.println(bootstrapClassLoader);

        //对于用户自定义类来说:默认使用系统类加载器加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //String类使用引导类加载器进行加载的。--->Java的核心类库都是使用引导类加载器进行加载的。
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }
}
