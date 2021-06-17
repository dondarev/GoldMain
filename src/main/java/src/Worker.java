package src;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Worker implements Runnable{

    private final GoldMine goldMine;
    private int gold=0;
    String name;

    public Worker(GoldMine goldMine,String name) {
        this.goldMine = goldMine;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (goldMine.toBeGold() && gold<=33) {
            goldMine.getGOLD(3);
            gold+=3;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker "+name+" have "+gold+" gold");
        }
        System.out.println(name+ " go to pension.");
        goldMine.getNewWroker(this);
    }
}
