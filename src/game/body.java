package game;

import java.io.File;
import java.io.IOException;

public class body {
	
	public static File gamefile = new File("D:\\Bulls_Cows\\game.txt");
	public static int N = 5;
	public static int[] SecretNumber;
	public static boolean win = false;
	
	public static void main(final String[] args) throws IOException, InterruptedException {
			
		NumLib.create();
						
		//if (!gamefile.exists()){
		//	throw new FileNotFoundException(gamefile.getName());
		//	}
		//SecretNumber = WorkInFile.read(N);
		int iter = 0;
		
		while (!win) {
			Numbers.NextNumber(); //��������� �����
			
			int[] t = WorkInFile.read(2);
			if (t[1] == N ) {
				body.win = true;
			}

			//Numbers.Check(); //������� ����� � �����
			NumLib.clean(); //������ ������� ��������� �����
			iter++;
		}
		
		WorkInFile.write("\r\n\r\n� ������� �� " + iter + " ���");
		
	}

}
