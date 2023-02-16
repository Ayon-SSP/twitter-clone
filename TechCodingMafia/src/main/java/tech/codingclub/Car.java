package tech.codingclub;

public class Car implements CarInterface{
    static int wheelcount=4;
    // here public static final int makes it constant that we are cannot change it to any other which is constant
    public static final int maxspeed = 300; // km/hr
    private int currentspeed=0; // Any method will be able to access within the class
    // but we are unable to access out of the class

    // why we need this private
    // because this should not be accessed to anyone who can change the value which makes issue
    // example in a bank class
    // we make the account balance as private
    // because you are not accessed to change the account balance
    // but when comes to deposit section we can change by adding cash
    String number_plate;
    // default constructor
    public Car()
    {

    }
    public Car(String number_plate)
    {
        // this means current object's reference
        this.number_plate=number_plate;
    }
    public Car(String number_plate,int currentspeed)
    {
        this.number_plate=number_plate;
        this.currentspeed=currentspeed;
    }
    public void accelator()
    {
        System.out.println("speeding up !"+number_plate);
        currentspeed+=10;
    }

    @Override
    public void applyBreak() {
        currentspeed=0;
    }


    // Static method can only modify static data variable only
    // or access also
    // cannot access non - static
    static void printAboutWheel()
    {
        // NOT VALID TO WRITE THE CURRENT SPEED
        // current speed=10;

        // but
        // we can print wheelcount
        System.out.println("Car has "+Car.wheelcount+" wheels");
    }
    public static void main(String[] args)
    {


    }

    public void increasespeed(int i)
    {
        if(i<0)
        {
            return ;
        }
        currentspeed+=i;
        if(currentspeed>=maxspeed)
        {
            currentspeed=maxspeed;
        }
    }

    public int getspeed() {
        return currentspeed;
    }
}
