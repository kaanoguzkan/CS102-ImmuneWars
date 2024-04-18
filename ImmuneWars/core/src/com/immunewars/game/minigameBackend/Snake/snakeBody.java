package com.immunewars.game.minigameBackend.Snake;

import com.badlogic.gdx.scenes.scene2d.Actor;


public class snakeBody extends Actor{
    int x, y;
    Pixel snakeBody;
    public snakeBody(int x, int y){
        this.x = x;
        this.y = y;
        snakeBody = new Pixel(x, y);
    }
    
    /**
     * sets the pixel at the given new x and y.
     * @param x new x
     * @param y new y
     */
    public void setPixel(int x , int y){
        this.x = x;
        this.y = y;
    }
}
