package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ThawAllen {
    public static void main(String[] args) throws Exception{
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(new File("X.file"))
        );
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
