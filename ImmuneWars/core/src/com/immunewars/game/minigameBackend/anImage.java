package com.immunewars.game.minigameBackend;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class anImage extends Button{
    anImage currPressedImage = null;
    int pairNumber;

    Drawable frontSide;

    public anImage(Drawable frontSide,  int pairNumber){
        super(frontSide);
        this.frontSide = frontSide;
        this.pairNumber = pairNumber;
    }

    public int getPair(){ return pairNumber;}

    public Drawable getFrontSide(){return frontSide;}
}
