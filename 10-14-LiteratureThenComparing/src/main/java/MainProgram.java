import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            
            String bookName = scanner.nextLine();
            
            if (bookName.isEmpty()) {
                break;
            }
            
            System.out.print("Input the age recommendation: ");
            int ageAdvised = Integer.parseInt(scanner.nextLine());
            
            Book newBook = new Book(bookName, ageAdvised);
            
            books.add(newBook);
            System.out.println("");
        }
        
        System.out.println(books.size() + " books in total.");
        System.out.println("");
        System.out.println("Books:");

        books.stream().sorted(Book.byAgeThenName).forEach(System.out::println);   
    }
}