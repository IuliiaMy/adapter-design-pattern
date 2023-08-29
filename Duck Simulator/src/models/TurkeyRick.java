package models;

import interfaces.Turkey;

public class TurkeyRick implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Hi, I am Rick and I am a gobbling turkey");
    }

    @Override
    public void fly() {
        System.out.println("Hi, I am Rick and I am a flying turkey");
    }
}
