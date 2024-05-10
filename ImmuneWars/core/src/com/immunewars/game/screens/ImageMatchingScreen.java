package com.immunewars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.minigameBackend.MinigamePresets;
import com.immunewars.game.minigameBackend.anImage;
import com.immunewars.game.GameConfig;


public class ImageMatchingScreen implements Screen{
    public static ImageMatchingScreen currentScreen;
	final ImmuneWars game;
	
	float cameraX = GameConfig.resolutionX; 
	float cameraY = GameConfig.resolutionY;
    Stage stage;
    Viewport viewport;
    OrthographicCamera theCamera;
    
    int option;
    Table mainTable, leftTable, rightTable;
    Stage mainStage;

    Texture buttonTexture;
    Drawable buttonDrawable;
    int currPressedButtonPair = -1; // just in case.
    anImage currAnImage = null;

    String[] images = MinigamePresets.ImageMatching.images;
    anImage[] buttons = new anImage[images.length];
    boolean[] checkers = new boolean[buttons.length];
    Texture temp = new Texture(MinigamePresets.ImageMatching.backOfCard); // declares back of the card from presets
    Drawable backOfTheCard = new TextureRegionDrawable(temp);
    Texture curr;

    boolean a1 = false;

    public ImageMatchingScreen(ImmuneWars game, int sideLength){
        mainTable = new Table();
        theCamera = new OrthographicCamera();
        theCamera.setToOrtho(false, GameConfig.resolutionX, GameConfig.resolutionY);
		viewport = new StretchViewport(cameraX, cameraY, theCamera);
        stage = new Stage(viewport);
        System.out.println("mehmetcan");
        
        this.option = sideLength;// 3 side length means 3x3 square; hence 9 images.

        Gdx.input.setInputProcessor(stage);	
        this.game = game;
        currentScreen = this;

        mainTable.setFillParent(true);
        mainTable.setDebug(true);

        for(int i = 0; i < images.length; i++){
            buttonTexture = new Texture(images[i]);
            buttonDrawable = new TextureRegionDrawable(buttonTexture);
            anImage button = new anImage(buttonDrawable, i / 2, backOfTheCard);
            button.setBounds(100,100,200,400); // bounds!!!!! the png file's bound matters.
            // in other words, it does not work.
            button.setSize(255, 25);

            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    System.out.println("pressed." + button.getPair());
                    if(currPressedButtonPair == button.getPair() && currAnImage != button){
                        System.out.println("it works!");
                        //1 sec bekle
                        for(anImage element: buttons){
                            if(element.isSamePair(button)){
                                element.remove();
                                button.remove();
                                break;
                            }
                        }
                    }
                    currPressedButtonPair = button.getPair();
                    currAnImage = button;
                }
            }
            );
            
            mainTable.add(button);
            if(((i + 1) % sideLength) == 0 && (i != 0)){
                mainTable.row();
                System.out.println("row");
            }

            buttons[i] = button;
            checkers[i] = false;
        }
        System.out.println("yea2");
        stage.addActor(mainTable);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pause'");
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resume'");
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hide'");
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispose'");
    }
    
}
