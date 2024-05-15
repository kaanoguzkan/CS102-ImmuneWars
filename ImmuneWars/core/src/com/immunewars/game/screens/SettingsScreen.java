package com.immunewars.game.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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
    String[] musicFiles = {"maoZedongYoldasim.mp3","gerudoValley.mp3","bayonetta2.mp3","wowBackground.mp3","underpressure.mp3","xenobladeChronicles2battle.mp3","persona4.mp3","starcraft.mp3"}; // Your music files
    Music[] musics = new Music[musicFiles.length];
    Music currMusic, tempMusic;
    ImmuneWars game;
    
    public SettingsScreen(ImmuneWars game) 
    {   
        this.game = game;
        
        for(int i = 0; i < musicFiles.length; i++){
            musics[i] =  Gdx.audio.newMusic(Gdx.files.internal(musicFiles[i])); 
        }
        currMusic = game.currMusic;
        tempMusic = currMusic;

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
        musicSelectBox.setItems("Yoldas Mao","Gerudo Valley","Bayonetta 2","Wow Background","Under Pressure","Xenoblade Chronicles 2 Battle","Persona 4","Starcraft");
        musicSelectBox.addListener(new ChangeListener() 
        {
            @Override
            public void changed(ChangeEvent event, Actor actor) 
            {
                String selectedMusic = musicSelectBox.getSelected();
                System.out.println("mehemtcan");
                if(selectedMusic.equals("Yoldas Mao")){
                    System.out.println("mao");
                    currMusic.stop();
                    currMusic = musics[0];
                    tempMusic = currMusic;
                }
                else if(selectedMusic.equals("Gerudo Valley")){
                    System.out.println("gerudo");
                    currMusic.stop();
                    currMusic = musics[1];
                    tempMusic = currMusic;
                }
                else if(selectedMusic.equals("Bayonetta 2")){
                    System.out.println("bayonetta");
                    currMusic.stop();
                    currMusic = musics[2];
                    tempMusic = currMusic;
                }
                else if(selectedMusic.equals("Wow Background")){
                    System.out.println("wow");
                    currMusic.stop();
                    currMusic = musics[3];
                    tempMusic = currMusic;
                }
                else if(selectedMusic.equals("Under Pressure")){
                    System.out.println("under pressure");
                    currMusic.stop();
                    currMusic = musics[4];
                    tempMusic = currMusic;
                }
                else if(selectedMusic.equals("Xenoblade Chronicles 2 Battle"))
                {
                    System.out.println("xenoblade");
                    currMusic.stop();
                    currMusic = musics[5];
                    tempMusic = currMusic;
                }
                else if(selectedMusic.equals("Persona 4"))
                {
                    System.out.println("persona");
                    currMusic.stop();
                    currMusic = musics[6];
                    tempMusic = currMusic;
                }
                else if(selectedMusic.equals("Starcraft"))
                {
                    System.out.println("starcraft");
                    currMusic.stop();
                    currMusic = musics[7];
                    tempMusic = currMusic;
                }
                
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
                    game.currMusic.setVolume(slider.getValue() / 100);
                }

            }
        });


        System.out.println("naaaaaaah ");
        
        // add to table
        table.add(musicLevelLabel);
        table.add(slider);
        table.row();


        // Back Button
        TextButton backButton = new TextButton("Back", skin);
        System.out.println("quit button cons.");
        backButton.addListener(new ChangeListener() 
        {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            game.setScreen(currentScreen);
           
            }
        });
        table.add(backButton);

        // quit Button
        TextButton quitButton = new TextButton("quit", skin);
        System.out.println("quit button cons.");
        quitButton.addListener(new ChangeListener() 
        {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            Gdx.app.exit();// Exit the game
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
