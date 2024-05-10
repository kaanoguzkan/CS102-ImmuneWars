package com.immunewars.game.minigameBackend.Snake;

import com.badlogic.gdx.scenes.scene2d.Actor;


public class snakeBody extends Actor{
    private int x, y;
    private Pixel snakeBody;
    public snakeBody(int x, int y){
        this.x = x;
        this.y = y;
        snakeBody = new Pixel(x, y);
    }
    
    public void setPixel(int x , int y){
        this.x = x;
        this.y = y;
    }

    public void setPixel(Pixel x){
        this.snakeBody = x;
    }
}
