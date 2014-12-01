package game;

import java.io.*;
import java.util.Arrays;

public class WorkInFile {
	
	private static long fileLenght = 0;

	public static void clean(File file) throws IOException {
		if(file.exists()) {
			FileWriter wfile = new FileWriter(file, false);
			wfile.write("");
			wfile.close();
		}
	}

	public static void write(char[] number, File file) throws IOException, InterruptedException {
		if(!file.exists()) file.createNewFile();
		FileWriter wfile = new FileWriter(file, true);
		wfile.append(new String(number)).append("\r\n");
		wfile.close();
		fileLenght = file.length();
	}

	
	public static char[] read(int digit, File file) throws IOException, InterruptedException {
		while (file.length() == fileLenght) {
			Thread.sleep(500);
		}
		FileReader rfile = new FileReader(file);
		char[] chars = new char[digit];
		int l = (int) file.length();
		char[] f = new char[l];
		rfile.read(f);
		int x = 0;
		while ((int) f[l - x - 1] > 57 || (int) f[l - x - 1] < 48) {
			x++;
		}
		for (int i = 1; i <= digit; i++) {
			chars[digit - i] = f[l - i - x];
		}
		rfile.close();
	    return chars;
	}

	public static void reset() {
		fileLenght = 0;
	}
}

