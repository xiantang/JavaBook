package c11;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set2 {
    public static Set fill(Set a, int size) {
        for (int i = 0; i < size; i++) {
            a.add(new Integer(i));
        }
        return a;
    }

    public static void test(Set a) {
        fill(a, 10);
        fill(a, 10);
        fill(a, 10);
        a.addAll(fill(new TreeSet(), 10));
        System.out.println(a);
    }

    public static void main(String[] args) {
        test(new HashSet());
        test(new TreeSet());
        test(new LinkedHashSet());
    }
}
