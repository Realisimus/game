package game;

import java.io.File;
import java.io.IOException;

public class body {
	
	public static File gamefile = new File("D:\\Bulls_Cows\\game.txt");
	static int N = 3;
	public static char[] SecretNumber;
	public static boolean win = false;
	
	public static void main(final String[] args) throws IOException, InterruptedException {
		NumLib.create();	
		//guess();
		//riddle();
		test();
	}
	
	public static void riddle() throws IOException, InterruptedException {
		Numbers.Generate();
		System.out.println(SecretNumber);
		while (!win) {
			
			Numbers.Check();
		}
	}
	
	public static void guess() throws IOException, InterruptedException {
		int iter =0;
		while (!win) {
			Numbers.NextNumber();
			
			char[] t = WorkInFile.read(2);
			if (t[1] == N ) {
				body.win = true;
			}
			NumLib.clean();
			iter++;
		}		
		WorkInFile.write("\r\n\r\nЯ победил на " + iter + " ход");
	}
	
	public static void test() throws IOException, InterruptedException {
		int iter =0;
		Numbers.Generate();
		String s = "";
		for (int i = 0; i < N; i++) {
			s = s + Character.toString(SecretNumber[i]);
		}
		WorkInFile.write(s + "\r\n");
		while (!win) {
			Numbers.NextNumber();
			WorkInFile.FileLenght = 0;
			Numbers.Check();
			WorkInFile.FileLenght = 0;
			NumLib.clean();
			iter++;
		}		
		WorkInFile.write("\r\n\r\nЯ победил на " + iter + " ход");
	}

}
