package com.company;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickEngine implements ActionListener {
    private windowComponent winComp;
    private int firstClick = -1;
    private int lastClick = -1;
    private int endCount;
    private String firstImg, lastImg;
    private int buttNumm;
    ClickEngine(windowComponent parent) {
        this.winComp = parent;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        buttNumm = Integer.parseInt(((JButton) event.getSource()).getText());
        if (firstClick > -1 & lastClick > -1){ // если бьІло сделано  три клика
            winComp.button[firstClick].setIcon(null);
            winComp.button[lastClick].setIcon(null);
            winComp.button[buttNumm].setIcon(null);

        }else
        if (firstClick == -1) {                                                                                          //делаем первое нажатие
            firstClick = buttNumm;
            firstImg = new String(winComp.imageFile[buttNumm].getName());
            winComp.button[firstClick].setIcon(new ImageIcon(winComp.buttonIcon[firstClick]));
        } else if (firstClick == buttNumm) {                                                                              //проверяем не нажата ли та самая кнопка второй раз
            JOptionPane.showConfirmDialog(null, "Нажали ту саму кнопку",
                    "Just a test", JOptionPane.PLAIN_MESSAGE);
        } else {                                                                                                         //делаем второе нажатие
            lastClick = buttNumm;
            winComp.button[lastClick].setIcon(new ImageIcon(winComp.buttonIcon[lastClick]));
            lastImg = new String(winComp.imageFile[buttNumm].getName());
            timer();
        }
    }
    private void timer() {
        Timer timer = new Timer();
       TimerTask task = new TimerTask() {
            @Override
            public void run() {

                if (firstClick > -1 & lastClick > -1 & firstImg.equals(lastImg)) {
                    winComp.button[firstClick].setIcon(new ImageIcon(winComp.buttonIcon[firstClick]));
                    winComp.button[lastClick].setIcon(new ImageIcon(winComp.buttonIcon[lastClick]));
                    firstClick = -1;
                    lastClick = -1;
                    endCount++;
                    if(endCount==5){

                        int n = JOptionPane.showConfirmDialog(null,
                                "Would you like green eggs and ham?",
                                "An Inane Question",
                                JOptionPane.YES_NO_OPTION);
                        switch (n) {
                            case 1:    winComp.infoPanel.remove(winComp.timerLabel);
                                winComp.infoPanel.add(winComp.timerLabel);
                                System.out.println(n);
                                winComp.list();

                                int count=0;
                                while ( count < 10) {
                                    winComp.button[count].setIcon(null);
                                    count++;
                                }
                                break;
                            case 2:
                                System.exit(2);
                                break;}


                    }
                } else {
                    winComp.button[firstClick].setIcon(null);
                    winComp.button[lastClick].setIcon(null);
                    firstClick = -1;
                    lastClick = -1;
                }
            }
        };

        timer.schedule(task, 500);
    }
}










