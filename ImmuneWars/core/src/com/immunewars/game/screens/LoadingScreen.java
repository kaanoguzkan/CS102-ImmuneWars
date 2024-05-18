package com.immunewars.game.screens;

import java.text.Format;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.minigameBackend.Minigame;
import com.immunewars.game.minigameBackend.MinigamePresets;

public class LoadingScreen implements Screen{
    public static Texture backgroundTexture;
    public static Sprite backgroundSprite;
    public static Sprite a;
    private SpriteBatch spriteBatch = new SpriteBatch();
    BitmapFont font = new BitmapFont();
    ShapeRenderer shapeRenderer = new ShapeRenderer();
    float timePassed = 0;
    int progressOfBar = 1280;
    String tip = "TIP:\n";

    Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
    SpriteBatch batch;
    LoadingScreen screen;
    /*  
    option;
    0 = Tictactoe
    1 = Space invaders
    2 = spedetype
    3 = snake
    4 = imageMatching
    */
    int option;
    ImmuneWars game;
    public LoadingScreen(ImmuneWars game, int option){
        this.game = game;
        this.option = option;
        this.option = 4;
        screen = this;
        if(this.option == 0){
            tip += "The following game is a basic tictactoe game\nPress on the tiles which you want to place your mark!";
            backgroundSprite =new Sprite(new Texture("tictactoeLoadingBackground.jpeg"));
        }else if(this.option == 1){
            tip += "The following game is space invaders.\nUse 'w','a','s','d' keys to move and space to shoot!";
            backgroundSprite =new Sprite(new Texture("SpaceInvadersLoadingBackground.jpeg"));
        }else if(this.option == 2){
            tip += "The following game is speedy typing.\nWrite the given word fast as you can!";
            backgroundSprite =new Sprite(new Texture("speedTypingLoadingBackground.jpeg"));
        }else if(this.option == 3){
            tip += "The following game is a basic pixel snake game.\nEat the apples without hitting anything\nby using 'w','a','s','d' keys to move!";
            backgroundSprite =new Sprite(new Texture("snakeLoadingBackground.jpeg"));
        }else if(this.option == 4){
            tip += "The following game is a basic image matching game.\nMemorize the images and press same images";
            backgroundSprite =new Sprite(new Texture("ImageMatchingLoadingBackground.jpeg"));
        }

        backgroundSprite.setBounds(0, 0, 1280, 800);
    }

    public void renderBackground() {
        backgroundSprite.draw(spriteBatch);
    }

    @Override
    public void render(float delta) {

        spriteBatch.begin();
        renderBackground(); 
        if(option == 0){
            font.draw(spriteBatch, tip, 1280 / 2 - 150, 800 / 2 + 150);
        }else if(option == 1){
            font.draw(spriteBatch, tip, 1280 / 2 - 100, 800 / 2 );
        }else if(option == 2){
            font.draw(spriteBatch, tip, 1280 / 2 - 100, 800 / 2 + 150);
        }else if(option == 3){
            font.draw(spriteBatch, tip, 1280 / 2 - 500, 800 / 2 + 50);
        }else if(option == 4){
            font.draw(spriteBatch, tip, 1280 / 2 - 200, 800 / 2);
        }
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(0,0,1280, 10);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);

        timePassed += delta;
        if(timePassed >= 1){
            progressOfBar = 900;
            if(timePassed >= 3){
                progressOfBar = 700;
                if(timePassed >= 4){
                    progressOfBar = 250;
                    if(timePassed >= 5){
                        progressOfBar = 0;
                        if(option == 0){
                            TicTacToeScreen a = new TicTacToeScreen(game, null);
                        }else if(option == 1){
                            font.draw(spriteBatch, tip, 1280 / 2 - 100, 800 / 2 );
                        }else if(option == 2){
                            font.draw(spriteBatch, tip, 1280 / 2 - 100, 800 / 2 + 150);
                        }else if(option == 3){
                            font.draw(spriteBatch, tip, 1280 / 2 - 500, 800 / 2 + 50);
                        }else if(option == 4){
                            font.draw(spriteBatch, tip, 1280 / 2 - 200, 800 / 2);
                        }
                    }
                }
            }
        }
        shapeRenderer.rect(0,0,progressOfBar, 10);
        shapeRenderer.end();
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
