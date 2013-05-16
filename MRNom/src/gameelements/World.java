package gameelements;

import java.util.Random;

public class World {

	public static final int WORLD_WIDTH=10;
	public static final int WORLD_HEIGHT=13;
	public static final int SCORE_INCREMENT=13;
	public static final float TICK_INITIAL=0.5f;
	public static final float TICK_DECREMENT=0.05f;
	
	public Snake snake;
	public Stain stain;
	public int score=0;
	float tickTime=0;
	public boolean gameOver=false;
	public boolean[][] available= new boolean[WORLD_WIDTH][WORLD_HEIGHT];
	Random random = new Random();
	static float tick=TICK_INITIAL;
	
	public World(){
		snake=new Snake();
		placeStain();
	}
	
	private void placeStain(){
		for(int x=0;x<WORLD_WIDTH;x++){
			for(int y=0;y<WORLD_HEIGHT;y++){
				available[x][y]=false;
			}
		}
		int len=snake.parts.size();
		for(int i=0;i<len;i++){
			SnakePart part=snake.parts.get(i);
			available[part.x][part.y]=true;
		}
		int stainX=random.nextInt(WORLD_WIDTH);
		int stainY=random.nextInt(WORLD_HEIGHT);
		while(true){
		if(available[stainX][stainY]==false) break;
		stainX+=1;
		if(stainX>WORLD_WIDTH){
			stainX=0;
			stainY+=1;
			if(stainY>WORLD_HEIGHT)
				stainY=0;
		}
	}
		stain= new Stain(stainX, stainY, random.nextInt(3));
	}

	public void update(float deltaTime){
		if(gameOver) return;
		tickTime+=deltaTime;
		while(tickTime>tick){
			tickTime-=tick;
			snake.move();
			if(snake.checkBitten()){
				gameOver=true;
				return;
			}
			SnakePart head=snake.parts.get(0);
			if(head.x==stain.x && head.y==stain.y){
				score+=SCORE_INCREMENT;
				snake.grow();
				if(snake.parts.size()==(int)(WORLD_HEIGHT*WORLD_WIDTH)/2){
					gameOver=true;
					return;
				}else placeStain();
				if(score%100==0 && tick-TICK_DECREMENT>0)
					tick-=TICK_DECREMENT;
				
			}
		}
		
	}

	


}
