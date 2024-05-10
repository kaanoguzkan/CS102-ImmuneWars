package com.immunewars.game.minigameBackend.Snake;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class SnakeTail extends Actor{ //just follow snake head lmao
    private int x, y;
    private Pixel snakeTail;
    public SnakeTail(int x, int y){
        this.x = x;
        this.y = y;
        snakeTail = new Pixel(x, y);
    }

    public SnakeTail(Pixel e){
        snakeTail = new Pixel(e);
        x = snakeTail.getX();
        y = snakeTail.getY();
    }
    
    public void setPixel(int x , int y){
        snakeTail.setPixel(x, y);
        x = snakeTail.getX();
        y = snakeTail.getY();
    }

    public void setPixel(Pixel x){
        this.snakeTail = x;
        this.x = snakeTail.getX();
        y = snakeTail.getY();
    }

    public int getPixelX(){return x;}
    public int getPixelY(){return y;}
    public Pixel getPixel(){return snakeTail;}
}
