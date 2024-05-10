package com.immunewars.game.minigameBackend;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class anImage extends ImageButton{
    int currPressedPair = -1;
    anImage currPressedImage = null;
    int pairNumber;

    Drawable curr;

    public anImage(Drawable frontSide,  int pairNumber, Drawable backSide){
        super(frontSide);
        curr = frontSide;
        this.pairNumber = pairNumber;
        
    }

    public boolean isSamePair(anImage otherImage){ 
        return (this.pairNumber == otherImage.getPair()); 
    }

    public int getPair(){ return pairNumber;}

    public Drawable getFrontSide(){
        return curr;
    }
}
