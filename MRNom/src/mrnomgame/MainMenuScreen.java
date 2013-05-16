package mrnomgame;

import interfaces.Game;
import interfaces.Graphics;
import interfaces.Input.TouchEvent;
import interfaces.Screen;

import java.util.List;

import staticclasses.Assets;
import android.util.Log;

public class MainMenuScreen extends Screen {

	public MainMenuScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		Graphics g=game.getGraphics();
		List<TouchEvent>touchEvents= game.getInput().getTouchEvents();
		int len=touchEvents.size();
		for(int i=0;i<len;i++){
			TouchEvent event=touchEvents.get(i);
			Log.d("MAINMENU","TOCHED "+event.x+" "+event.y);
			if(event.type==TouchEvent.TOUCH_UP){
				
				if(inBounds(event, 0, g.getHeight() - 64, 64, 64)) {
					Log.d("MAINMENU","TOCHED 1");
					//Settings.soundEnabled = !Settings.soundEnabled;
					//if(Settings.soundEnabled)
						Assets.click.play(1);
				}
				if(inBounds(event, 64, 220, 192, 42) ) {
					Log.d("MAINMENU","TOCHED 2");
					game.setScreen(new GameScreen(game));
					//if(Settings.soundEnabled)
						Assets.click.play(1);
					return;
				}
				if(inBounds(event, 64, 220 + 42, 192, 42) ) {
					Log.d("MAINMENU","TOCHED 3");
					game.setScreen(new HighscoreScreen(game));
					//if(Settings.soundEnabled)
						Assets.click.play(1);
					return;
				}
				if(inBounds(event, 64, 220 + 84, 192, 42) ) {
					Log.d("MAINMENU","TOCHED 4");
					game.setScreen(new HelpScreen1(game));
					//if(Settings.soundEnabled)
						Assets.click.play(1);
					return;
				}
			}
		}

	}
	public boolean inBounds(TouchEvent event, int x,int y, int width, int height){
		if(event.x > x && event.x < x + width - 1 &&
				event.y > y && event.y < y + height - 1)
				return true;
				else
				return false;
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0);
		g.drawPixmap(Assets.logo, 32, 20);
		g.drawPixmap(Assets.mainMenu, 64, 220);
		//if(Settings.soundEnabled)
		g.drawPixmap(Assets.buttons, 0, 416, 0, 0, 64, 64);
		//else
		//g.drawPixmap(Assets.buttons, 0, 416, 64, 0, 64, 64);

	}

	@Override
	public void pause() {
		//Settings.save(game.getFileIO());
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
