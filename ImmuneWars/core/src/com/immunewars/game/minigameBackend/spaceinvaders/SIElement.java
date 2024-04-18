package com.immunewars.game.minigameBackend.spaceinvaders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.immunewars.game.minigameBackend.MinigamePresets;

public abstract class SIElement extends Actor {
	protected boolean isEnemy = false;
	protected Texture texture;
	
	protected void moveBounded(float x, float y) {
		float newXMin = this.getX() + x;
		float newXMax = newXMin + this.getWidth();
		
		float newYMin = this.getY() + y;
		float newYMax = newYMin + this.getHeight();
		
		if (newXMin < 0) {
			newXMax -= newXMin;
			newXMin = 0;
		}
		
		if (newXMax > MinigamePresets.SpaceInvaders.xBound) {
			newXMin = MinigamePresets.SpaceInvaders.xBound - getWidth();
			newXMax = MinigamePresets.SpaceInvaders.xBound;
		}
		
		if (newYMin < 0) {
			newYMax -= newYMin;
			newYMin = 0;
		}
		
		if (newYMax > MinigamePresets.SpaceInvaders.yBound) {
			newYMin = MinigamePresets.SpaceInvaders.yBound - getHeight();
			newYMax = MinigamePresets.SpaceInvaders.yBound;
		}
		
		this.setBounds(newXMin, newYMin, this.getWidth(), this.getHeight());
	}
	
	protected void forceMove(float x, float y) {
		this.moveBy(x, y);
	}
	
	protected boolean isOutOfBounds() {
		return getX() < 0
				|| getY() < 0
				|| getX() + getWidth() > MinigamePresets.SpaceInvaders.xBound
				|| getY() + getHeight() > MinigamePresets.SpaceInvaders.yBound;
	}
	
	public boolean collidesWith(SIElement element) {
		return getX() < element.getX() + element.getWidth() &&
				getY() < element.getY() + element.getHeight() &&
				getX() + getWidth() > element.getX() &&
				getY() + getHeight() > element.getY();
				
	}
	
	public void draw (Batch batch) {
		batch.draw(texture, getX(), getY(), getWidth(), getHeight());
	}
	
	public void draw (Batch batch, float parentAlpha) {
		batch.draw(texture, getX(), getY(), getWidth(), getHeight());
	}
	
}
