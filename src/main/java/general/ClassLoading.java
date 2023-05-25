package general;

import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.WeakHashMap;

public class ClassLoading {
    public static void main(String[] args) {
        Class c = ClassLoading.class;
        System.out.println(c.getClassLoader().getName());

        System.out.println(String.class.getClassLoader().getName());

    }
}
