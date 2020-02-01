package familiar.core.service;

import java.util.Random;

public class Dice {

    //TODO: Autowire
    Random random;
    int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    };
}
