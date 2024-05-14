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
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.minigameBackend.MinigamePresets;
import com.immunewars.game.minigameBackend.TicTacToe;
import com.immunewars.game.GameConfig;

public class TicTacToeScreen extends TransitionableScreen {
	static TicTacToeScreen currentScreen;
	final ImmuneWars game;
	TicTacToe backend;
	
	int cameraX = Math.min(GameConfig.resolutionX, GameConfig.resolutionY); 
	int cameraY = cameraX;
	OrthographicCamera camera;
	Viewport viewport;
	
	int gameSize;
	int winLength;
	
	float buttonLengthX, buttonLengthY;
	float lineThickness;

	boolean playerTurn;
	Image[] buttons;
	public boolean[] availableButtons;
	
	public TicTacToeScreen(ImmuneWars game) {
		this(game, MinigamePresets.TicTacToe.gameSize, MinigamePresets.TicTacToe.winLength);
	}
	
	public TicTacToeScreen(ImmuneWars game, int gameSize, int winLength) {
		availableButtons = new boolean[gameSize * gameSize];
		for(int i = 0; i < availableButtons.length; i++){
			availableButtons[i] = true;
		}
		buttons = new Image[gameSize * gameSize];
		currentScreen = this;
		this.game = game;
		this.backend = new TicTacToe(gameSize, winLength);
		
		this.gameSize = gameSize;
		this.winLength = winLength;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, cameraX, cameraY);
		viewport = new StretchViewport(cameraX, cameraY, camera);
		viewport.apply();
		
		stage = new Stage();
		stage.setViewport(viewport);
		Gdx.input.setInputProcessor(stage);
		
		lineThickness = Math.max(Math.min(40 / (gameSize + 1), 10), 5);
		buttonLengthX = ((float)(cameraX - lineThickness)/gameSize - lineThickness);
		buttonLengthY = ((float)(cameraY - lineThickness)/gameSize - lineThickness);
		
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				int a = i; int b = j;
				Image button = new Image(new Texture("mapBackground.png"));
				button.setX(lineThickness + i*(buttonLengthX + lineThickness));
				button.setY(lineThickness + j*(buttonLengthY + lineThickness));
				button.setSize(buttonLengthX, buttonLengthY);
				button.setColor(new Color(1.0f,1.0f,1.0f,1.0f));
				button.setDrawable(new TextureRegionDrawable(new TextureRegion(new Texture("mapBackground.png"))));
				
				button.addListener(new ClickListener() {
					@Override
					public void clicked (InputEvent event, float x, float y) {
						if(playerTurn){
							int xIndex = (int) Math.round((button.getX() - lineThickness)/(buttonLengthX+lineThickness));
							int yIndex = (int) Math.round((button.getY() - lineThickness)/(buttonLengthY+lineThickness));
							int mehmetcan = a * 3 + b;
							System.out.println(xIndex + " ASDASD " + yIndex + " DASDA " + mehmetcan);
							TicTacToe backend = TicTacToeScreen.currentScreen.backend;
							backend.setTile(xIndex, yIndex);
							backend.switchChar(); // Böööööö!!!!!!!!!
							availableButtons[mehmetcan] = false;
							playerTurn = false;
							for(boolean element: availableButtons){System.out.println(element);}
							button.setDrawable(new TextureRegionDrawable(new TextureRegion(new Texture("logo.png"))));
						}
					}
				});
				
				buttons[i * 3 + j] = button;
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
		stage.act();
		stage.draw();
		float lineSpacingX = ((float)(cameraX - lineThickness)) / gameSize;
		float lineSpacingY = ((float)(cameraY - lineThickness)) / gameSize;
		for (int i = 0; i <= gameSize; i++) {
			ShapeRenderer newLine = new ShapeRenderer();
			newLine.setProjectionMatrix(camera.combined);
			newLine.begin(ShapeType.Filled);
			newLine.setColor(Color.BLUE);
			newLine.rect(lineSpacingX*i, 0, lineThickness, cameraX);
			newLine.rect(0, lineSpacingY*i, cameraY, lineThickness);
			newLine.end();
		}
		if(!playerTurn){
			this.computerPlay();
		}
		if(backend.didSomeoneWin()){Gdx.app.exit();}
		if(this.isGameDraw()){Gdx.app.exit();}
	}

	public void computerPlay(){
		int xIndex = (int) (Math.random() * 3);
		int yIndex = (int) (Math.random() * 3);
		System.out.println(availableButtons[xIndex * 3 + yIndex]);
		if(availableButtons[xIndex * 3 + yIndex]){
			System.out.println("haha" + availableButtons[xIndex * 3 + yIndex]);
			backend.setTile(xIndex, yIndex);
			buttons[xIndex * 3 + yIndex].setDrawable(new TextureRegionDrawable(new TextureRegion(new Texture("IMBackground.png"))));
			availableButtons[xIndex * 3 + yIndex] = false;
			System.out.println(xIndex + " " + yIndex);
			backend.switchChar(); // Böööööö!!!!!!!!!
			playerTurn = true;
			for(boolean element: availableButtons){System.out.println(element);}
		}else{
			computerPlay();
		}
	}

	public boolean isGameDraw(){
		boolean result = true;
		for(boolean element: availableButtons){
			if(element){
				return !element;
			}
		}
		return result;
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
