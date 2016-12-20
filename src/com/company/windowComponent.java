package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.Timer;

class windowComponent {
    File[] imageFile = new File[10];
    BufferedImage[] buttonIcon = new BufferedImage[10];
    JButton[] button = new JButton[10];
    List<Integer> list = new ArrayList();
    private JLabel label1;
    JPanel infoPanel;
    public JLabel timerLabel;

    private class TimerLabel extends JLabel {
        public TimerLabel(Timer timer) {
            timer.scheduleAtFixedRate(timerTask, 0, 1000);
        }

        private TimerTask timerTask = new TimerTask() {
            private volatile int time = -1;
            private Runnable refresher = new Runnable() {
                @Override
                public void run() {
                    int t = time;
                    TimerLabel.this.setText(String.format("%02d:%02d", t / 60, t % 60));
                }
            };

            @Override
            public void run() {
                time++;
                SwingUtilities.invokeLater(refresher);
            }
        };
    }

    windowComponent() {
        list();                             //Генерация случайньІх чисел от 0-10. Функция внизу класса
        ClickEngine cl = new ClickEngine(this);
        JPanel windowContent = new JPanel();
        JPanel buttonPanel = new JPanel();
        infoPanel = new JPanel();

        FlowLayout fl = new FlowLayout();
        BorderLayout bl = new BorderLayout();
        GridLayout gl = new GridLayout(5, 5, 5, 5);

        windowContent.setLayout(bl);
        buttonPanel.setLayout(gl);
        infoPanel.setLayout(fl);

        timerLabel = new TimerLabel(new Timer());
        timerLabel.setFont(new Font(timerLabel.getFont().getFontName(), timerLabel.getFont().getStyle(), 16));
        infoPanel.add(timerLabel);
        label1 = new JLabel("Ваше время:");


        infoPanel.add(label1);


        for (int q = 0; q < 10; q++) {
            button[q] = new JButton(String.valueOf(q));
            buttonPanel.add(button[q]);
            button[q].addActionListener(cl);
        }

        label1.setSize(20, 20);
        windowContent.add("North", infoPanel);
        windowContent.add("Center", buttonPanel);

        //Создаем фрейм
        JFrame windowFrame = new JFrame("Memory Game");
        windowFrame.setContentPane(windowContent);
        windowFrame.setSize(700, 700);
        windowFrame.setLocation(450, 15);
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setVisible(true);
    }

    public void rndImg() throws IOException {

        imageFile[list.get(0)] = new File("D:\\Soft\\Java project\\Project 2 Game\\src\\images\\1.png");
        imageFile[list.get(1)] = new File("D:\\Soft\\Java project\\Project 2 Game\\src\\images\\2.jpg");
        imageFile[list.get(2)] = new File("D:\\Soft\\Java project\\Project 2 Game\\src\\images\\3.jpg");
        imageFile[list.get(3)] = new File("D:\\Soft\\Java project\\Project 2 Game\\src\\images\\4.png");
        imageFile[list.get(4)] = new File("D:\\Soft\\Java project\\Project 2 Game\\src\\images\\5.jpg");

        imageFile[list.get(5)] = new File("D:\\Soft\\Java project\\Project 2 Game\\src\\images\\1.png");
        imageFile[list.get(6)] = new File("D:\\Soft\\Java project\\Project 2 Game\\src\\images\\2.jpg");
        imageFile[list.get(7)] = new File("D:\\Soft\\Java project\\Project 2 Game\\src\\images\\3.jpg");
        imageFile[list.get(8)] = new File("D:\\Soft\\Java project\\Project 2 Game\\src\\images\\4.png");
        imageFile[list.get(9)] = new File("D:\\Soft\\Java project\\Project 2 Game\\src\\images\\5.jpg");

        int count = 0;
        while (count < 10) {
            buttonIcon[count] = ImageIO.read(imageFile[count]);
            //  button[count].setIcon(new ImageIcon(buttonIcon[count]));
            count++;
        }
    }

    public void list() {  //Генерируем колецкию рандомньІх цьІфрт от 1 до 10
        Random randNumber = new Random();
        int num, count2;
        for (int i = 0; i < 50; i++) {
            num = randNumber.nextInt(10);
            count2 = -1;
            for (int n : list) {
                if (n == num)
                    count2++;
            }
            if (count2 == -1)
                list.add(num);
        }
    }
    public void timer (){



    }


}


