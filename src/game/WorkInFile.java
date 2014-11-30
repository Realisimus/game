package game;

import java.io.*;

public class WorkInFile {
	
	public static long FileLenght = 0;

	public static void write(String number, String url) throws IOException, InterruptedException {
		File file = new File(url);
		FileWriter wfile = new FileWriter(file, true);
		if (file.length() == 0) {
			wfile.append(number + "\r\n");
		} else {
			wfile.append(number + "\r\n");
		}
		wfile.close();
		System.out.println();
		System.out.println(number);
		FileLenght = file.length();
	}
	
	public static char[] read(int o, String url) throws IOException, InterruptedException {
		File file = new File(url);
		while (file.length() == FileLenght) {
			Thread.sleep(500);
		}
		FileReader rfile = new FileReader(file);
		char[] CB = new char[o];
		int l = (int) file.length();
		char[] c = new char[l];
		rfile.read(c);
		int x = 0;
		while ((int) c[l - x - 1] > 57 || (int) c[l - x - 1] < 48) {
			x++;
		}
		for (int i = 1; i <= o; i++) {
			CB[o - i] = c[l - i - x];
		}
		rfile.close();

		System.out.println();
		for (int k = 0; k < o; k++) {
			System.out.print(CB[k]);
		}

	    return CB;
	}
	
}
