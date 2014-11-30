package game;

import java.io.IOException;

public class body {

	private String url = "D:\\Bulls_Cows\\game.txt";
	
	public static void main(String[] args) throws IOException, InterruptedException {

		NumbersLibrary numbersLibrary = new NumbersLibrary();
		numbersLibrary.create(5);

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
			
			char[] t = WorkInFile.read(2, url);
			if ((int) t[1] == N + 48) {
				body.win = true;
			}
			NumLib.clean();
			iter++;
		}		
		WorkInFile.write("\r\n\r\nЯ победил на " + iter + " ход", url);
	}
	
	public static void test() throws IOException, InterruptedException {
		int iter =0;
		Numbers.Generate();
		String s = "";
		for (int i = 0; i < N; i++) {
			s = s + Character.toString(SecretNumber[i]);
		}
		WorkInFile.write(s + "\r\n", url);
		while (!win) {
			Numbers.NextNumber();
			WorkInFile.FileLenght = 0;
			Numbers.Check();
			WorkInFile.FileLenght = 0;
			NumLib.clean();
			iter++;
		}		
		WorkInFile.write("\r\n\r\nЯ победил на " + iter + " ход", url);
	}

}
