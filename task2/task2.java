package task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class task2 {
    static float x = 0, y = 0, radius = 0;

    public static void main(String[] args) throws IOException {
        getCircle(args[0]);
        float[][] coordinates = getCoordinates(args[1]);
        for (int i = 0; i < coordinates.length; i++) {
            calcPosition(coordinates[i][0], coordinates[i][1]);
        }
    }

    private static void getCircle(String pathName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(pathName))) {
            while (scanner.hasNext()) {
                x = scanner.nextFloat();
                y = scanner.nextFloat();
                radius = scanner.nextFloat();
            }
        }
    }

    private static float[][] getCoordinates(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             Scanner scanner = new Scanner(new File(fileName))) {
            byte n = 0;
            while (reader.readLine() != null) {
                n++;
            }

            if (n < 1 || n > 100)
                throw new IllegalArgumentException("1<=n<=100");

            float[][] coordinates = new float[n][2];
            for (int i = 0; i < n; i++) {
                coordinates[i][0] = scanner.nextFloat();
                coordinates[i][1] = scanner.nextFloat();
            }

            return coordinates;
        }
    }

    private static void calcPosition(float a, float b) {
        float hypotenuse = (float) Math.sqrt(Math.pow(a - x, 2) + Math.pow(b - y, 2));
        if (hypotenuse > radius)
            System.out.print(2 + "\n");
        else if (hypotenuse < radius)
            System.out.print(1 + "\n");
        else
            System.out.print(0 + "\n");
    }
}
