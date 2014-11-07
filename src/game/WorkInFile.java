package game;

import java.io.*;

public class WorkInFile {

	public static void write(long number) throws IOException {
		
		FileWriter wfile = new FileWriter(start.gamefile, true);
		wfile.append(String.valueOf(number));
		//wfile.flush();
		wfile.close();
	 
	}
	
	public static int[] read() throws IOException {
		
		FileReader rfile = new FileReader(start.gamefile);
		
		int[] CB = new int[2]; //������ �� ���� ����� ��� ��������
		int l = (int) start.gamefile.length(); //����� �����
		
		char[] c = new char[l]; //������ ����� �� �����
		rfile.read(c);
		
		CB[1] = (int)c[l-1] - 48;
		CB[0] = (int)c[l-2] - 48;
		
		rfile.close();
		
	    return CB;
	}
	
}
