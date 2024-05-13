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
import com.immunewars.game.minigameBackend.MinigamePresets;
import com.immunewars.game.minigameBackend.TicTacToe;
import com.immunewars.game.minigameBackend.anImage;
import com.immunewars.game.GameConfig;

public class ImageMatchingScreen implements Screen {
	/*
	 * I have just learned that we can just add clickListener to Image classes
	 * :D
	 * 
	 */
	static ImageMatchingScreen currentScreen;
	final ImmuneWars game;

	int gameScreenX = Math.min(GameConfig.resolutionX, GameConfig.resolutionY); 
	int gameScreenY = gameScreenX;
	OrthographicCamera camera;
	Viewport viewport;
	Stage stage;
	
	int gameSize;
	int winLength;
	
	float buttonLengthX, buttonLengthY;
	float lineThickness;
    String[] imagePaths = MinigamePresets.ImageMatching.images;
	public ImageMatchingScreen(ImmuneWars game, int gameSize){
		currentScreen = this;
		this.game = game;
		
		this.gameSize = gameSize;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, gameScreenX, gameScreenY);
		viewport = new StretchViewport(gameScreenX, gameScreenY, camera);
		viewport.apply();
		
		stage = new Stage();
		stage.setViewport(viewport);
		Gdx.input.setInputProcessor(stage);
		
		lineThickness = Math.max(Math.min(40 / (gameSize + 1), 10), 5);
		buttonLengthX = ((float)(gameScreenX - lineThickness)/gameSize - lineThickness);
		buttonLengthY = ((float)(gameScreenY - lineThickness)/gameSize - lineThickness);
		
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
                anImage button = new anImage(new TextureRegionDrawable(new Texture(imagePaths[i + j])), i + j);

				button.setX(lineThickness + i*(buttonLengthX + lineThickness));
				button.setY(lineThickness + j*(buttonLengthY + lineThickness));
				button.setSize(buttonLengthX, buttonLengthY);
				button.setColor(new Color(1.0f,1.0f,1.0f,1.0f));
				
				button.addListener(new ClickListener() {
					@Override
					public void clicked (InputEvent event, float x, float y) {
						int xIndex = (int) Math.round((button.getX() - lineThickness)/(buttonLengthX+lineThickness));
						int yIndex = (int) Math.round((button.getY() - lineThickness)/(buttonLengthY+lineThickness));
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
		float lineSpacingX = ((float)(gameScreenX - lineThickness)) / gameSize;
		float lineSpacingY = ((float)(gameScreenY - lineThickness)) / gameSize;
		for (int i = 0; i <= gameSize; i++) {
			ShapeRenderer newLine = new ShapeRenderer();
			newLine.setProjectionMatrix(camera.combined);
			newLine.begin(ShapeType.Filled);
			newLine.setColor(Color.BLUE);
			newLine.rect(lineSpacingX*i, 0, lineThickness, gameScreenX);
			newLine.rect(0, lineSpacingY*i, gameScreenY, lineThickness);
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