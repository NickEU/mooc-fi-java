import java.util.Comparator;

public class Book {
    private final String name;
    private final int advisedAge;
    public final static Comparator<Book> byAgeThenName 
        = Comparator.comparing(Book::getAdvisedAge)
                .thenComparing(Book::getName);
    
    public Book(String name, int age) {
        this.name = name;
        this.advisedAge = age;
    }
    
    public int getAdvisedAge() {
        return this.advisedAge;
    }
    
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name + " (recommended for " + advisedAge + " year-olds or older)";
    }
}
