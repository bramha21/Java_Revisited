package singleton;

import java.io.*;
import java.lang.reflect.Constructor;

//Problem with enum singleton is that it did not allow lazy initialization
enum SingletonEnum {
    INSTANCE
}

/**
 * Here we will see different ways of Singleton and How to prevent breaking singleton in different scenarios
 */

public class Singleton implements Serializable {
    public static Singleton INSTANCE = new Singleton();

    private Singleton() {

    }

    @Serial
    protected Object readResolve() {
        return INSTANCE;
    }
}

class SingletonSuper implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class SingletonWithClone extends SingletonSuper {
    public static SingletonWithClone INSTANCE = new SingletonWithClone();

    private SingletonWithClone() {

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return INSTANCE;
    }
}

class BreakSingleton {
    public static void main(String[] args) {
        reflectionToBreakSingleton();

        enumAsSingleton();

        serializationToBreakSingleton();

        cloningCanBreakSingleton();
    }

    private static void cloningCanBreakSingleton() {

        try {
            SingletonWithClone instance1 = SingletonWithClone.INSTANCE;

            SingletonWithClone instance2 = (SingletonWithClone) instance1.clone();

            System.out.println(instance1);
            System.out.println(instance2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private static void serializationToBreakSingleton() {

        try {
            Singleton instance1 = Singleton.INSTANCE;

            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.txt"));
            out.writeObject(instance1);
            out.close();

            ObjectInput input = new ObjectInputStream(new FileInputStream("file.txt"));
            Singleton instance2 = (Singleton) input.readObject();
            input.close();

            System.out.println(instance1);
            System.out.println(instance2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void enumAsSingleton() {
        SingletonEnum instance = null;

        Constructor<?>[] constructors = SingletonEnum.class.getDeclaredConstructors();
        try {
            for (Constructor<?> c : constructors) {
                c.setAccessible(true);
                instance = (SingletonEnum) c.newInstance();
                break;
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println(instance);
    }

    private static void reflectionToBreakSingleton() {
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = null;
        try {
            Constructor<?>[] constructors = Singleton.class.getDeclaredConstructors();
            for (Constructor<?> c : constructors) {
                c.setAccessible(true);

                instance2 = (Singleton) c.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instance1);
        System.out.println(instance2);
    }

}