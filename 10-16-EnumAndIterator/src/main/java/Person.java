public class Person {
    private final String name;
    private Education education;
    
    public Person(String name, Education edu) {
        this.education = edu;
        this.name = name;
    }
    
    public Education getEducation() {
        return this.education;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.education;
    }
    
    
    
    
}
