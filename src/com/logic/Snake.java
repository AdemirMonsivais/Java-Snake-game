package com.logic;

import java.awt.Point;
import java.util.ArrayList;
import com.utils.Direction;
public class Snake{
    private Direction direction = Direction.RIGHT;
    private  ArrayList<Point> body;
    private boolean growing;

    public Snake() {
        body = new ArrayList<>();
       // body.add(new Point(2, 0));
        body.add(new Point(1, 0));
        body.add(new Point(0, 0));
    }

    public void move(){
        Point newHead = new Point(body.getFirst());

        switch (direction){
            case UP:
                newHead.y--;
                break;
            case DOWN:
                newHead.y++;
                break;
            case LEFT:
                newHead.x--;
                break;
            case RIGHT:
                newHead.x++;
                break;
        }

        body.addFirst(newHead);

        if(!growing){
            body.removeLast();
        }else{
            growing = false;
        }
    }

    public boolean checkSelfCollision(){
        for(int i = 1; i < body.size(); i++){
            if(body.getFirst().equals(body.get(i)))
                return true;
        }
        return false;
    }

    public void grow(){
        growing = true;
    }

    public ArrayList<Point> getBody() {
        return body;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void restart() {
        body = new ArrayList<>();
        System.out.println("Hello in restart method SNake");
        body.add(new Point(1, 0));
        body.add(new Point(0, 0));
    }
}
