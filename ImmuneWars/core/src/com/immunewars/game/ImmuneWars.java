package com.immunewars.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.immunewars.game.screens.MainMenuScreen;

public class ImmuneWars extends Game {
	SpriteBatch batch;
	BitmapFont font;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
	}
	
	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1, true);
		super.render();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

}
