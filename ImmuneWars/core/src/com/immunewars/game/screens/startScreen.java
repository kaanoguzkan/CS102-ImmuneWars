package com.immunewars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.immunewars.game.ImmuneWars;

public class startScreen implements Screen {
    private ImmuneWars game;
    private SpriteBatch batch;
    private Texture background;
    private Stage stage;

    public startScreen(ImmuneWars game) {
        batch = new SpriteBatch();
        background = new Texture("startScreen.png"); // Replace "background.png" with your actual background image file

        // stage add 
        this.game = game;
        stage = new Stage();
        Gdx.input.setInputProcessor(stage); // Start taking input from the UI

    
    }

    @Override
    public void show() {
        // Called when the screen becomes the current screen of the game
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw the background
        stage.act();
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        stage.draw();
            
    }

    @Override
    public void resize(int width, int height) {
        // Called when the screen size is changed
    }

    @Override
    public void pause() {
        // Called when the game is paused
    }

    @Override
    public void resume() {
        // Called when the game is resumed from a paused state
    }

    @Override
    public void hide() {
        // Called when the screen is no longer the current screen of the game
    }

    @Override
    public void dispose() {
        // Dispose of any resources used by the screen
        batch.dispose();
        background.dispose();
    }
}
