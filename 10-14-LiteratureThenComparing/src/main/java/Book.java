public class Book {
    private final String name;
    private final int advisedAge;
    
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
