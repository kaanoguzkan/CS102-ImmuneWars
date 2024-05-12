package com.immunewars.game.minigameBackend;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public abstract class MinigamePresets {

	public abstract static class TicTacToe {
		public static int gameSize = 3;
		public static int winLength = 3;
	}
	
	public abstract static class SpaceInvaders {
		public static int xBound = 1280;
		public static int yBound = 800;
		public static int startHealth = 5;
		public static String bulletTexture = "bullet.png";
		public static String bulletTextureFlipped = "bulletFlipped.png";
		public static String enemyTexture = "enemy.png";
		public static String shipTexture = "ship.png";
	}

	public abstract static class Snake {
		public static int xBound = 1280;
		public static int yBound = 800;
		public final static int PIXEL_SIZE = 80;
        public static String snakeHeadTexture ="1.jpg"; // didnt work.
	}

    public abstract static class ImageMatching{
        public static String backOfCard = "1.png";
        public final int X_BOUND = 1280;
        public final int Y_BOUND = 800;
        public final static int DEFAULT_OPTION = 3;

        public static String[] images = {
            "1.png", "2.png",
            "4.png", "5.png",
            "7.png", "8.png"
        };
    }

	public abstract static class SpeedTyping{ //when x bound 1280, the limit is 21 letters
		public static final int BOX_WIDTH = 50;
		public static final int BOX_HEIGHT = 100;
	}
}