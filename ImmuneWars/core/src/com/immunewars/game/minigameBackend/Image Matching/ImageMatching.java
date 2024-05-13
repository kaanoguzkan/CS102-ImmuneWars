package com.immunewars.game.minigameBackend.ImageMatching;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.minigameBackend.Minigame;
import com.immunewars.game.minigameBackend.MinigamePresets;

public class ImageMatching{
    String[] imagePathways = MinigamePresets.ImageMatching.images;

    ImmuneWars game;
    int gameSize;
    anImage[][] images;

    public ImageMatching(ImmuneWars game, int gameSize){
        int imageAmount = imagePathways.length;
        images = new anImage[gameSize][gameSize];
        this.game = game;
        this.gameSize = gameSize;
    }

    public void pressTile(int row, int column){
    }
}
