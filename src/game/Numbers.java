package game;

public class Numbers {

	public static char[] calc(char[] number1, char[] number2) {
		char[] bc = new char[2];
		for (int i = 0; i < number1.length; i++) {
			for (int j = 0; j < number2.length; j++) {
				if (number1[i] == number2[j]) {
					if (i == j) {
						bc[1]++;
					} else {
						bc[0]++;
					}
				}
			}
		}
		return bc;
	}

}
