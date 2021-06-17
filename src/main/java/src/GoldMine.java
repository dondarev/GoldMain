package src;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GoldMine {

    private int GOLD = 1000;
    private List<Worker> arrayWorker = new ArrayList<>(3);

    public synchronized void getGOLD(int value) {
        GOLD-=value;
        if (GOLD<=0){
            System.out.println("No many gold.....");
        }
    }
    public boolean toBeGold(){
        return GOLD > 0;
    }

    public synchronized void addWorker(Worker worker) throws InterruptedException {
        if (arrayWorker.size()<3) {
            arrayWorker.add(worker);
        }else {
            System.out.println("Mine is full!!!");
            wait();
        }
    }

    public synchronized void getNewWroker(Worker worker) {
        arrayWorker.remove(worker);
        notify();
    }
}
