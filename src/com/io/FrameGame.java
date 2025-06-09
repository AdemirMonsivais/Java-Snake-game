package com.io;

import com.logic.Apple;
import com.utils.Direction;
import com.utils.GameConstants;
import com.logic.GameEngine;
import com.logic.Snake;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;

public class FrameGame extends JFrame{

    public FrameGame(){
        setTitle("Snake Game");
        setSize(GameConstants.SCREEN_WIDTH+20, GameConstants.SCREEN_HEIGHT+GameConstants.UNIT_SIZE+25);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Snake snake = new Snake();
        Apple apple = new Apple();

        GamePanel gamePanel = new GamePanel(snake, apple);
        gamePanel.setLayout(null);
        gamePanel.setPreferredSize(new Dimension(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT));

        GameEngine gameEngine = new GameEngine(snake, apple);

         Timer timer = new Timer(GameConstants.DELAY, e-> {
             gameEngine.update();
             if(!gameEngine.isRunning()){
                 ((Timer) e.getSource()).stop();
             }else {
                 gamePanel.repaint();
             }

         });

        InputMap im = gamePanel.getInputMap();
        ActionMap am = gamePanel.getActionMap();

        im.put(KeyStroke.getKeyStroke("ENTER"), "enterPressed");
        im.put(KeyStroke.getKeyStroke("UP"), "upPressed");
        im.put(KeyStroke.getKeyStroke("DOWN"), "downPressed");
        im.put(KeyStroke.getKeyStroke("RIGHT"), "rightPressed");
        im.put(KeyStroke.getKeyStroke("LEFT"), "leftPressed");



        am.put("enterPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello!!!");
                if(!gameEngine.isRunning()){
                    gameEngine.restart();
                    gamePanel.repaint();
                    timer.start();
                }
            }
        });


        am.put("upPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Direction direction = Direction.UP;
                if(direction != Direction.getOpositeDirection(snake.getDirection())){
                    snake.setDirection(direction);
                }
            }
        });

        am.put("downPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Direction direction = Direction.DOWN;
                if(direction != Direction.getOpositeDirection(snake.getDirection())){
                    snake.setDirection(direction);
                }
            }
        });

        am.put("rightPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Direction direction = Direction.RIGHT;
                if(direction != Direction.getOpositeDirection(snake.getDirection())){
                    snake.setDirection(direction);
                }
            }
        });

        am.put("leftPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Direction direction = Direction.LEFT;
                if(direction != Direction.getOpositeDirection(snake.getDirection())){
                    snake.setDirection(direction);
                }
            }
        });


        setContentPane(gamePanel);
        setVisible(true);
        timer.start();//starting in the beginning ot the game
    }
}
