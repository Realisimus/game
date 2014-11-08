package game;

import java.io.*;

public class WorkInFile {

	public static void write(String number) throws IOException {
		
		FileWriter wfile = new FileWriter(body.gamefile, true);
		wfile.append("\r\n" + number);
		//wfile.flush();
		wfile.close();
	 
	}
	
	public static int[] read(int o) throws IOException {
		
		FileReader rfile = new FileReader(body.gamefile);
		
		int[] CB = new int[o]; //массив из двух чисел для возврата
		int l = (int) body.gamefile.length(); //длина файла
		
		char[] c = new char[l]; //массив чаров из файла
		rfile.read(c);
		
		for (int i = 1; i <= o; i++) {
			CB[o - i] = (int)c[l-i] - 48;
		}
		
		rfile.close();
		
	    return CB;
	}
	
}
