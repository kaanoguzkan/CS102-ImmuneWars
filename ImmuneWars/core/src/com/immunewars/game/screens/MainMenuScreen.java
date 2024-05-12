package com.immunewars.game.screens;

import org.w3c.dom.Text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.Texture;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.screens.DynamicBackground;
import com.immunewars.game.screens.ImageMatchingScreen;
import com.immunewars.game.GameConfig;

public class MainMenuScreen implements Screen {
	private float cameraX = GameConfig.resolutionX;
	private float cameraY = GameConfig.resolutionY;
	private Stage stage;
	private Viewport viewport;
	final ImmuneWars game;
	private OrthographicCamera camera;
	private MainMenuScreen curr;

	public MainMenuScreen(final ImmuneWars game) {
		this.game = game;
		curr = this;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, GameConfig.resolutionX, GameConfig.resolutionY);
		viewport = new StretchViewport(cameraX, cameraY, camera);
		viewport.apply();		
		
		stage = new Stage();
		stage.setViewport(viewport);

		DynamicBackground db = new DynamicBackground(new Texture("title screen.png"), 0, 0, GameConfig.resolutionX, GameConfig.resolutionY);

		stage.addActor(db);
		
		Gdx.input.setInputProcessor(stage);	
		TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
		buttonStyle.font = new BitmapFont();
		TextureRegionDrawable drawableButtonUpTexture = new TextureRegionDrawable(new TextureRegion(new Texture("button.png")));
		drawableButtonUpTexture.setMinSize(200, 100);
		Drawable drawableButtonDownTexture = drawableButtonUpTexture.tint(new Color(1f,1f,1f,0.5f));
		buttonStyle.up = drawableButtonUpTexture;
		buttonStyle.down = drawableButtonDownTexture;
		
		TextButton button1 = new TextButton("TicTacToe", buttonStyle);
		TextButton button2 = new TextButton("SpaceInvaders", buttonStyle);
		button2.setBounds(0, 100, 200, 100);
		
		TextButton button3 = new TextButton ("SpeedTyping", buttonStyle);
		button3.setBounds(0, 200, 200, 100);

		TextButton button4 = new TextButton ("Snake", buttonStyle);
		button4.setBounds(0, 300, 200, 100);

		TextButton button5 = new TextButton ("ImagesImagesImages", buttonStyle);
		button5.setBounds(0, 400, 200, 100);

		TextButton button6 = new TextButton ("Settings", buttonStyle);
		button6.setBounds(0, 500, 200, 100);

		TextButton button7 = new TextButton ("Map", buttonStyle);
		button7.setBounds(0, 600, 200, 100);

		TextButton button8 = new TextButton ("Mehmetcan", buttonStyle);
		button8.setBounds(0, 700, 200, 100);

		button1.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				System.out.println("Button1 pressed");
				game.setScreen(new TicTacToeScreen(game));
			}
		});
		button2.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				System.out.println("Button2 pressed");
				game.setScreen(new SpaceInvadersScreen(game));
			}
		});

		button3.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				System.out.println("Button3 pressed");
				game.setScreen(new SpeedTypingScreen(game));
			}
		});

		button4.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				System.out.println("Button4 pressed");
				game.setScreen(new SnakeScreen(game));
			}
		});

		button5.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				System.out.println("Button5 pressed");
				game.setScreen(new ImageMatchingScreen(game,3));
			}
		});
		button6.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				System.out.println("Button6 pressed");
				game.setScreen(new SettingsScreen(game));
			}
		});
		button7.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				System.out.println("Button7 pressed");
				game.setScreen(new TheMapScreen(game));

			}
		});

		button8.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				try{
					System.out.println("Button8 pressed");
					game.setScreen(new LoadingScreen(game,0));
				}
				catch(Exception e){
					System.out.println("eaehfbsejfbkjwefbkweöbgeo");
					e.printStackTrace();
				}

			}
		});
		
		stage.addActor(button1);
		stage.addActor(button2);
		stage.addActor(button3);
		stage.addActor(button4);
		stage.addActor(button5);
		stage.addActor(button6);
		stage.addActor(button7);
		stage.addActor(button8);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		stage.draw();

		stage.act();
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
