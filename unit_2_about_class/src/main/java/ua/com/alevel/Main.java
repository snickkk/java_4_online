package ua.com.alevel;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Human human = new Human();
        System.out.println(human.info());
        human.name = "Anton";
        human.age = 30;
        System.out.println(human.info());
    }
}