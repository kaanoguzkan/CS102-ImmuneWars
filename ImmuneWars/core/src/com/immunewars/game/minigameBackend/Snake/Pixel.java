package com.immunewars.game.minigameBackend.Snake;

/* Snake game only works in pixelated environment, this class is here to provide it.
 * -Ü
 */

public class Pixel {
    int x, y;
    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pixel(Pixel e){
        this.x = e.getX();
        this.y = e.getY();
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

    public void setPixel(Pixel e){
        this.x = e.getX();
        this.y = e.getY();
    }
    
    public int getX() {return x;}
    public int getY() {return y;}

}
