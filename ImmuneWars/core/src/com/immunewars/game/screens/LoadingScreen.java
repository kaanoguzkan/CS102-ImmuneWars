package com.immunewars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.immunewars.game.ImmuneWars;

public class LoadingScreen implements Screen{
    public static Texture backgroundTexture;
    public static Sprite backgroundSprite;
    public static Sprite a;
    private SpriteBatch spriteBatch = new SpriteBatch();
    BitmapFont font = new BitmapFont();

    /*
     * https://javadoc.io/doc/com.badlogicgames.gdx/gdx/latest/com/badlogic/gdx/scenes/scene2d/ui/ProgressBar.html
     * 
     * use progress bar
     */
    Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
    SpriteBatch batch;
    Texture backgroundImage;
    LoadingScreen screen;
    /*  
    option;
    0 = Tictactoe
    1 = Space invaders
    2 = spedetype
    3 = snake
    4 = imageMatching
     */
    Stage satge;
    public LoadingScreen(ImmuneWars game, int option){

        backgroundSprite =new Sprite(new Texture("title screen.png"));

        a = new Sprite(new Texture("IM_13.png"));
        backgroundSprite.setBounds(100, 100, 200, 200);
        a.setBounds(300, 300, 200, 200);

        screen = this;
    }

    public void renderBackground() {
        backgroundSprite.draw(spriteBatch);
        a.draw(spriteBatch);
    }

    @Override
    public void render(float delta) {
        spriteBatch.begin();
        
        renderBackground(); 

        font.draw(spriteBatch, "YYYYOOOOOOOOOOOOOOOOOOOO", 100, 100);

        spriteBatch.end();
    }

    @Override
    public void show() {}

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}
}
