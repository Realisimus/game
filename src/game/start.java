package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class start {
	
	//public static String url = "D:\\game.txt";
	public static File gamefile = new File("D:\\game.txt");
	public static int n;
	
	public static void main(String[] args) throws IOException {
		try {
			
			NumLib.create(n);
			
			
			//Проверка наличия файла
			if (!gamefile.exists()){
				throw new FileNotFoundException(gamefile.getName());
				}
		      
			WorkInFile.read();
			
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		
	}

}
