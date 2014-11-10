package game;

import java.io.IOException;
import java.util.ArrayList;

public class NumLib {
	
	public static ArrayList<Integer> NumArray = new ArrayList<Integer>();
	
	public static void create() {
		for (int i = (int) Math.pow(10, body.N - 1); i < Math.pow(10, body.N); i++) {
			if (differ(i)) {
				NumArray.add(i);
			}
		}
		NumArray.trimToSize();
	}
	
	public static boolean differ(int x) {
		boolean b = true;
		String s = String.valueOf(x);
		char[] c = new String(s).toCharArray();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (c[i] == c[j] && i != j) {
					b = false;
				}
			}
		}
		return b;
	}
	
	public static void clean() throws IOException, InterruptedException {		
		int[] t = WorkInFile.read(2);
		char[] c2 = new String(Numbers.Current).toCharArray();
		int a = 0;
		while (a < NumArray.size()) {
			int cows = 0;
			int bulls = 0;
			String s1 = String.valueOf(NumArray.get(a));
			char[] c1 = new String(s1).toCharArray();
			for (int i = 0; i < body.N; i++) {
				for (int j = 0; j < body.N; j++) {
					if (c1[i] == c2[j]) {
						if (i == j) {
							bulls++;
						} else {
							cows++;
						}
					}
				}
			}
			if (cows != t[0] || bulls != t[1]) {
				NumArray.remove(a);
				NumArray.trimToSize();
			} else {
				a++;
			}
		}
		
	}

}
