package com.dke.hex;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.dke.hex.Screens.MenuScreen;

public class HexDKE extends Game {
	private MenuScreen menuScreen;
	private Screen previousScreen;

	@Override
	public void create() {
		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}

	public Screen getMenuScreen(){
		return menuScreen;
	}

	public void showPauseMenu(){
		menuScreen.setGamePaused(true);
		previousScreen = getScreen();
		setScreen(menuScreen);
	}

	public void hidePauseMenu(){
		setScreen(previousScreen);
		menuScreen.setGamePaused(false);
	}
}
