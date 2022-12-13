package ua.com.alevel;

public class Human {

    String name;
    int age;

    long salary;
    boolean isMan;

    Human(){
        name = "Ivan";
        age = 20;
    }

    void drink()
    {
        System.out.println("Drink water");
    }

   String info(){
        return "name " + name + " age " + age + " salary " + salary + " isMan " + isMan;
    }
}
