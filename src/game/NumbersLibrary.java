package game;

import java.util.*;

public class NumbersLibrary {

    private List<char[]> numbers = new ArrayList<char[]>();

    public void create(int n) {
        for (int i = (int) Math.pow(10, n - 1); i < Math.pow(10, n); i++) {
            if (differ(i)) numbers.add(String.valueOf(i).toCharArray());
        }
    }

    private Boolean differ(int i) {
        Set<char[]> set = new HashSet<char[]>(Arrays.asList(String.valueOf(i).toCharArray()));
        return set.size() == String.valueOf(i).length();
    }

    public void clean(char[] number, char[] bc) {
        int a = 0;
        while (a < numbers.size()) {
            char[] c = Tools.calc(numbers.get(a), number);
            if (c[0] != bc[0] || c[1] != bc[1]) {
                numbers.remove(a);
            } else {
                a++;
            }
        }

    }



}
