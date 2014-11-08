package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class body {
	
	public static File gamefile = new File("D:\\game.txt");
	public static int N = 6;
	public static int[] SecretNumber;
	public static boolean win = false;
	
	public static void main(final String[] args) throws IOException {
			
		NumLib.create();
						
		if (!gamefile.exists()){
			throw new FileNotFoundException(gamefile.getName());
			}
		SecretNumber = WorkInFile.read(N);
		
		while (!win) {		
			Numbers.NextNumber(); //Следующее число
			Numbers.Check(); //Подсчет быков и коров
			NumLib.clean(); //Чистка массива возможных чисел			
		}
		
	}

}
