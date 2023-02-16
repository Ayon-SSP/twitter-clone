package tech.codingclub.entity;

public class Coders {
    private String name;
    private long age;
    public Coders(){

    }
    public Coders(String name, long age) {
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public long getAge(){
        return age;
    }
}