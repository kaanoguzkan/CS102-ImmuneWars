package com.immunewars.game.minigameBackend;

public class TicTacToe extends Minigame {
	int gameSize;
	int winLength;
	char[][] gameGrid;
	char currentChar = 'p';
	char char1, char2;
	
	public TicTacToe() {
		this(MinigamePresets.TicTacToe.gameSize, MinigamePresets.TicTacToe.winLength);
	}
	
	public TicTacToe(int gameSize, int winLength) {
		gameGrid = new char[gameSize][gameSize];
		this.gameSize = gameSize;
		this.winLength = winLength;
		
		char1 = 'p';
		char2 = 'c';
	}
	
	public boolean setTile(int x, int y) {
		if (gameGrid[x][y] == '\u0000') {
			gameGrid[x][y] = currentChar;
			return true;
		}
		return false;
	}
	
	public boolean verticalCheck() {
		int maxCount = 1;
		int count = 1;
		
		for (int i = 0; i < gameSize; i++) {
			char lastChar = gameGrid[i][0];
			
			for (int j = 0; j < gameSize; j++) {
				if (lastChar == gameGrid[i][j] && lastChar == currentChar) {
					count++;
				} else {
					count = 1;
					lastChar = gameGrid[i][j];
				}
				
				if (count > maxCount) {maxCount = count;}
			}
		}
		
		return maxCount > winLength;
	}
	
	public boolean horizontalCheck() {
		int maxCount = 1;
		int count = 1;
		
		for (int i = 0; i < gameSize; i++) {
			char lastChar = gameGrid[0][i];
			
			for (int j = 0; j < gameSize; j++) {
				if (lastChar == gameGrid[j][i] && lastChar == currentChar) {
					count++;
				} else {
					count = 1;
					lastChar = gameGrid[j][i];
				}
				
				if (count > maxCount) {maxCount = count;}
			}
		}
		
		return maxCount > winLength;
	}
	
	public boolean diagonalCheck(){
		int maxCount = 1;
        for (int x = 0; x < gameSize; x++){
            for (int y = 0; y < gameSize; y++){
            	
                int count = 1;
                char lastChar = gameGrid[x][y];
                for (int i = x, j = y; i < gameSize && j < gameSize; i++, j++) {
                	if (lastChar == gameGrid[i][j] && lastChar == currentChar) {
    					count++;
    				} else {
    					count = 1;
    					lastChar = gameGrid[i][j];
    				}
                	if (count > maxCount) {maxCount = count;}
                }
                
                count = 1;
                lastChar = gameGrid[x][gameSize-1-y];
                for (int i = x, j = gameSize-1-y; i < gameSize && j >= 0; i++, j--) {
                	if (lastChar == gameGrid[i][j] && lastChar == currentChar) {
    					count++;
    				} else {
    					count = 1;
    					lastChar = gameGrid[i][j];
    				}
                	if (count > maxCount) {maxCount = count;}
                }
            }
        }
        return maxCount > winLength;
    }
	
	public boolean didSomeoneWin() {
		return verticalCheck() || horizontalCheck() || diagonalCheck();
	}
	
	public void switchChar() {
		if (currentChar == char1) {
			currentChar = char2;
		} else {
			currentChar = char1;
		}
	}
	
	public char getTile(int x, int y) {
		return gameGrid[x][y];
	}

	public boolean isComputerTurn(){return currentChar == 'c';}

	public void computerPlay(){
		int x = (int) (Math.random() * 3);
		int y = (int) (Math.random() * 3);
		if(gameGrid[x][y] == '\u0000'){
			this.setTile(x, y);
			return;
		}else{
			computerPlay();
		}
	}
}
