package com.mjc.stage2;

public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton instance;

    public static ThreadSafeSingleton GetInstance() {

        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
