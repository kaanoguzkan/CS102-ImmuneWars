package com.immunewars.game.minigameBackend.ImageMatching;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class anImage extends ImageButton{
    anImage currPressedImage = null;
    int id;

    boolean showTrueForm = false;
    float x, y;

    public anImage(ImageButtonStyle style,  int id, float X, float Y){
        super(style);

        this.id = id;
        this.x = X;
        this.y = Y;
    }
    
    public void getPressed(){
        showTrueForm = true;
    }

    public void getUnpressed(){
        showTrueForm = false;
    }

    public boolean isPressed(){
        return showTrueForm;
    }

    public int getID(){ return id;}

    public float getX(){return x;}

    public float getY(){return y;}
}
