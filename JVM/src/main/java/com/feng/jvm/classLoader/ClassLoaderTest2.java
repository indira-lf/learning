package com.feng.jvm.classLoader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @author
 * @time 2022/7/14 19:51
 * @Description- TODO
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) {
        System.out.println("==========启动类加载器===========");

        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }

        System.out.println("===========扩展类加载器==========");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }

    }
}
