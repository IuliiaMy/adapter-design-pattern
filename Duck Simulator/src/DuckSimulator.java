import java.util.ArrayList;
import java.util.List;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckMorty duckMorty = new DuckMorty();
        TurkeyRick turkeyRick = new TurkeyRick();

        List<Duck> ducks = new ArrayList<>();
        ducks.add(duckMorty);
        TurkeyAdapter turkeyAdapter= new TurkeyAdapter(turkeyRick);
        ducks.add(turkeyAdapter);

        ducks.forEach(duck -> {
            duck.fly();
            duck.quack();
        });
    }
}
