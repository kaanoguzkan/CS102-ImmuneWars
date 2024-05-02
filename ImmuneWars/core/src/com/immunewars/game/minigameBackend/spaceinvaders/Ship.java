package com.immunewars.game.minigameBackend.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.immunewars.game.minigameBackend.MinigamePresets;



public class Ship extends SIElement {
	int score = 0;
	float speed = 300;
	float fireCooldown = 0;
	int health = MinigamePresets.SpaceInvaders.startHealth;
	
	public Ship(int x, int y, int width, int height) {
		setBounds(x, y, width*2, height*2);
		texture = new Texture(Gdx.files.internal(MinigamePresets.SpaceInvaders.shipTexture));
		System.out.println(texture);
	}
	
	public void fire(Stage s, float delta) {
		if (fireCooldown <= 0) {
			s.addActor(new Bullet((getX() + getWidth()/2 - 10f), getY() + getHeight(), 20, 40));
			fireCooldown = 0.5f;
		}
	}
	
	public void damage() {
		health--;
	}
	
	public void act(float delta) {
		if (Gdx.input.isKeyPressed(Keys.A)) {moveBounded(-delta*speed,0);}
		if (Gdx.input.isKeyPressed(Keys.D)) {moveBounded(delta*speed,0);}
		if (Gdx.input.isKeyPressed(Keys.W)) {moveBounded(0,delta*speed);}
		if (Gdx.input.isKeyPressed(Keys.S)) {moveBounded(0,-delta*speed);}
		fireCooldown -= delta;
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {fire(this.getStage(), delta);}
	}
}