package com.immunewars.game.screens;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.minigameBackend.MinigamePresets;
import com.immunewars.game.minigameBackend.TicTacToe;
import com.immunewars.game.minigameBackend.ImageMatching.ImageMatching;
import com.immunewars.game.minigameBackend.ImageMatching.anImage;
import com.immunewars.game.GameConfig;

public class ImageMatchingScreen implements Screen {
	static ImageMatchingScreen currentScreen;
	final ImmuneWars game;
	int gameScreenX = GameConfig.resolutionX; 
	int gameScreenY = GameConfig.resolutionY;
	OrthographicCamera camera;
	Viewport viewport;
	Stage stage;

	int gameSize;
	int prevPressedButtonIndex = -3;
	int currPressedButtons = 0;

	public float inGameTime = 0;


	String[] imagePathways = MinigamePresets.ImageMatching.images;
	Image[] theButtons = new Image[imagePathways.length];
	int row = 0;
	TheMapScreen theMainScreen;

	public ImageMatchingScreen(ImmuneWars game, int gameSize, TheMapScreen theMainScreen){
		this.theMainScreen = theMainScreen;
		stage = new Stage();
		currentScreen = this;

		String[] buttonCheckedPaths = imagePathways;
		String buttonUpPath = MinigamePresets.ImageMatching.backOfCard;

			for (int i = 0; i < buttonCheckedPaths.length; i++) {
				int a = i;

				theButtons[i] = new Image(new TextureRegionDrawable(new TextureRegion(new Texture("IM_6.png"))));
				theButtons[i].setBounds((currentScreen.gameScreenX / imagePathways.length) * i, 0, 100, 100);

				theButtons[i].addListener(new ClickListener() {
					@Override
					public void clicked (InputEvent event, float x, float y) {
						theButtons[a].setDrawable(new TextureRegionDrawable(new TextureRegion(new Texture("logo.png"))));
						currPressedButtons++;
						System.out.println(currPressedButtons);
						if(a / 2 == prevPressedButtonIndex / 2){
							theButtons[a].remove();
							theButtons[prevPressedButtonIndex].remove();
						}
						else if(currPressedButtons == 2){
							System.out.print("lsemflsfmslıemslem\n");
							System.out.println(prevPressedButtonIndex);
							if(prevPressedButtonIndex != -3){
								System.out.println("calismali");
								theButtons[a].setDrawable(new TextureRegionDrawable(new TextureRegion(new Texture("IM_6.png"))));
								theButtons[prevPressedButtonIndex].setDrawable(new TextureRegionDrawable(new TextureRegion(new Texture("IM_6.png"))));
							}
							currPressedButtons = 0;	
						}
						prevPressedButtonIndex = a;
					}
				});
				stage.addActor(theButtons[i]);
			}
		currentScreen = this;
		this.game = game;
		
		this.gameSize = gameSize;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, gameScreenX, gameScreenY);
		viewport = new StretchViewport(gameScreenX, gameScreenY, camera);
		viewport.apply();

		
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void show() {
		
	}


	@Override
	public void render(float delta) {
		inGameTime = delta;
		stage.act();
		stage.draw();
		if(this.isGameTerminated()){
			theMainScreen.score++;
			game.setScreen(theMainScreen);
		}
	}

	public float getDelta(float delta){return delta;}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);

	}

	public boolean isGameTerminated(){
		for(Image element: theButtons){
			//if(element.)
		}
		return true;
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

}