package com.immunewars.game.minigameBackend.Snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.immunewars.game.minigameBackend.MinigamePresets;
import com.immunewars.game.minigameBackend.spaceinvaders.SIElement; // possibly to use it later.

public class snakeHead extends Actor{
    Pixel snakeHeadPixel;
    int x,y;
    float tick = 0;
    int option = 2;
    boolean snakeHeadMoved = false;

    public snakeHead(int x, int y, int PIXEL_SIZE){
        this.x = x;
        this.y = y;
        snakeHeadPixel = new Pixel(x, y);
    }
    
    public void act(float delta) {
        if (Gdx.input.isKeyPressed(Keys.W)){
            option = 1;
        }
        else if (Gdx.input.isKeyPressed(Keys.A)){
            option = 2;
        }
        else if (Gdx.input.isKeyPressed(Keys.S)){
            option = 3;
        }
        else if (Gdx.input.isKeyPressed(Keys.D)){
            option = 4;
        }

        //tick-slowing-mechanism to make it more retro, otherwise it is too fast.
        if(tick > 0.1){
            if(this.headCanMoveAtDirection(option)){
                this.moveDirection(option);
            }
            tick = 0;
            snakeHeadMoved = true;
        }else{
            tick += delta;
        }
	}

    public boolean headCanMoveAtDirection(int option){ // check presets
        boolean result = true;
        return result;
    }

    public void moveDirection(int option){
        if(option == 1){
            snakeHeadPixel.setPixel(x, ++y); // W
        }else if(option == 2){
            snakeHeadPixel.setPixel(--x, y); // A
        }else if(option == 3){
            snakeHeadPixel.setPixel(x, --y); // S
        }else if(option == 4){
            snakeHeadPixel.setPixel(++x, y); // D
        }
    }

    //TODO: may use the collidesWith() func in SI element?

    public boolean intersects(Apple theApple){
        if(theApple.getPixelX() == this.getPixelX()){
            if(theApple.getPixelY() == this.getPixelY()){
                System.out.println("pog");
                return true;
            }
        }
        return false;
    }

    public boolean didHeadMove(){
        if(snakeHeadMoved){
            snakeHeadMoved = false; //do not declare it elsewhere.
            return true;
        }else{
            return false;
        }
    }

    public int getPixelX() {return snakeHeadPixel.getX();}
    public int getPixelY() {return snakeHeadPixel.getY();}
    public Pixel getPixel() {return snakeHeadPixel;}
}
