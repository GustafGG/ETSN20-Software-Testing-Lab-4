import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringSearcher {

    private static void searchString(String pattern, String filePath) {
        File file = new File(filePath);
        Scanner s;

        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Invalid input; File not found");
            return;
        }

        System.out.println("Printing all lines in [" + filePath + "] containing pattern [" + pattern + "]...\n");

        while(s.hasNextLine()) {
            String line = s.nextLine();
            if (line.contains(pattern)) System.out.println(line);
        }

        s.close();
    }

    public static void main(String args[]) {

        if (args.length == 3) {

            String command = args[0];
            String pattern = args[1];
            String file = args[2];

            switch (command) {
                case "search":
                    searchString(pattern, file);
                    break;
                default:
                    System.out.println("Invalid command; " + command);
            }
        } else {
            System.out.println("Invalid input format; please provide 3 arguments of format <command> <pattern> <file>");
        }

    }
}