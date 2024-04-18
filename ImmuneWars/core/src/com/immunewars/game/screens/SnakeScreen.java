package com.immunewars.game.screens;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.immunewars.game.GameConfig;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.minigameBackend.MinigamePresets;
import com.immunewars.game.minigameBackend.Snake.Apple;
import com.immunewars.game.minigameBackend.Snake.Pixel;
import com.immunewars.game.minigameBackend.Snake.snakeBody;
import com.immunewars.game.minigameBackend.Snake.snakeHead;


/** Main screen, core of the snake game
 * snake body and head are seperate classes even though almost every func is the same
 * it is as it is for possible implementations / putting a proper image to it in the future
 * -
 * Someday I may put some funcs in pixel class such as getPixel() to reduce copy-code
 * In that way it is better but not clearer.
 * And may delete the grid-line-making-part of the render()
 * but in that way it can be a bit too overwhelming to play.
 * Possible score implementation can be made via snakeParts.size()
 * -
 * It will be very hard to implement a map-background image on this game.
 * The important things such as pixel size are mentioned in MinigamePresets.
 * -
 * Have we decided whether if we will play the games using WASD or not btw?
 * We may declare it in MinigamePresets to make these look cooler idk
 * -
 * remove all of the comments if it overwhelms, it is enough if at least 1 human red all of the things.
 * I can't because Akmuhammed happened to me.
 * -
 * snake should not tp to other side of the box whenever it reaches a side right?
 * -
 * check MinigamePresets class.
 * -Ü
 */

public class SnakeScreen implements Screen{

    private ShapeRenderer shapeRenderer;
    public static SnakeScreen currentScreen;
	final ImmuneWars game;
	
	int cameraX = GameConfig.resolutionX; 
	int cameraY = GameConfig.resolutionY;
	OrthographicCamera camera;
	Viewport viewport;
	Stage stage;
	SpriteBatch batch;
	
    snakeBody snakePart;
	snakeHead theSnakeHead;
    Apple theApple;
    ArrayList<Pixel> snakeParts;
    final int PIXEL_SIZE = MinigamePresets.Snake.PIXEL_SIZE;
    final int BOARD_WIDTH = MinigamePresets.Snake.xBound;
    final int BOARD_HEIGHT = MinigamePresets.Snake.yBound;
    final int  VERTICAL_PIXELS = BOARD_WIDTH / PIXEL_SIZE, HORIZONTAL_PIXELS = BOARD_HEIGHT / PIXEL_SIZE;
    int tempX, tempY;
    float tick;
    Pixel currPixel, targetPixel;
	
    /**
     * Constructor of the snake game
     * @param game , in our case immunewars
     */
    public SnakeScreen(ImmuneWars game) {
        snakeParts = new ArrayList<Pixel>();
		currentScreen = this;
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, cameraX, cameraY);
		viewport = new StretchViewport(cameraX, cameraY, camera);
		viewport.apply();
		batch = new SpriteBatch();
		
		stage = new Stage();
		stage.setViewport(viewport);
		Gdx.input.setInputProcessor(stage);
		
		theSnakeHead = new snakeHead(1,1, PIXEL_SIZE); // snakeHead declare
        theApple = new Apple(10 ,10); // Apple declare

		stage.addActor(theSnakeHead); // add snakeHead
        this.create(); //calls the func create which creates shape renderer, and possibly more ¯\_(ツ)_/¯
	}

    public void create() {
        shapeRenderer = new ShapeRenderer();
    }

    //for every tick delta this method is called
    @Override
    public void render(float delta) {

        Random rand = new Random();
        if(theSnakeHead.intersects(theApple)){
            System.out.println("interact apple!");
            Pixel memApple = new Pixel(theApple.getPixel());
            snakeParts.add(memApple);
            theApple.moveElse(rand.nextInt(VERTICAL_PIXELS), rand.nextInt(HORIZONTAL_PIXELS));
        }

        Gdx.gl.glClearColor(0, 0, 0, 1); // set color to black
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //grid lines
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(0, 1, 0, 1); // Set color to green
        for(int i = 0; i < BOARD_WIDTH / PIXEL_SIZE; i++) {
            shapeRenderer.line(i*PIXEL_SIZE, 0, i*PIXEL_SIZE, BOARD_HEIGHT); // vertical pixels
            shapeRenderer.line(0, i*PIXEL_SIZE, BOARD_WIDTH, i*PIXEL_SIZE); // horizontal pixels
        }
        shapeRenderer.end();

        shapeRenderer.begin(ShapeType.Filled);
        //shapeRenderer already set to green

        //SnakeHead
        currPixel = new Pixel(theSnakeHead.getPixel());
        targetPixel = new Pixel(theSnakeHead.getPixel());

        stage.act(delta); // the only thing that acts is snakeHead which does it at the slowed tick rate!!!

        shapeRenderer.rect(theSnakeHead.getPixelX() * PIXEL_SIZE, theSnakeHead.getPixelY() * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);

        /*snake body
         * Updates its cordinates whenever head moves, which moves at a slower tick rate at his own class
         */
        if(theSnakeHead.didHeadMove()){
            for(Pixel element: snakeParts){
                currPixel.setPixel(element);
                element.setPixel(targetPixel);
                targetPixel.setPixel(currPixel);
            }
        }
        // render snake body
        for(Pixel element: snakeParts){
            System.out.println("renders" + element.getX() + " " + element.getY() + "while head is at" + theSnakeHead.getPixelX() + " " + theSnakeHead.getPixelY());
            System.out.println();
            shapeRenderer.rect(element.getX() * PIXEL_SIZE, element.getY() * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        }

        //Apple
        shapeRenderer.setColor(1, 0, 0, 1); // Set color to red
        shapeRenderer.rect(theApple.getPixelX() * PIXEL_SIZE, theApple.getPixelY() * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);

        shapeRenderer.end(); // useless..? i am too afraid to delete it.

    }
    
    /* --------------  Useless ones for now.
     * 
     */

    @Override
    public void pause() {
    
        // TODO :D
        // cant we just throw a new stage for menu?
        //does the pause method actually pause?
    }

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
