package models;

import interfaces.Duck;

public class DuckMorty implements Duck {
    @Override
    public void fly() {
        System.out.println("Hi, I am Morty and I am a flying interfaces.Duck");
    }

    @Override
    public void quack() {
        System.out.println("Hi, I am Morty and I am a quacking interfaces.Duck");

    }
}
