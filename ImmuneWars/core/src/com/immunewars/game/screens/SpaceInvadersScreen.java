package com.immunewars.game.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.immunewars.game.GameConfig;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.minigameBackend.MinigamePresets;
import com.immunewars.game.minigameBackend.spaceinvaders.*;

public class SpaceInvadersScreen extends TransitionableScreen {
	public static SpaceInvadersScreen currentScreen;
	final ImmuneWars game;
	
	int cameraX = GameConfig.resolutionX; 
	int cameraY = GameConfig.resolutionY;
	OrthographicCamera camera;
	Viewport viewport;
	SpriteBatch batch;
	int winTreshold = 10;
	
	Ship playerShip;
	float spawnCounter = 1f;
	float spawnInterval = 1f;
	Sprite backgroundSprite;
	SpriteBatch spriteBatch = new SpriteBatch();

	int life;
	int score;
	float gameTime;
	Label scoreLabel;
	Label timeLabel;
	Label livesLabel;
	Label entityCountLabel;
	Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
	Stage foreground;
	Boolean bodyWin;
	TheMapScreen theMainScreen;

	public SpaceInvadersScreen(ImmuneWars game, TheMapScreen theMapScreen) {
		this.theMainScreen = theMapScreen;
		currentScreen = this;
		this.game = game;

		backgroundSprite = new Sprite(new Texture("spaceInvadersBackgroundTransparent.png"));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, cameraX, cameraY);
		viewport = new StretchViewport(cameraX, cameraY, camera);
		viewport.apply();
		batch = new SpriteBatch();
		
		stage = new Stage();
		foreground = new Stage();
		stage.setViewport(viewport);
		foreground.setViewport(viewport);
		Gdx.input.setInputProcessor(stage);
		
		gameTime = 60;
		playerShip = new Ship(640, 0, 40, 40);
		
		scoreLabel = new Label("Score: " + score, skin);
		scoreLabel.setPosition(0, 100);
		scoreLabel.setFontScale(2f);
		
		timeLabel = new Label("Time: " + gameTime, skin);
		timeLabel.setPosition(0, 50);
		timeLabel.setFontScale(2f);
		
		life  = playerShip.health;
		livesLabel = new Label("Lives: " + life, skin);
		livesLabel.setPosition(0, 0);
		livesLabel.setFontScale(2f);
		
		entityCountLabel = new Label("" + 0, skin);
		entityCountLabel.setPosition(700, 400);

		//foreground.addActor(entityCountLabel);
		foreground.addActor(scoreLabel);
		foreground.addActor(livesLabel);
		foreground.addActor(timeLabel);
		stage.addActor(playerShip);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		gameTime -= delta;

		spawnCounter -= delta;
		if (spawnCounter <= 0) {
			Enemy newEnemy = new Enemy((float)(MinigamePresets.SpaceInvaders.xLowerBound + Math.random() * (MinigamePresets.SpaceInvaders.xUpperBound - MinigamePresets.SpaceInvaders.xLowerBound - 80)),
					MinigamePresets.SpaceInvaders.yUpperBound,
					80, 80);
			stage.addActor(newEnemy);
			spawnCounter = spawnInterval;
		}

		Actor[] actors = stage.getActors().toArray();
		//System.out.println(actors.length);
		ArrayList<Actor> destroyedActors = new ArrayList<Actor>();
		ArrayList<Bullet> friendlyBullets = new ArrayList<Bullet>();
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		
		for (Actor actor : actors) {
			if (actor != playerShip) {
				if (actor instanceof SIElement && ((SIElement)actor).collidesWith(playerShip)) {
					playerShip.damage();
					destroyedActors.add(actor);
					
				} else if (actor instanceof Bullet && !((Bullet)actor).isEnemy()) {
					friendlyBullets.add((Bullet)actor);
					
				} else if (actor instanceof Enemy) {
					enemies.add((Enemy)actor);
				}
			}
		}
		
		for (Bullet b : friendlyBullets) {
			for (Enemy e : enemies) {
				if (b.collidesWith(e)) {
					destroyedActors.add(b);
					destroyedActors.add(e);
					score++;
				}
			}
		}
		
		for (Actor actor : destroyedActors) {
			actor.remove();
		}
		
		life = playerShip.health;
		scoreLabel.setText("Score: " + score);
		timeLabel.setText(String.format("Time: %.1f", gameTime));
		livesLabel.setText("Lives: " + life);
		entityCountLabel.setText("entities to defeat: " + enemies.size());

		if (isGameTerminated()) {
			TheMapScreen.score += score;
			game.setScreen(theMainScreen);
		}
  
		stage.act(delta);
		stage.draw();
		
		spriteBatch.begin();
		backgroundSprite.draw(spriteBatch);
		spriteBatch.end();
		
		foreground.act(delta);
		foreground.draw();
		
		//System.out.println(GameConfig.resolutionX * Gdx.input.getX() / Gdx.graphics.getWidth());
		//System.out.println(GameConfig.resolutionY * Gdx.input.getY() / Gdx.graphics.getHeight());
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

	public boolean isGameTerminated()
	{
		if((gameTime <= 0) || (life <= 0) || (score >= winTreshold))
		{
			if(score >= winTreshold)
			{
				bodyWin = true;
				return true;
			}
			else
			{
				return true;
			}
		}
		else
		{
			return false;
		}
	}

	public boolean getBodyWin()
	{
		return bodyWin;
	}

}
