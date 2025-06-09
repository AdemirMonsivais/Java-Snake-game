package com.utils;

import java.sql.SQLOutput;
import java.util.Arrays;

public class GameConstants {
    static public final int SCREEN_WIDTH = 520;//600
    static public final int SCREEN_HEIGHT = 520;//600
    static public final int UNIT_SIZE = 30;
    static public final int DELAY = 150;

    static public final int X_UPPER_LIMIT = (SCREEN_WIDTH/UNIT_SIZE)+1;
    static public final int Y_UPPER_LIMIT = (SCREEN_HEIGHT/UNIT_SIZE)+1;

    static public final int[] xValues = new int[GameConstants.X_UPPER_LIMIT];
    static public final int[] yValues = new int[GameConstants.Y_UPPER_LIMIT];

    static {




        for (int i = 0; i < GameConstants.X_UPPER_LIMIT; i++) {
            xValues[i] = GameConstants.UNIT_SIZE*i;
        }

        for(int i = 0; i < GameConstants.Y_UPPER_LIMIT; i++){
            yValues[i] = GameConstants.UNIT_SIZE*i;
        }

        System.out.print("X values: ");
        for (int i = 0; i < GameConstants.X_UPPER_LIMIT; i++) {
            System.out.print(xValues[i] + " ");
        }
        System.out.println();

        System.out.print("Y values: ");
        for (int i = 0; i < GameConstants.Y_UPPER_LIMIT; i++) {
            System.out.print(yValues[i] + " ");
        }

        System.out.println();
        System.out.println("X_UPPER_LIMIT:" +X_UPPER_LIMIT);
        System.out.println("Last value: " + xValues[X_UPPER_LIMIT-1]);
        System.out.println("Screen width: " + SCREEN_WIDTH);
    }
}
