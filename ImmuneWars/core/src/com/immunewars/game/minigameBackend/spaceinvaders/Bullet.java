package com.immunewars.game.minigameBackend.spaceinvaders;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.immunewars.game.minigameBackend.MinigamePresets;


public class Bullet extends SIElement {
	float speed = 500;
	boolean isEnemy = false;
	
	public Bullet(float x, float y, float width, float height, boolean isEnemy) {
		this.isEnemy = isEnemy;
		setBounds(x, y, width, height);
		if (isEnemy) {
			texture = new Texture(Gdx.files.internal(MinigamePresets.SpaceInvaders.bulletTextureFlipped));
		} else {
			texture = new Texture(Gdx.files.internal(MinigamePresets.SpaceInvaders.bulletTexture));
		}
	}
	
	public Bullet(float x, float y, float width, float height) { 
		setBounds(x, y, width, height);
		texture = new Texture(Gdx.files.internal(MinigamePresets.SpaceInvaders.bulletTexture));
	}
	
	public void act(float delta) {
		if (isEnemy) {
			forceMove(0,-delta*speed);
		} else {
			forceMove(0,delta*speed);
		}
		
		if (isOutOfBounds()) {
			this.remove();
		}
	}
	
	public boolean isEnemy() {return isEnemy;}
	
}
