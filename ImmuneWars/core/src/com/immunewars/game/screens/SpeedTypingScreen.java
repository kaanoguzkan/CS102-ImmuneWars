package com.immunewars.game.screens;

import java.util.ArrayList;
import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.Texture;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.minigameBackend.SpeedTyping.Box;
import com.immunewars.game.GameConfig;

public class SpeedTypingScreen implements Screen
{

    ImmuneWars game;
    int cameraX = GameConfig.resolutionX; 
	int cameraY = GameConfig.resolutionY;
	OrthographicCamera camera;
	Viewport viewport;
	Stage stage;
	SpriteBatch batch;
    final int SPACE_BETWEEN_BOXES = 10;
    ArrayList<Box> boxes = new ArrayList<Box>();
    public TextField textField; 
    String word;
    Label label;
    Group boxGroup;
    Group letters;
    String wordList[] = {"carbohydrate", "aminoacid", "protein", "bacteria", "nucleicacid"};
    int score = 0;
    Label scoreLabel;

    public SpeedTypingScreen(ImmuneWars game)
    {
        this.game = game;

        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        boxGroup = new Group();
        letters = new Group();

        textField = new TextField("", skin);
        textField.setVisible(false);

        label = new Label("", skin);
        label.setPosition(500, 700);
        
        
        camera = new OrthographicCamera();
		camera.setToOrtho(false, cameraX, cameraY);
		
        viewport = new StretchViewport(cameraX, cameraY, camera);
		viewport.apply();
		
		scoreLabel = new Label("Score: ", skin);
        scoreLabel.setPosition(0, cameraY - 20);
        
        stage = new Stage();
        stage.setViewport(viewport);
        Gdx.input.setInputProcessor(stage);
        
        stage.addActor(textField);
        stage.addActor(label);
        stage.addActor(boxGroup);
        stage.addActor(letters);
        stage.addActor(scoreLabel);
        stage.setKeyboardFocus(textField);

        Random rand = new Random();
        int a = rand.nextInt(wordList.length);
        newWord(wordList[a]);
    }

    public void newWord(String  newWord)
    {
        word = newWord;
        label.setText(word);
        int indent = (GameConfig.resolutionX -(word.length() * Box.BOX_WIDTH + (word.length() - 1) * SPACE_BETWEEN_BOXES)) / 2;
        boxes = new ArrayList<Box>();
        for (int i = 0; i <  word.length(); i++)
        {
            Box box = new Box(indent + i * (Box.BOX_WIDTH + SPACE_BETWEEN_BOXES) , letters, word, i);
            boxes.add(box);
            boxGroup.addActor(box);
        }

    }

    @Override
    public void show() {
       
    }

    @Override
    public void render(float delta) 
    {
        scoreLabel.setText("Score: " + score);
        Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        for (int i = 0; i < textField.getText().length(); i++)
        {
            if (i >= boxes.size())
            {
                break;
            }
            boxes.get(i).updateLetter(textField.getText());
        }
        for (int i = textField.getText().length(); i < word.length(); i++)
        {
            boxes.get(i).updateLetter();
        }

        if (check())
        {
            score++;

            textField.setText("");;
            
            for(int i = 0; i < boxes.size(); i++)
            {
                boxes.get(i).delete();
            }
            Random rand = new Random();
            int a = rand.nextInt(wordList.length);
            newWord(wordList[a]);
        }
        
        stage.act();
        stage.draw();
    }

    public boolean check()
    {
        for (Box box : boxes)
        {
            if (!box.check())
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {
      
    }

    @Override
    public void resume() {
     
    }

    @Override
    public void hide() {
      
    }

    @Override
    public void dispose() {
       
    }

}
