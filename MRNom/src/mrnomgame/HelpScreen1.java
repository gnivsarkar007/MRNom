package mrnomgame;

import java.util.List;

import staticclasses.Assets;

import interfaces.Game;
import interfaces.Graphics;
import interfaces.Input.TouchEvent;
import interfaces.Screen;

public class HelpScreen1 extends Screen {

	public HelpScreen1(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents=game.getInput().getTouchEvents();
		int len=touchEvents.size();
		for(int i=0;i<len;i++){
			TouchEvent event=touchEvents.get(i);
			if(event.type==TouchEvent.TOUCH_UP){
				if(event.x > 256 && event.y > 416 ) {
					game.setScreen(new HelpScreen2(game));
					if(Settings.soundEnabled)
					Assets.click.play(1);
					return;
					
					}
			}
		}
	}

	@Override
	public void present(float deltaTime) {
		Graphics g =game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0);
		g.drawPixmap(Assets.help1, 64, 100);
		g.drawPixmap(Assets.buttons, 256, 416, 0, 64, 64, 64);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
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
