package src;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Barracks implements Runnable {

    private final GoldMine goldMine;

    public Barracks(GoldMine goldMine) {
        this.goldMine = goldMine;
        new Thread(this).start();
    }

    @Override
    public void run() {
        int i =0;
        while (goldMine.toBeGold()){
            i++;
            System.out.println("New 'Worker' created. Name:" + "Worker"+i);
            Worker worker = new Worker(goldMine, "Worker" + i);
            try {
                goldMine.addWorker(worker);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
