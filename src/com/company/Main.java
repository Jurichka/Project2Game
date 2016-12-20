package com.company;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        windowComponent winComp = new windowComponent();
        try {

            winComp.rndImg();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
