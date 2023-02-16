package tech.codingclub;

public class SingletonExample {
    public static void main(String[] args)
    {
        Singleton obj1 = Singleton.getSingletonInstance(90); // multiple instance
        Singleton obj2 = Singleton.getSingletonInstance(56);

        obj1.data=90; // as we have single reference so every object pointing to same
        obj2.data=56;
        //System.out.println(hash(obj1));
        System.out.println(obj1.data+" & "+ obj2.data);
    }
}
