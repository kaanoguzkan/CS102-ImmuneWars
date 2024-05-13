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
import com.immunewars.game.minigameBackend.anImage;
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

	String[] imagePathways = MinigamePresets.ImageMatching.images;
	ImageButton[] theButtons = new ImageButton[imagePathways.length];

	public ImageMatchingScreen(ImmuneWars game, int gameSize){
		stage = new Stage();
		currentScreen = this;

		String[] buttonCheckedPaths = imagePathways;
		String buttonUpPath = MinigamePresets.ImageMatching.backOfCard;
		TextureRegionDrawable drawableButtonUpTexture = new TextureRegionDrawable(new TextureRegion(new Texture(buttonUpPath)));
		drawableButtonUpTexture.setMinSize(200, 100);

		Drawable drawableButtonDownTexture = drawableButtonUpTexture.tint(new Color(1f,1f,1f,0.5f));

			for (int i = 0; i < buttonCheckedPaths.length; i++) {
				ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
				style.up = drawableButtonUpTexture;
				style.down = drawableButtonDownTexture;
				style.checked = new TextureRegionDrawable(new TextureRegion(new Texture(buttonCheckedPaths[i])));
		
				theButtons[i] = new ImageButton(style);
				theButtons[i].setBounds((currentScreen.gameScreenX / imagePathways.length) * i, 0, 100, 100);

				stage.addActor(theButtons[i]);
			}
			
			System.out.println("skdnfksdbfuksenfose");

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
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);

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