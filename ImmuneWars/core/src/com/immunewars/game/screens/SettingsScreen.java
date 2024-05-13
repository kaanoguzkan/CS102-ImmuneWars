package com.immunewars.game.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.immunewars.game.ImmuneWars;


public class SettingsScreen extends ScreenAdapter
{
    /*
     * how do we attach it to every screen in this game?
     * extends some form of class or..??
     * bütün oyunu applicationlistenera bağlamak?
     */
    private Stage stage;
    private Viewport viewport;
    SelectBox<String> musicSelectBox, musicLevelSelect;
    Table table;
    Label musicLabel, musicLevelLabel;
    Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
    String[] musicFiles = {"explosion.mp3", "badApple.mp3","maoZedongYoldasim.mp3","gerudoValley.mp3"}; // Your music files
    Music[] musics = new Music[musicFiles.length];
    Music currMusic, tempMusic;
    
    public SettingsScreen(ImmuneWars game) 
    {   
        for(int i = 0; i < musicFiles.length; i++){
            musics[i] =  Gdx.audio.newMusic(Gdx.files.internal(musicFiles[i])); 
        }
        currMusic = musics[0];
        tempMusic = currMusic;
        currMusic.setLooping(true);

        stage = new Stage(new ScreenViewport()); // Create a stage with a screen-fitting viewport
        Gdx.input.setInputProcessor(stage); // Start taking input from the stage
        createUI(); // Create the UI
        System.out.println("screen constructed");
        viewport = new FitViewport(800, 600, new OrthographicCamera());
    }
    
    private void createUI() {
        // Create a table for layout
        table = new Table();
        table.setFillParent(true); // Make the table fill the screen
        stage.addActor(table); 

        // Background Music Section
        musicLabel = new Label("Background Music", new Label.LabelStyle(new BitmapFont(), Color.WHITE)); // Default font and white color
        musicSelectBox = new SelectBox<String>(skin); 
        musicSelectBox.setItems("XYZ","ABC","PQR","LMN","Yoldas Mao","Gerudo Valley");
        musicSelectBox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String selectedMusic = musicSelectBox.getSelected();
                System.out.println("mehemtcan");
                /*
                 * might as well do it a integer holding the indexes of the music
                */
                if(selectedMusic.equals("ABC") && tempMusic != musics[1]){
                    System.out.println("bad apple");
                    currMusic.stop();
                    currMusic = musics[1];
                    tempMusic = currMusic;
                }
                else if(selectedMusic.equals("XYZ") && tempMusic != musics[0]){
                    System.out.println("deltarune");
                    currMusic.stop();
                    currMusic = musics[0];
                    tempMusic = currMusic;
                }
                else if(selectedMusic.equals("Yoldas Mao")&& tempMusic != musics[2]){
                    System.out.println("mao");
                    currMusic.stop();
                    currMusic = musics[2];
                    tempMusic = currMusic;
                }
                else if(selectedMusic.equals("Gerudo Valley") && tempMusic != musics[0]){
                    System.out.println("gerudo");
                    currMusic.stop();
                    currMusic = musics[3];
                    tempMusic = currMusic;
                }
                currMusic.play();
            }
        });

        // add to table
        table.add(musicLabel);
        table.add(musicSelectBox);
        table.row();


        System.out.println("-------------------------");
        // music level label and slider
        musicLevelLabel = new Label("Music Level", new Label.LabelStyle(new BitmapFont(), Color.WHITE)); // Default font and white color

        Slider slider = new Slider(0,100,1,false,skin);
        slider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(slider.isDragging()){
                    System.out.println(slider.getValue());
                    currMusic.setVolume(slider.getValue() / 100);
                }

            }
        });


        System.out.println("naaaaaaah ");
        
        // add to table
        table.add(musicLevelLabel);
        table.add(slider);
        table.row();


        // Quit Button
        TextButton quitButton = new TextButton("Quit", skin);
        System.out.println("quit button cons.");
        quitButton.addListener(new ChangeListener() 
        {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            Gdx.app.exit(); // Exit the game
            }
        });
        table.add(quitButton);
    }

    @Override
    public void render(float delta) 
    {
        currMusic.play();
        Gdx.gl.glClearColor(0, 0, 0, 1); // Clear screen with black
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta); // Update stage logic
        stage.draw(); // Draw the stage
        System.out.println(currMusic.getVolume());

    }

    @Override
    public void dispose() 
    {
        stage.dispose(); 
    }

    
}
