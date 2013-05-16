package mrnomgame;

import interfaces.Screen;
import classes.AndroidGame;

public class MRNomGame extends AndroidGame {

	
	@Override
	public Screen getStartScreen() {
		
		return new LoadingScreen(this);
	}

	
}
