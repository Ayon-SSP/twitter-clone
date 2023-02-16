package tech.codingclub;
import java.util.Date;

public class Test3 {
    public static void main(String[] args)
    {
        System.out.println("Hello Mohit Kota! ");
        System.out.println("Test 3 Running at " + new Date() + " sharp." );
        byte a = 1; // 1 byte
        short b = 3; // 2 byte
        int c = 5;  // 4 byte
        long d = 7;  // 8 byte
        boolean e = true; // false // 1 byte
        char f = 'a';    // 2 byte
        float g = 9.4f;  // 4 bytes

        double h = 11.0;   // 8 byte

        System.out.println(a+":"+b+":"+c+":"+d+":"+e+":"+f+":"+g+":"+h);


    }
}
