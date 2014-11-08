package game;

import java.io.*;
import java.util.Random;

public class Numbers {
	
	public static Integer Current;

	public static void NextNumber() throws IOException {
		
		Random rand = new Random();  
		Current = NumLib.NumArray.get(rand.nextInt(NumLib.NumArray.size()));
		WorkInFile.write("\r\n" + String.valueOf(Current));
		
	}
	
	public static void Check() throws IOException {
		
		int cow = 0;
		int bul = 0;
		
		int[] EN = new int[body.n];
		EN = WorkInFile.read(body.n);
		for (int i = 0; i < body.n; i++) {
			for (int j = 0; j < body.n; j++) {
				if (EN[i] == body.secret[j]) {
					if (i == j) {
						bul++;
					} else {
						cow++;
					}
				}
			}
		}
		WorkInFile.write(String.valueOf(cow) + String.valueOf(bul));
		if (bul == 5) {
			body.win = true;
		}

	}

}
