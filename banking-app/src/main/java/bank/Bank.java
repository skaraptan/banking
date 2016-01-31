package bank;

import banking.StartScreen;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Yoga2pro on 24.01.2016.
 */

public class Bank extends Thread{

    public Bank(){
    }
    public void run(){
        new StartScreen();
    }
}
