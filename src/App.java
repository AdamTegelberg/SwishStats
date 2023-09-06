import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int total = 0;

        try {   
            File file = new File("C:/Users/AdamTH/AdventOfCode22/SwishStats/src/betalningar.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                String name = line[0];
                Integer amount = Integer.parseInt(line[2]);

                if (!map.containsKey(name)) {
                    map.put(name, amount);
                } else {
                    map.put(name, map.get(name) + amount);
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " har betalat " + entry.getValue() + "kr");
                total += entry.getValue();
            }
            System.out.println("total:" + total);
            scanner.close();

        } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
    }
}
