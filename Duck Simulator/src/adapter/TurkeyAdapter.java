package adapter;

import interfaces.Duck;
import interfaces.Turkey;

public class TurkeyAdapter implements Duck {

    private final Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void fly() {
        turkey.fly();
    }

    @Override
    public void quack() {
        turkey.gobble();

    }
}
