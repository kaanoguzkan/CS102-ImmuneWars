package com.immunewars.game.minigameBackend.SpeedTyping;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class Box extends Actor{

    public static final int BOX_HEIGHT = 100;
    public static final int BOX_WIDTH = 50;
    public String letter = "A";
    Texture texture;
    Label label;
    String word;
    int boxNumber;

    public Box (int x, Group letters, String word, int boxNumber)
    {
        this.boxNumber = boxNumber;
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
        if (word.substring(boxNumber, boxNumber + 1).equals(letter) )
        {
            label.setColor(Color.GREEN);
        }
        else
        {
            
            label.setColor(Color.RED);
        }
    }

    public boolean check()
    {
        if (word.substring(boxNumber, boxNumber + 1).equals(letter) )
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
        letter = input.substring(boxNumber, boxNumber + 1);
    }

    public void updateLetter()
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
