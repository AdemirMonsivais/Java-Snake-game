package com.utils;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public static Direction getOpositeDirection(Direction direction){
        return switch (direction){
            case RIGHT -> LEFT;
            case UP -> DOWN;
            case DOWN -> UP;
            case LEFT -> RIGHT;
        };
    }
}
