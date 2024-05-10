package com.immunewars.game.minigameBackend.SpeedTyping;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.immunewars.game.minigameBackend.Minigame;
import com.immunewars.game.minigameBackend.MinigamePresets;

public class Box extends Actor{

    public static final int BOX_HEIGHT = MinigamePresets.SpeedTyping.BOX_HEIGHT;
    public static final int BOX_WIDTH = MinigamePresets.SpeedTyping.BOX_WIDTH;
    public String letter = " "; //temporary value
    Texture texture;
    Label label;
    String word;
    int boxIndex;

    public Box (int x, Group letters, String word, int boxNumber)
    {
        this.boxIndex = boxNumber;
        this.word = word;
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        BitmapFont myFont = new BitmapFont();
        labelStyle.font = myFont;

        label = new Label("A", labelStyle);
        label.setPosition(x, 320);
        label.setFontScale(4);
        letters.addActor(label);
        setBounds(x, 300, BOX_WIDTH, BOX_HEIGHT);
        texture = new Texture("pixel.png");
    }

    public void act (float delta)
    {
        label.setText(letter);
        
        if(this.check()){
            label.setColor(Color.GREEN);
        }else{
            label.setColor(Color.RED);
        } 

    }

    public boolean check()
    {
        if (word.substring(boxIndex, boxIndex + 1).equals(letter) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void delete()
    {
        remove();
        label.remove();
    }
    public void updateLetter(String input)
    {
        letter = input.substring(boxIndex, boxIndex + 1);
    }

    public void resetLetter()
    {
        letter = "";
    }

    public void draw (Batch batch) {
		batch.draw(texture, getX(), getY(), getWidth(), getHeight());
        
	}
	
	public void draw (Batch batch, float parentAlpha) {
		batch.draw(texture, getX(), getY(), getWidth(), getHeight());
	}
}
