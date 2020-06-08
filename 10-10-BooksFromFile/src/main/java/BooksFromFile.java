import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }
    
    public static List<Book> readBooks(String fileName) {
        try {
            return Files.lines(Paths.get(fileName))
                    .map(row -> row.split(","))
                    .filter(arr -> arr.length == 4)
                    .map(arr -> new Book(arr[0],
                            Integer.parseInt(arr[1]),
                            Integer.parseInt(arr[2]),
                            arr[3]))
                    .collect(Collectors.toList());
        } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return new ArrayList<>();
    }

}
