package com.io;

import javax.swing.JPanel;

import com.logic.Apple;
import com.utils.GameConstants;
import com.logic.Snake;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public class GamePanel extends JPanel{

    private final Snake snake;
    private final Apple apple;

    public GamePanel(Snake snake, Apple apple){
        this.snake = snake;
        this.apple = apple;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Point point = new Point();


        for(int i = 0; i < GameConstants.X_UPPER_LIMIT;i++){
            for(int j = 0; j < GameConstants.Y_UPPER_LIMIT; j++){
                point.x = i;
                point.y = j;

                if(i==0){
                    g.setColor(new Color(108, 232, 95));
                    g.fillRect(GameConstants.xValues[point.x],GameConstants.yValues[point.y],GameConstants.UNIT_SIZE,GameConstants.UNIT_SIZE);

                }
                if(i%2!=0 && j%2!=0){
                    g.setColor(new Color(181, 251, 171));
                    g.fillRect(GameConstants.xValues[point.x],GameConstants.yValues[point.y],GameConstants.UNIT_SIZE,GameConstants.UNIT_SIZE);

                }
                if(i%2 == 0 && j%2 == 0){
                    g.setColor(new Color(181, 251, 171));
                    g.fillRect(GameConstants.xValues[point.x],GameConstants.yValues[point.y],GameConstants.UNIT_SIZE,GameConstants.UNIT_SIZE);
                }
                if(i%2 != 0 && j%2 == 0){
                    g.setColor(new Color(145, 255, 128));
                    g.fillRect(GameConstants.xValues[point.x],GameConstants.yValues[point.y],GameConstants.UNIT_SIZE,GameConstants.UNIT_SIZE);
                }
                if(i%2==0 && j%2 !=0){
                    g.setColor(new Color(157, 255, 103));
                    g.fillRect(GameConstants.xValues[point.x],GameConstants.yValues[point.y],GameConstants.UNIT_SIZE,GameConstants.UNIT_SIZE);

                }

            }
        }

        //draw snake:
        for(int i = 0; i < snake.getBody().size(); i++) {
            point.x = snake.getBody().get(i).x;
            point.y = snake.getBody().get(i).y;
            if (i == 0) {
                g.setColor(new Color(38, 126, 29));
            } else {
                g.setColor(new Color(87, 197, 78));
            }
            g.fillRect(GameConstants.xValues[point.x],GameConstants.yValues[point.y], 30, 30);
        }

        point.x = snake.getBody().getFirst().x;
        point.y = snake.getBody().getFirst().y;

        point.x = apple.getPosition().x;
        point.y = apple.getPosition().y;

        g.setColor(Color.RED);
        g.fillOval(GameConstants.xValues[point.x],GameConstants.yValues[point.y],GameConstants.UNIT_SIZE,GameConstants.UNIT_SIZE);
    }



}
