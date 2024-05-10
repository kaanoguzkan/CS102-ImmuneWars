package com.immunewars.game.minigameBackend.Snake;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class Apple extends Actor{
    Pixel appleTile;
    int x, y;
    public Apple(int x, int y){
        appleTile = new Pixel(x, y);
    }

    public void moveElse(int x, int y){
        appleTile.setPixel(x, y);
    }

    public void moveElse(Pixel x){
        appleTile.setPixel(x);
    }

    public int getPixelX() {return appleTile.getX();}
    public int getPixelY() {return appleTile.getY();}
    public Pixel getPixel() {return appleTile;}
}
