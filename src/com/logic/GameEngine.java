package com.logic;

import java.awt.*;

import com.utils.Direction;
import com.utils.GameConstants;
/**
 *
 * @class GameEngine: Manages the movement of the snake, possible collitions, game state management.
**/
public class GameEngine {
    private final Snake snake;
    private final Apple apple;

    private boolean running = true;

    public GameEngine(Snake snake, Apple apple){
        this.snake = snake;
        this.apple = apple;

        apple.reallocate(snake.getBody());
    }

    public void update(){
        if(!running) return;


        snake.move();

        Point head = snake.getBody().getFirst();

        //System.out.println("Head from GameENgine:" + head);
        //Check apple collition
        if(head.equals(apple.getPosition())) {
            snake.grow();
            apple.reallocate(snake.getBody());
        }

        //System.out.println("From game engine: " + System.currentTimeMillis());
        //Check wall collition
        if(head.x < 0 || head.y < 0 ||
                head.x >= GameConstants.X_UPPER_LIMIT ||
                head.y >= GameConstants.Y_UPPER_LIMIT){
            running = false;
            System.out.println(running);
        }

        //Check Self Collition
        if(snake.checkSelfCollision()) {
            running = false;
        }

    }

    public void restart(){
        System.out.println(running);

        if(!running) {
            running = true;
            System.out.println(running);
            snake.setDirection(Direction.RIGHT);
            snake.restart();
            apple.reallocate(snake.getBody());
        }
    }

    public boolean isRunning() {
        return running;
    }
}
