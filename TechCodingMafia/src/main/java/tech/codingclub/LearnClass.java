package tech.codingclub;

public class LearnClass {
    public static void main(String[] args)
    {
        Car audi = new Car("AP 35 BPJK 1234");
        audi.accelator();
        audi.wheelcount=8;
        Car bmw = new Car("AP 31 BJPH 1526",100);
        bmw.accelator();
        bmw.increasespeed(100);

        System.out.println("Current speed : "+audi.getspeed());
        System.out.println("Current speed : "+bmw.getspeed());
        System.out.println("Audi : "+audi.wheelcount);
        System.out.println("Bmw  : "+bmw.wheelcount);
        // Car.wheelcount is accessible bcz it is static
        audi.printAboutWheel();
        bmw.printAboutWheel();
        Car.wheelcount=4;
        System.out.println("Audi : "+audi.wheelcount);
        System.out.println("Bmw  : "+bmw.wheelcount);
        audi.printAboutWheel();
        bmw.printAboutWheel();
        Car.printAboutWheel();

        DummyCar car = new DummyCar() {
            public void move() {
                // when do we use abstract ,
                // when we want object level diffrentiation
                //  x,y;
                //this.accelator();
                //this.getspeed();
            }
        };



    }

}
