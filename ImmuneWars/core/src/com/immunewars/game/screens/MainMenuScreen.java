package com.immunewars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.Texture;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.GameConfig;

public class MainMenuScreen implements Screen {
	float cameraX = GameConfig.resolutionX;
	float cameraY = GameConfig.resolutionY;
	Stage stage;
	Viewport viewport;
	final ImmuneWars game;
	OrthographicCamera camera;
	
	public MainMenuScreen(final ImmuneWars game) {
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, GameConfig.resolutionX, GameConfig.resolutionY);
		viewport = new StretchViewport(cameraX, cameraY, camera);
		viewport.apply();
		
		stage = new Stage();
		stage.setViewport(viewport);
		Gdx.input.setInputProcessor(stage);
		
		TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
		buttonStyle.font = new BitmapFont();
		TextureRegionDrawable drawableButtonUpTexture = new TextureRegionDrawable(new TextureRegion(new Texture("button.png")));
		drawableButtonUpTexture.setMinSize(200, 100);
		Drawable drawableButtonDownTexture = drawableButtonUpTexture.tint(new Color(1f,1f,1f,0.5f));
		buttonStyle.up = drawableButtonUpTexture;
		buttonStyle.down = drawableButtonDownTexture;
		TextButton button = new TextButton("TicTacToe", buttonStyle);
		
		button.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				System.out.println("Button pressed");
				game.setScreen(new TicTacToeScreen(game));
			}
		});
		
		stage.addActor(button);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
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
