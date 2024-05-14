package com.immunewars.game.minigameBackend.Snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.immunewars.game.minigameBackend.MinigamePresets;
import com.immunewars.game.screens.SnakeScreen;

/*
 * yılan kendine değmemeli
 * yılan yanlara değmemeli
 * değince nolcak.
 * game over? idfk.
 */
public class snakeHead extends Actor{
    private Texture texture;
    Pixel snakeHeadPixel;
    private int x,y;
    private float tick = 0;
    private int option = 4;
    boolean snakeHeadMoved = false;
    private SnakeScreen gameScreen;

    public snakeHead(int x, int y, int PIXEL_SIZE, SnakeScreen screen){
        gameScreen = screen;
        this.x = x;
        this.y = y;
        snakeHeadPixel = new Pixel(x, y);
    }
    
    public void act(float delta) {
        if (Gdx.input.isKeyPressed(Keys.W) && option != 3){ // option != x is to not let head turn 180 degrees
            option = 1;
        }
        else if (Gdx.input.isKeyPressed(Keys.A) && option != 4){
            option = 2;
        }
        else if (Gdx.input.isKeyPressed(Keys.S) && option != 1){
            option = 3;
        }
        else if (Gdx.input.isKeyPressed(Keys.D) && option != 2){
            option = 4;
        }

        //tick-slowing-mechanism to make it proper, otherwise it is too fast.
        if(tick > 0.05){
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
        boolean result = false;
        if(option == 1){ // W
            if(this.y < MinigamePresets.Snake.yBound / MinigamePresets.Snake.PIXEL_SIZE){
                result = true;
            }else{
                gameScreen.terminateGame();
                result = false;
            }
        }else if(option == 2){ // A
            if(this.x > 0){
                result = true;
            }else{
                gameScreen.terminateGame();
                result = false;
            }
        }else if(option == 3){ // S
            if(this.y > 0){
                result = true;
            }else{
                gameScreen.terminateGame();
                result = false;
            }
        }else if(option == 4){ // D
            if(this.x < MinigamePresets.Snake.xBound / MinigamePresets.Snake.PIXEL_SIZE){
                result = true;
            }else{
                gameScreen.terminateGame();
                result = false;
            }
        }
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

    //secret tool
    public void draw (Batch batch) {
		batch.draw(texture, getX(), getY(), getWidth(), getHeight());
	}
	
	public void draw (Batch batch, float parentAlpha) {
		batch.draw(texture, getX(), getY(), getWidth(), getHeight());
	}

    //TODO: may use the collidesWith() func in SI element?

    public boolean intersects(Pixel pixel){
        if(pixel.getX() == this.getPixelX() && pixel.getY() == this.getPixelY()){
            System.out.println("pog");
            return true;
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
