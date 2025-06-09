package com.app;

import com.io.FrameGame;

public class App {
    private final FrameGame frameGame;
    public App(){
        frameGame = new FrameGame();
    }
    public void InitGUI(){
        frameGame.setVisible(true);
    }


}
