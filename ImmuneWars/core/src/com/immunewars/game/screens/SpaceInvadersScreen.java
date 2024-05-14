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
	
	Ship playerShip;
	float spawnCounter = 3f;
	float spawnInterval = 1f;
	Sprite backgroundSprite;
	SpriteBatch spriteBatch = new SpriteBatch();

	int life;
	Label livesLabel;
	Label entityCountLabel;
	Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

	public SpaceInvadersScreen(ImmuneWars game) {
		currentScreen = this;
		this.game = game;

		backgroundSprite = new Sprite(new Texture("spaceInvadersBackground.png"));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, cameraX, cameraY);
		viewport = new StretchViewport(cameraX, cameraY, camera);
		viewport.apply();
		batch = new SpriteBatch();
		
		stage = new Stage();
		stage.setViewport(viewport);
		Gdx.input.setInputProcessor(stage);
		
		playerShip = new Ship(640, 0, 80, 80);
		life  = playerShip.health;
		livesLabel = new Label("lives: " + life, skin);
		livesLabel.setPosition(800, 400);
		entityCountLabel = new Label("" + 0, skin);
		entityCountLabel.setPosition(700, 400);

		stage.addActor(entityCountLabel);
		stage.addActor(livesLabel);
		stage.addActor(playerShip);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {

		spawnCounter -= delta;
		if (spawnCounter <= 0) {
			Enemy newEnemy = new Enemy((float)(Math.random()) * (MinigamePresets.SpaceInvaders.xBound - (180 + 80)) + 180,
					MinigamePresets.SpaceInvaders.yBound,
					80, 80);
			stage.addActor(newEnemy);
			spawnCounter = spawnInterval;
		}

		spriteBatch.begin();
		backgroundSprite.draw(spriteBatch);
		spriteBatch.end();

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
				}
			}
		}
		
		for (Actor actor : destroyedActors) {
			actor.remove();
		}
		
		life = playerShip.health;
		livesLabel.setText("lives: " + life);
		entityCountLabel.setText("entities to defeat: " + enemies.size());

		stage.act(delta);
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
