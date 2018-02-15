package com.training.ee.ejb;

/**
 * Created by yusufyazici on 14/02/2018.
 */
//Gercek calisan Singleton budur
public class SingletonExample {

    private static volatile SingletonExample instance;

    public SingletonExample() {
    }

    public static SingletonExample getInstance(){
        if (instance == null){
            synchronized (SingletonExample.class){
                if (instance == null){
                    instance = new SingletonExample();
                }
            }
        }
        return instance;
    }
}
