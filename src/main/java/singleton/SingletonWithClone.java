package singleton;


class SingletonSuper implements Cloneable {
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class SingletonWithClone extends SingletonSuper {
    public static SingletonWithClone INSTANCE = new SingletonWithClone();

    private SingletonWithClone() {

    }

    //To avoid singleton break we have to override this method and return
    // same instance or CloneNotSupportedException exception
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return INSTANCE;
//    }
}
