package game;

import java.io.*;
import java.util.Random;

public class Numbers {
	
	public static Integer Current;

	public static void NextNumber() throws IOException {
		
		Random rand = new Random();
		int R = rand.nextInt(NumLib.NumArray.size());
		Current = NumLib.NumArray.get(R);
		WorkInFile.write("\r\n" + R + " " + String.valueOf(Current));
		
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
		if (bul == body.n) {
			body.win = true;
		}
		NumLib.NumArray.remove(Current);
		NumLib.NumArray.trimToSize();

	}

}
