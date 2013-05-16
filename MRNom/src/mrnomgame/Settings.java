package mrnomgame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import interfaces.FileIO;

public class Settings {
	public static boolean soundEnabled=true;
	public static int[]highScores=new int[]{100,80,60,40,20};
	
	public static void load(FileIO file){
		BufferedReader in=null;
		try{
			in= new BufferedReader(new InputStreamReader(file.readFile(".mrnom")));
			soundEnabled=Boolean.parseBoolean(in.readLine());
			for(int i=0;i<5;i++)
				highScores[i]=Integer.parseInt(in.readLine());
		}catch(IOException e){
			//Defaults save the day man.
		}
		catch (NumberFormatException e) {
			//Defaults save the day man.
		}
		finally{
			try{
				if(in!=null) in.close();
			}catch(IOException e){}
		}
	}
	
	public static void save(FileIO file){
		BufferedWriter out=null;
		try{
			out= new BufferedWriter(new OutputStreamWriter(file.writeFile(".mrnom")));
			out.write(Boolean.toString(soundEnabled));
			for(int i=0;i<5;i++)
				out.write(Integer.toString(highScores[i]));
		}catch(IOException e){}
		catch (NumberFormatException e) {
			//Defaults save the day man.
		}
		finally{
			try{
				if(out!=null) out.close();
			}catch(IOException e){}
		}
	}
	public static void addScore(int score) {
		for (int i = 0; i < 5; i++) {
			if (highScores[i] < score) {
				for (int j = 4; j > i; j--)
					highScores[j] = highScores[j - 1];
				highScores[i] = score;
				break;
			}
		}
	}

}
