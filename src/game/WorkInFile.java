package game;

import java.io.*;

public class WorkInFile {
	
	public static long FileLenght = 0;

	public static void write(String number) throws IOException, InterruptedException {
		FileWriter wfile = new FileWriter(body.gamefile, true);
		if (body.gamefile.length() == 0) {
			wfile.append(number);
		} else {
			wfile.append(number + "\r\n");
		}
		wfile.close();
		FileLenght = body.gamefile.length();
	}
	
	public static char[] read(int o) throws IOException, InterruptedException {
		while (body.gamefile.length() == FileLenght) {
			Thread.sleep(1000);
		}
		FileReader rfile = new FileReader(body.gamefile);
		char[] CB = new char[o];
		int l = (int) body.gamefile.length();
		char[] c = new char[l];
		rfile.read(c);
		for (int i = 1; i <= o; i++) {
			CB[o - i] = c[l-i-4];
		}
		rfile.close();
	    return CB;
	}
	
}
