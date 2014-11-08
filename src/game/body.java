package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class body {
	
	//public static String url = "D:\\game.txt";
	public static File gamefile = new File("D:\\game.txt");
	public static int n = 5;
	public static int[] secret;
	public static boolean win = false;
	
	public static void main(final String[] args) throws IOException {
			
		//Создание списка всех чисел
		NumLib.create();
		//NumLib.WriteFile("d:\\mass.txt");
						
		//Проверка наличия файла и чтение загаданного числа
		if (!gamefile.exists()){
			throw new FileNotFoundException(gamefile.getName());
			}
		secret = WorkInFile.read(n);
		
		while (!win) {
			
			Numbers.NextNumber(); //Следующее число
			Numbers.Check(); //Подсчет быков и коров
			NumLib.clean(); //Чистка массива возможных чисел
			
			System.out.println(NumLib.NumArray.size());
			
		}

		
	}

}
