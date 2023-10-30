package task3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class task3 {

    public static void main(String[] args){
        HashMap<String, String> info = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(args[1]))) {
            while (scanner.hasNextLine()) {
                String str = scanner.next();
                if (str.equals("\"id\":")) {
                    String id = scanner.next();
                    scanner.next();
                    String value = scanner.next();
                    info.put(id, value);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File tests = new File(args[0]);
        String path = tests.getParent();

        try (Scanner scanner = new Scanner(tests);
             PrintWriter writer = new PrintWriter(new File(path, "report.json"))) {
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if (scanner.hasNextLine()) {
                    writer.println(str);
                } else writer.print(str);
                if (str.contains("\"id\":")) {
                    String[] lines = str.split(": ");
                    String id = lines[1];
                    if (info.containsKey(id)) {
                        writer.println(scanner.nextLine());
                        writer.println(scanner.nextLine().replace("\"\"", info.get(id)));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
