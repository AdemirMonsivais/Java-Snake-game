package com.logic;

import com.utils.GameConstants;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class Apple {
    private final Point position;
    private final Random random = new Random();

    public Apple(){
        position = new Point();
    }

    public Point getPosition() {
        return position;
    }

    public void reallocate(List<Point> snakeBody){
        Point newPosition = new Point();

        while(true){
            int randX = random.nextInt(GameConstants.X_UPPER_LIMIT-1);
            int randY = random.nextInt(GameConstants.Y_UPPER_LIMIT-1);

            newPosition.x = randX;
            newPosition.y = randY;

            if(!snakeBody.contains(newPosition)){
                position.x = newPosition.x;
                position.y = newPosition.y;
               break;
            }
        }
    }
}
