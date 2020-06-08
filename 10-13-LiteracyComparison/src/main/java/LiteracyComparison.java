import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        ArrayList<LiteracyRates> stats = processFile("literacy.csv");  
        printLiteracyAscending(stats);
    }
    
    private static ArrayList<LiteracyRates> processFile(String filename) {
        try {
            return Files.lines(Paths.get(filename))
                 .map(line -> line.split(","))
                 .filter(arr -> arr.length == 6)
                 .map(arr -> new LiteracyRates(arr[2].split(" ")[1],
                         arr[3], Integer.parseInt(arr[4]), 
                         Double.parseDouble(arr[5])))
                 .collect(Collectors.toCollection(ArrayList::new));
        } catch(IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
        
        return new ArrayList<>();
        
    }

    private static void printLiteracyAscending(ArrayList<LiteracyRates> stats) {
        stats.stream().sorted().forEach(System.out::println);
    }
}
