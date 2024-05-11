package com.immunewars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.immunewars.game.ImmuneWars;


public class SettingsScreen extends ScreenAdapter
{
    private Stage stage;
    SelectBox<String> musicSelectBox;

    public SettingsScreen(ImmuneWars game) 
    {
        stage = new Stage(new ScreenViewport()); // Create a stage with a screen-fitting viewport
        Gdx.input.setInputProcessor(stage); // Start taking input from the stage
        createUI(); // Create the UI
        System.out.println("screen constructed");
    }
    
    private void createUI() {
        // Create a table for layout
        Table table = new Table();
        table.setFillParent(true); // Make the table fill the screen
        stage.addActor(table); 

        // Background Music Section
        Label musicLabel = new Label("Background Music", new Label.LabelStyle(new BitmapFont(), Color.WHITE)); // Default font and white color
        
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

            musicSelectBox = new SelectBox<>(skin); // Default style
            System.out.println("nothing wrong here");

        System.out.println("-------------------------");

        String[] musicFiles = {"music1.mp3", "music2.ogg", "music3.wav"}; // Your music files

        SelectBox<String> musicSelect;
        musicSelect = new SelectBox<>(skin); // Default style without Skin
        System.out.println("musicSelect constrcuted");
        musicSelect.setItems(musicFiles);
        musicSelect.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String selectedMusic = musicSelect.getSelected();
                // ... (Load and play the selected music) ...
            }
        });
    
        System.out.println("naaaaaaah ");
        


        
        // Add music label and select box to the table
        table.add(musicLabel);
        table.add(musicSelectBox);
        table.row(); // Move to the next row 


        Label resolutionLabel = new Label("Resolution", new Label.LabelStyle(new BitmapFont(), Color.WHITE)); // Default font and white color
        SelectBox<String> resolutionSelectBox = new SelectBox<>(skin); // Default style
        resolutionSelectBox.setItems("800x600", "1024x768", "1280x720", "1920x1080"); // Add resolution options
        resolutionSelectBox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Handle resolution selection change (e.g., change the game resolution) 
            }
        });
        // Change Resolution Section


        // Quit Button
        TextButton quitButton = new TextButton("Quit", skin); // Default style
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
        Gdx.gl.glClearColor(0, 0, 0, 1); // Clear screen with black
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta); // Update stage logic
        stage.draw(); // Draw the stage
    }

    @Override
    public void dispose() 
    {
        stage.dispose(); 
    }
    
}
