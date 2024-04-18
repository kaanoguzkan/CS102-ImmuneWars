package com.immunewars.game.minigameBackend;

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
		public final static int PIXEL_SIZE = 25;
		/*  code for whether to have a bound for snake or not, put it in snakeHead's headCanMoveAtDirection method
		It PROBALY will work
		open space is better since it still is in implementation
		however the classes and methods that will be used is final
		plus the way it works is rather funny
        if(option == 1){ // W
            if(this.y + 1 <= MinigamePresets.Snake.yBound / MinigamePresets.Snake.PIXEL_SIZE){
                result = true;
            }else{
                result = false;
            }
        }else if(option == 2){ // A
            if(this.x - 1 >= 0){
                result = true;
            }else{
                result = false;
            }
        }else if(option == 3){ // S
            if(this.y - 1 >= 0){
                result = true;
            }else{
                result = false;
            }
        }else if(option == 4){ // D
            if(this.x + 1 <= MinigamePresets.Snake.xBound / MinigamePresets.Snake.PIXEL_SIZE){
                result = true;
            }else{
                result = false;
            }
        }
        } */
	}
}