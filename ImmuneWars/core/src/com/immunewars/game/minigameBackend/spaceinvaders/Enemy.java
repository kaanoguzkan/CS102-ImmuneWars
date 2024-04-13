package com.immunewars.game.minigameBackend.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.immunewars.game.minigameBackend.MinigamePresets;

public class Enemy extends SIElement{

	float speed;
	float fireInterval;
	float fireCooldown;
	
	public Enemy(float x, float y, float width, float height) { 
		isEnemy = true;
		setBounds(x, y, width, height);
		texture = new Texture(Gdx.files.internal(MinigamePresets.SpaceInvaders.enemyTexture));
		
		speed = (float)(100 + Math.random() * 200);
		fireInterval = (float)(0.4 + 0.5 * Math.random());
		fireCooldown = fireInterval;
	}
	
	public void fire(Stage s, float delta) {
		if (fireCooldown <= 0) {
			s.addActor(new Bullet((getX() + getWidth()/2 - 10f), getY(), 20, 40, true));
			fireCooldown = fireInterval;
		}
	}
	
	public void act(float delta) {
		forceMove(0,-delta*speed);
		if (isOutOfBounds()) {
			this.remove();
		} else {
			fireCooldown -= delta;
			fire(this.getStage(), delta);
		}
		
		
	}
}
