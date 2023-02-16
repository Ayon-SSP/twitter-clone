package tech.codingclub;

public  class Singleton{
    // why singleton ?
    public int data;
    // we want same memory to be accessed

    private static Singleton singleton; // only  one reference on class level not on object level


    private Singleton(int data) // i tested with public also
    {
        // Calling constructor
        this.data=data;
        System.out.println("Constructor was called when data was : "+data);

    }


    public static Singleton getSingletonInstance(int data) {
        if(singleton==null)
        {
            singleton= new Singleton(data); // creating a new object and taking space in memory

        }
        return singleton;


    }
}
