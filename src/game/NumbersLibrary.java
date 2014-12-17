package game;

import java.util.*;

public class NumbersLibrary {

    private ArrayList<char[]> numbers = new ArrayList<char[]>();

    public void create(int n) {
        for (int i = (int) Math.pow(10, n - 1); i < Math.pow(10, n); i++) {
            if (differ(i)) {
                numbers.add(String.valueOf(i).toCharArray());
            }
        }
    }

    private Boolean differ(int i) {
        Set set = new HashSet();
        for (char c : String.valueOf(i).toCharArray()) set.add(c);
        return set.size() == String.valueOf(i).length();
    }

    public void clean(char[] number, char[] bc) {
        for (char[] num : numbers) {
            char[] c = calc(number, num);
            if (c[0] != bc[0] || c[1] != bc[1]) numbers.remove(num);
        }
        numbers.trimToSize();
    }

    public char[] random() {
        Random rand = new Random();
        int R = rand.nextInt(numbers.size());
        return String.valueOf(numbers.get(R)).toCharArray();
    }

    public char[] calc(char[] number1, char[] number2) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < number1.length; i++) {
            for (int j = 0; j < number2.length; j++) {
                if (number1[i] == number2[j]) {
                    if (i == j) bulls++;
                        else cows++;
                }
            }
        }
        String bc = Integer.toString(cows) + Integer.toString(bulls);
        return bc.toCharArray();
    }

}
