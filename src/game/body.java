package game;

import java.io.File;
import java.io.IOException;

public class body {

	private static File file = new File("D:\\Bulls_Cows\\game.txt");
	private static int n = 5;
	private static NumbersLibrary numbersLibrary = new NumbersLibrary();
	
	public static void main(String[] args) throws IOException, InterruptedException {
		numbersLibrary.create(n);
		//guess();
		//riddle();
		test();
	}

	private static void test() throws IOException, InterruptedException {
		boolean win = false;
		char[] secret = numbersLibrary.random();
		System.out.println(new String(secret));
		WorkInFile.clean(file);
		while (!win) {
			char[] current = numbersLibrary.random();
			WorkInFile.write(current, file);
			WorkInFile.reset();
			WorkInFile.write(numbersLibrary.calc(secret, WorkInFile.read(n, file)), file);
			WorkInFile.reset();
			numbersLibrary.clean(current, WorkInFile.read(2, file));
			if ((int) WorkInFile.read(2, file)[1] == n + 48) {
				win = true;
			}
		}
	}

	private static void riddle() throws IOException, InterruptedException {
		boolean win = false;
		char[] secret = numbersLibrary.random();
		System.out.println(new String(secret));
		WorkInFile.clean(file);
		char[] bc = new char[2];
		while ((int)bc[1] != n + 48) {
			bc = numbersLibrary.calc(secret, WorkInFile.read(n, file));
			WorkInFile.write(bc, file);
		}
	}

	public static void guess() throws IOException, InterruptedException {
		boolean win = false;
		WorkInFile.clean(file);
		while (!win) {
			char[] current = numbersLibrary.random();
			WorkInFile.write(current, file);
			numbersLibrary.clean(current, WorkInFile.read(2, file));
			if ((int) WorkInFile.read(2, file)[1] == n + 48) {
				win = true;
			}
		}
	}


}
