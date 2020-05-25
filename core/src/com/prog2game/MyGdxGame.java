package com.prog2game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.prog2game.screens.*;

public class MyGdxGame extends Game {

	///-Constants:
	public final static int MENU = 0;
	public final static int PREFERENCES = 1;
	public final static int APPLICATION = 2;
	public final static int ENDGAME = 3;
	public final static int OPENING = 4;

	//-Properties:
	private LoadingScreen loadingScreen;
	private PreferencesScreen preferencesScreen;
	private MenuScreen menuScreen;
	private FightScreen fightScreen;
	private EndScreen endScreen;
	private Opening openingScreen;

	//-Methods:
	@Override
	public void create () {
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);

	}

     // Method used to switch between screen objects
	public void changeScreen (int screen) {
		switch(screen){

			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen(this);
				this.setScreen(menuScreen);
				break;
			case PREFERENCES:
				if(preferencesScreen == null) preferencesScreen = new PreferencesScreen(this);
				this.setScreen(preferencesScreen);
				break;
			case APPLICATION:
				if(fightScreen == null) fightScreen = new FightScreen(this);
				this.setScreen(fightScreen);
				break;
			case ENDGAME:
				if(endScreen == null) endScreen = new EndScreen(this);
				this.setScreen(endScreen);
				break;
			case OPENING:
				if( openingScreen== null) openingScreen = new Opening(this);
				this.setScreen(openingScreen);
				break;

		}
	}

	/// Will in/decrease a position x or y till determine pos
	public static float scroll (float pos,float destination,float speed){

		float delta_1 = Gdx.graphics.getDeltaTime();
		if (pos < destination){
			pos += delta_1 * speed;
		}
		else if (pos > destination + 1){
			pos -= delta_1 * speed;
		}
		return pos;
	}

}
