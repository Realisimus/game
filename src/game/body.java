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
			
		//�������� ������ ���� �����
		NumLib.create();
		//NumLib.WriteFile("d:\\mass.txt");
						
		//�������� ������� ����� � ������ ����������� �����
		if (!gamefile.exists()){
			throw new FileNotFoundException(gamefile.getName());
			}
		secret = WorkInFile.read(n);
		
		while (!win) {
			
			Numbers.NextNumber(); //��������� �����
			Numbers.Check(); //������� ����� � �����
			NumLib.clean(); //������ ������� ��������� �����
			
			System.out.println(NumLib.NumArray.size());
			
		}

		
	}

}
