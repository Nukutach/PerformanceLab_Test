package task4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class task4 {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNext()) {
                array.add(scanner.nextInt());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int size = array.size();
        if (size < 2)
            throw new IllegalArgumentException("array's size < 2");

        Collections.sort(array);
        int avg = array.get(size / 2);
        int sum = 0;
        for (int a : array) {
            sum += Math.abs(a - avg);
        }
        System.out.println(sum);
    }
}
