package com.Test;

import javax.swing.SwingUtilities;
import com.app.App;


public class SnakeGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
           new App().InitGUI();
        });

    }
}
