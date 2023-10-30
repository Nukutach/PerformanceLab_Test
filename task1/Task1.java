package task1;

public class Task1 {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n < 1)
            throw new IllegalArgumentException("n >= 1");
        int m = Integer.parseInt(args[1]);
        if (m < 1)
            throw new IllegalArgumentException("m >= 1");
        int current_element = 1;
        do {
            System.out.print(current_element);
            current_element = (current_element + m - 2) % n + 1;
        } while (current_element != 1);
    }
}
