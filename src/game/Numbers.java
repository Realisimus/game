package game;

import java.io.*;
import java.util.Random;

public class Numbers {
	
	public static String Current;

	public static void NextNumber() throws IOException, InterruptedException {
		
		Random rand = new Random();
		int R = rand.nextInt(NumLib.NumArray.size());
		Current = String.valueOf(NumLib.NumArray.get(R));
		WorkInFile.write(Current);
		
	}
	
	public static void Check() throws IOException, InterruptedException {
		
		int cow = 0;
		int bul = 0;
		
		int[] LastNumber = new int[body.N];
		LastNumber = WorkInFile.read(body.N);
		for (int i = 0; i < body.N; i++) {
			for (int j = 0; j < body.N; j++) {
				if (LastNumber[i] == body.SecretNumber[j]) {
					if (i == j) {
						bul++;
					} else {
						cow++;
					}
				}
			}
		}
		WorkInFile.write(String.valueOf(cow) + String.valueOf(bul));
		if (bul == body.N ) {
			body.win = true;
		}
		NumLib.NumArray.remove(Current);
		NumLib.NumArray.trimToSize();

	}

}
