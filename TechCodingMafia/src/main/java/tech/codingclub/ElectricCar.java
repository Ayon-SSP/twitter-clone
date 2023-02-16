package tech.codingclub;
// extends keyword used to inherit the another class
// Here ElectricCar inherits the properties of Car class
public class ElectricCar extends Car {
    //constructor
    private double batteryLeft=100;
    public ElectricCar()
    {
        super();

    }
    public ElectricCar(String numberPlate)
    {
        //Please call the constructor of my parent class
        super(numberPlate);
    }
    public ElectricCar(String numberPlate,int currentSpeed)
    {
        super(numberPlate,currentSpeed);
    }
    public double batteryPercentageLeft()
    {
        return batteryLeft;
    }

    //What if , if we want to  modify how the accelerator works
    // here blue circle on 28th line means we are overriding some method
    // this is called polymorphism
    public void accelator()
    {
        super.accelator();
        batteryLeft=batteryLeft - 0.50;
    }
    public static void main(String[] args)
    {
        ElectricCar tesla = new ElectricCar("TESLA 001",500);
        tesla.accelator();
        printAboutWheel();

        System.out.println("TESLA SPEED : "+tesla.getspeed()+" Battery : "+tesla.batteryLeft);
    }
}
