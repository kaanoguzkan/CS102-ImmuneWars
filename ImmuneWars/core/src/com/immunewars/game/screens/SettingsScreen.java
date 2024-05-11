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
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.immunewars.game.ImmuneWars;


public class SettingsScreen extends ScreenAdapter
{
    private Stage stage;
    
    public SettingsScreen(ImmuneWars game) 
    {
        stage = new Stage(new ScreenViewport()); // Create a stage with a screen-fitting viewport
        Gdx.input.setInputProcessor(stage); // Start taking input from the stage
        createUI(); // Create the UI
    }
    
        
     
    

    private void createUI() {
        // Create a table for layout
        Table table = new Table();
        table.setFillParent(true); // Make the table fill the screen
        stage.addActor(table); 

        // Background Music Section
        Label musicLabel = new Label("Background Music", new Label.LabelStyle(new BitmapFont(), Color.WHITE)); // Default font and white color
        SelectBox<String> musicSelectBox = new SelectBox<>(new SelectBox.SelectBoxStyle()); // Default style
        String[] musicFiles = {"music1.mp3", "music2.ogg", "music3.wav"}; // Your music files
        SelectBox<String> musicSelect = new SelectBox<>(new SelectBox.SelectBoxStyle(new BitmapFont(), Color.WHITE, null, new ScrollPane.ScrollPaneStyle(), new List.ListStyle())); // Default style without Skin
        musicSelect.setItems(musicFiles);
        musicSelect.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String selectedMusic = musicSelect.getSelected();
                // ... (Load and play the selected music) ...
            }
        });


        
        // Add music label and select box to the table
        table.add(musicLabel);
        table.add(musicSelectBox);
        table.row(); // Move to the next row 

        // Change Resolution Section
        Label resolutionLabel = new Label("Resolution", new Label.LabelStyle(new BitmapFont(), Color.WHITE)); // Default font and white color
        SelectBox<String> resolutionSelectBox = new SelectBox<>(new SelectBox.SelectBoxStyle()); // Default style
        resolutionSelectBox.setItems("800x600", "1024x768", "1280x720", "1920x1080"); // Add resolution options
        resolutionSelectBox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Handle resolution selection change (e.g., change the game resolution) 

            }
        });

        // Quit Button
        TextButton quitButton = new TextButton("Quit", new TextButton.TextButtonStyle()); // Default style
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