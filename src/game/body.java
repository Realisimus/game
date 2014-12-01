package game;

import java.io.File;
import java.io.IOException;

public class body {

	private static File file = new File("D:\\Bulls_Cows\\game.txt");
	private static int n = 5;
	private static boolean win = false;
	private static NumbersLibrary numbersLibrary = new NumbersLibrary();
	
	public static void main(String[] args) throws IOException, InterruptedException {
		numbersLibrary.create(n);
		guess();
		//riddle();
		//test();
	}
	
	public static void guess() throws IOException, InterruptedException {
		while (!win) {
			char[] current = numbersLibrary.random();
			WorkInFile.write(current, file);
			numbersLibrary.clean(current, WorkInFile.read(2, file));
			if ((int) WorkInFile.read(2, file)[1] == n + 48) {
				body.win = true;
			}
		}
	}


}
