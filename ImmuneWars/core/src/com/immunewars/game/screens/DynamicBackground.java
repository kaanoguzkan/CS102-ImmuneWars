package com.immunewars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class DynamicBackground extends Actor {
	float xOffset = 30;
	float yOffset = 30;
	float x, y;
	float width, height;
	Texture texture;
	
	float transposedX, transposedY;
	float transposedWidth, transposedHeight;
	
	public DynamicBackground(Texture texture, float x, float y, float width, float height) {
		this.setTargetOffset(0.5f, 0.5f);
		this.addAction(new BackgroundAction());
		
		this.x = x - xOffset / 2;
		this.y = y - yOffset / 2;
		this.width = width + xOffset;
		this.height = height + yOffset;
		this.texture = texture;
	}
	
	public void setTargetOffset(float xScalar, float yScalar) {
		transposedX = x - xScalar * xOffset / 2;
		transposedY = y + yScalar * yOffset / 2;
		transposedWidth = width + xScalar * xOffset;
		transposedHeight = height + yScalar * yOffset;
	}
	
	public void draw (Batch batch, float parentAlpha) {
		batch.draw(texture, transposedX, transposedY, width, height);
	}
	
	private class BackgroundAction extends Action {
		
		public boolean act(float delta) {
			float mouseX = Gdx.input.getX();
			float mouseY = Gdx.input.getY();
			
			float mouseXNormalized = mouseX / Gdx.graphics.getWidth() - 0.5f;
			float mouseYNormalized = mouseY / Gdx.graphics.getHeight() - 0.5f;
			((DynamicBackground) this.getActor()).setTargetOffset(mouseXNormalized, mouseYNormalized);
			
			//System.out.println(mouseXNormalized + " " + mouseYNormalized);
			return false;
		}
		
	}
}


