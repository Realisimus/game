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
        int a = 0;
        while (a < numbers.size()) {
            char[] c = Numbers.calc(numbers.get(a), number);
            if (c[0] != bc[0] || c[1] != bc[1]) {
                numbers.remove(a);
                numbers.trimToSize();
            } else {
                a++;
            }
        }
    }

    public char[] random() {
        Random rand = new Random();
        int R = rand.nextInt(numbers.size());
        return String.valueOf(numbers.get(R)).toCharArray();
    }

}
