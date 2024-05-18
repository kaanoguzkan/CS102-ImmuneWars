package com.immunewars.game.screens;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.immunewars.game.GameConfig;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.minigameBackend.MinigamePresets;
import com.immunewars.game.minigameBackend.Snake.Apple;
import com.immunewars.game.minigameBackend.Snake.Pixel;
import com.immunewars.game.minigameBackend.Snake.SnakeTail;
import com.immunewars.game.minigameBackend.Snake.snakeBody;
import com.immunewars.game.minigameBackend.Snake.snakeHead;

//check minigame presets.

public class SnakeScreen implements Screen{

    private ShapeRenderer shapeRenderer;
    public static SnakeScreen currentScreen;
	final ImmuneWars game;
    Random random = new Random();
	
	int cameraX = GameConfig.resolutionX; 
	int cameraY = GameConfig.resolutionY;
	OrthographicCamera camera;
	Viewport viewport;
	Stage stage;
	SpriteBatch batch;
    int winTreshold = 10;
	
    snakeBody snakePart;
    ArrayList<Pixel> snakeParts; // hmmmmmmmmm
	snakeHead theSnakeHead;
    SnakeTail theSnakeTail;
    Apple theApple;
    final int PIXEL_SIZE = MinigamePresets.Snake.PIXEL_SIZE;
    final int BOARD_WIDTH = MinigamePresets.Snake.xBound;
    final int BOARD_HEIGHT = MinigamePresets.Snake.yBound;
    final int  VERTICAL_PIXELS = BOARD_WIDTH / PIXEL_SIZE, HORIZONTAL_PIXELS = BOARD_HEIGHT / PIXEL_SIZE;
    int tempX, tempY;
    float tick;
    Pixel currPixel, targetPixel;
    private boolean gameTerminated;
	
    /**
     * Constructor of the snake game
     * @param game , in our case immunewars
     */

    /* set speed pixel size etc. 
       colors change according the whichever turn it is?
       kaan has a a lot of work to do.
       set score = snakeParts.size()
     */
    TheMapScreen theMainScreen;
    public SnakeScreen(ImmuneWars game, TheMapScreen theMainScreen) {
        this.theMainScreen = theMainScreen;
        snakeParts = new ArrayList<Pixel>();
		currentScreen = this;
		this.game = game;
        gameTerminated = false;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, cameraX, cameraY);
		viewport = new StretchViewport(cameraX, cameraY, camera);
		viewport.apply();
		batch = new SpriteBatch();
		
		stage = new Stage();
		stage.setViewport(viewport);
		Gdx.input.setInputProcessor(stage);
		
		theSnakeHead = new snakeHead(1,1, PIXEL_SIZE, this); // snakeHead declare
        theSnakeTail = new SnakeTail(theSnakeHead.getPixelX() - 1, theSnakeHead.getPixelY()); // snakeTail declare
        theApple = new Apple(7 ,5); // Apple declare
        System.out.println(theApple.toString());

		stage.addActor(theSnakeHead); // add snakeHead
        this.create(); //calls the func create which creates shape renderer, and possibly more ¯\_(ツ)_/¯


		TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
		buttonStyle.font = new BitmapFont();
		// ugly as fuck btw
		TextureRegionDrawable drawableButtonUpTexture = new TextureRegionDrawable(new TextureRegion(new Texture("button.png")));
		drawableButtonUpTexture.setMinSize(200, 100);
		Drawable drawableButtonDownTexture = drawableButtonUpTexture.tint(new Color(1f,1f,1f,0.5f));
		buttonStyle.up = drawableButtonUpTexture;
		buttonStyle.down = drawableButtonDownTexture;
		
		TextButton button1 = new TextButton("SpaceInvaders", buttonStyle);
        button1.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				System.out.println("Button1 pressed");
                SettingsScreen a = new SettingsScreen(game);
				game.setScreen(a);
			}
		});
        stage.addActor(button1);
	}

    public void create() {
        shapeRenderer = new ShapeRenderer();
    }

    //for every tick delta this method is called
    @Override
    public void render(float delta) {

        if(checkTermination()){
            TheMapScreen.score += snakeParts.size();
            game.setScreen(theMainScreen);
        }

        Gdx.gl.glClearColor(0, 0, 0, 1); // set color to black
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //grid lines
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(0, 1, 0, 1); // Set color to green
        for(int i = 0; i <= BOARD_WIDTH / PIXEL_SIZE; i++) {
            shapeRenderer.line(i*PIXEL_SIZE, 0, i*PIXEL_SIZE, BOARD_HEIGHT); // vertical pixels
            shapeRenderer.line(0, i*PIXEL_SIZE, BOARD_WIDTH, i*PIXEL_SIZE); // horizontal pixels
        }
        shapeRenderer.end();

        shapeRenderer.begin(ShapeType.Filled);
        //shapeRenderer already set to green

        //SnakeHead
        currPixel = new Pixel(theSnakeHead.getPixel());
        targetPixel = new Pixel(currPixel);

        stage.act(delta); // the only thing that acts is snakeHead which does it at the slowed tick rate!!!

        if(theSnakeHead.didHeadMove()){        // for every snake-game-tick
            if(theSnakeHead.intersects(theApple.getPixel())){
                System.out.println("interact apple!");
                Pixel memApple = new Pixel(theApple.getPixel());
                snakeParts.add(memApple);
                theApple.moveElse(randomMoveablePixel());
            }

            if(snakeParts.size() != 0){
                for(Pixel element: snakeParts){
                    currPixel.setPixel(element);
                    element.setPixel(targetPixel);
                    targetPixel.setPixel(currPixel);
                }
            }
            theSnakeTail.setPixel(currPixel);
        }
        
        // render snake body
        shapeRenderer.setColor(new Color(Color.OLIVE));
        for(Pixel element: snakeParts){
            //System.out.println("renders" + element.getX() + " " + element.getY() + "while head is at" + theSnakeHead.getPixelX() + " " + theSnakeHead.getPixelY());
            //System.out.println();
            shapeRenderer.rect(element.getX() * PIXEL_SIZE, element.getY() * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        }
        //tail
        shapeRenderer.setColor(new Color(Color.OLIVE));
        shapeRenderer.rect(theSnakeTail.getPixelX() * PIXEL_SIZE, theSnakeTail.getPixelY() * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        
        //Apple
        shapeRenderer.setColor(new Color(Color.RED)); // Set color to red
        shapeRenderer.rect(theApple.getPixelX() * PIXEL_SIZE, theApple.getPixelY() * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);

        //head
        shapeRenderer.setColor(new Color(Color.GREEN)); // Set color to green
        shapeRenderer.rect(theSnakeHead.getPixelX() * PIXEL_SIZE, theSnakeHead.getPixelY() * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        
        
        shapeRenderer.end(); // useless..? i am too afraid to delete it.

    }

    @Override
    public void pause() {
    
        // TODO :D
        // cant we just throw a new stage for menu?
        //does the pause method actually pause?
    }

    public Pixel randomMoveablePixel(){
        Pixel result = new Pixel(random.nextInt(VERTICAL_PIXELS), random.nextInt(HORIZONTAL_PIXELS));
        for(Pixel element: snakeParts){
            if(result.equals(element)){
                return randomMoveablePixel();
            }
        }
        return result;
    }

    public boolean checkTermination(){
        for(Pixel element: snakeParts){
            if(theSnakeHead.intersects(element)){
                return true;
            }
        }
        return false;
    }

    public void terminateGame(){gameTerminated = true;}

    @Override
    public void resize(int width, int height) {}
    
    @Override
    public void show() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}
    
}
