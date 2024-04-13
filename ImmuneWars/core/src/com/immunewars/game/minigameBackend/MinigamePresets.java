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
}