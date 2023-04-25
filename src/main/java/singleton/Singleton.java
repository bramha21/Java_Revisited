package singleton;

import java.io.*;
import java.lang.reflect.Constructor;


/**
 * Here we will see different ways of Singleton and How to prevent breaking singleton in different scenarios
 */

public class Singleton implements Serializable {
    public static Singleton INSTANCE = new Singleton();

    private Singleton() {

    }

    //This method solves problem on breaking singleton
//    @Serial
//    protected Object readResolve() {
//        return INSTANCE;
//    }
}
