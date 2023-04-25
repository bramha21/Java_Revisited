package collection.singleton;

import mockit.Mock;
import mockit.MockUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singleton.Singleton;
import singleton.SingletonEnum;
import singleton.SingletonWithClone;

import java.io.*;
import java.lang.reflect.Constructor;

public class SingletonTest {

    @Test
    public void testSingletonBreakWithReflection() {
        {
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
            Assertions.assertNotEquals(instance1, instance2);
        }
    }

    @Test
    public void testEnumSingleton() {
        {
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
                Assertions.assertEquals(IllegalArgumentException.class, e.getClass());
            }

            Assertions.assertNull(instance);
        }
    }

    @Test
    public void testSingletonBreakWithSerialization() {

        try {
            Singleton instance1 = Singleton.INSTANCE;

            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.txt"));
            out.writeObject(instance1);
            out.close();

            ObjectInput input = new ObjectInputStream(new FileInputStream("file.txt"));
            Singleton instance2 = (Singleton) input.readObject();
            input.close();

            Assertions.assertNotEquals(instance1, instance2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSingletonBreakWithClone() {

        try {
            SingletonWithClone instance1 = SingletonWithClone.INSTANCE;

            SingletonWithClone instance2 = (SingletonWithClone) instance1.clone();

            Assertions.assertNotEquals(instance1, instance2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
