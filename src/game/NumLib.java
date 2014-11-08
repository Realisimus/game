package game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NumLib {
	
	public static ArrayList<Integer> NumArray = new ArrayList<Integer>();
	
	public static void create() {
		
		for (int i = (int) Math.pow(10, body.n - 1); i < Math.pow(10, body.n); i++) {
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

	public static void WriteFile(String url) throws IOException {

		File massfile = new File(url);
		massfile.createNewFile();
		FileWriter mass = new FileWriter(massfile, true);
		for (int i = 0; i < NumArray.size(); i++) {
			mass.write(String.valueOf(NumArray.get(i)));
		}
		mass.flush();
		mass.close();
		
	}
	
	public static void clean() throws IOException {
		
		int[] t = WorkInFile.read(2);
		//int cow = t[0];
		//int bul = t[1];
				
		String s2 = String.valueOf(Numbers.Current);
		char[] c2 = new String(s2).toCharArray();
		
		int a = 0;
		while (a < NumArray.size()) {
			int cow = 0;
			int bul = 0;
			String s1 = String.valueOf(NumArray.get(a));
			char[] c1 = new String(s1).toCharArray();
			for (int i = 0; i < body.n; i++) {
				for (int j = 0; j < body.n; j++) {
					if (c1[i] == c2[j]) {
						if (i == j) {
							bul++;
						} else {
							cow++;
						}
					}
				}
			}
			if (cow + bul < t[0] + t[1] || bul < t[1]) {
				NumArray.remove(a);
				NumArray.trimToSize();
			} else {
				a++;
			}
		}
		
	}

}
