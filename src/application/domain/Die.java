package application.domain;

import java.util.Random;

public class Die {

    private Random random;
    private int sideCount;
    private int numberShowing;

    public Die(int sideCount){
        this.sideCount = sideCount;
        this.random = new Random();
    }

    public int roll(){
        numberShowing = random.nextInt(sideCount) + 1;
        return numberShowing;
    }

    public int getNumberShowing() {
        return numberShowing;
    }
}
