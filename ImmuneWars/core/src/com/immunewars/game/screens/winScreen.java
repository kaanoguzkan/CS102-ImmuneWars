package com.immunewars.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.immunewars.game.ImmuneWars;

public class winScreen implements Screen{
    public static Sprite backgroundSprite;
    public static Sprite a;
    private SpriteBatch spriteBatch = new SpriteBatch();

    public winScreen(ImmuneWars game){
        backgroundSprite =new Sprite(new Texture("winScreen.png"));
        backgroundSprite.setBounds(0, 0, 1280, 800);
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        ;
    }

    @Override
    public void render(float delta) {
        spriteBatch.begin();
        backgroundSprite.draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        ;
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        ;
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        ;
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        ;
    }
}
