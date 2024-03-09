package com.immunewars.game.screens;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.minigameBackend.TicTacToe;
import com.immunewars.game.GameConfig;

public class TicTacToeScreen implements Screen {
	static TicTacToeScreen currentScreen;
	int cameraX = GameConfig.resolutionX; 
	int cameraY = GameConfig.resolutionY;
	Stage stage;
	TicTacToe backend;
	final ImmuneWars game;
	OrthographicCamera camera;
	int gameSize;
	Viewport viewport;
	float buttonLengthX, buttonLengthY;
	
	public TicTacToeScreen(final ImmuneWars game, int gameSize, int winLength) {
		currentScreen = this;
		this.game = game;
		this.gameSize = gameSize;
		this.backend = new TicTacToe(gameSize, winLength);
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, cameraX, cameraY);
		viewport = new StretchViewport(cameraX, cameraY, camera);
		viewport.apply();
		
		stage = new Stage();
		stage.setViewport(viewport);
		Gdx.input.setInputProcessor(stage);
		
		buttonLengthX = ((float)(cameraX - 5)/gameSize - 5);
		buttonLengthY = ((float)(cameraY - 5)/gameSize - 5);
		
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				Image button = new Image(new Texture("pixel.png"));
				button.setX(5 + i*(buttonLengthX + 5));
				button.setY(5 + j*(buttonLengthY + 5));
				button.setSize(buttonLengthX, buttonLengthY);
				button.setColor(new Color(1.0f,1.0f,1.0f,1.0f));
				
				button.addListener(new ClickListener() {
					@Override
					public void clicked (InputEvent event, float x, float y) {
						int xIndex = (int) Math.round((button.getX() - 5.0)/(buttonLengthX+5));
						int yIndex = (int) Math.round((button.getY() - 5.0)/(buttonLengthY+5));
						TicTacToe backend = TicTacToeScreen.currentScreen.backend;
						System.out.println("---------");
						
						backend.setTile(xIndex, yIndex);
						if (backend.getTile(xIndex, yIndex) == 'p') {
							button.setColor(Color.RED);
						} else {
							button.setColor(Color.BLACK);
						}
						System.out.println(backend.winCheck());
						backend.switchChar();
					}
				});
				
				stage.addActor(button);
			}
		}
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		stage.draw();
		float lineSpacingX = ((float)(cameraX - 5.0)) / gameSize;
		float lineSpacingY = ((float)(cameraY - 5.0)) / gameSize;
		for (int i = 0; i <= gameSize; i++) {
			ShapeRenderer newLine = new ShapeRenderer();
			newLine.setProjectionMatrix(camera.combined);
			newLine.begin(ShapeType.Filled);
			newLine.setColor(Color.BLUE);
			newLine.rect(lineSpacingX*i, 0, 5, cameraX);
			newLine.rect(0, lineSpacingY*i, cameraY, 5);
			newLine.end();
		}
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
