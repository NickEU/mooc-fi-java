import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    private final List<Person> list;
    
    public Employees() {
        this.list = new ArrayList<>();
    }
    
    private List<Person> getEmployeeList() {
        return this.list;
    }
    
    public void add(Person personToAdd) {
        this.getEmployeeList().add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        peopleToAdd.forEach(this::add);
    }
    
    public void print() {
        this.print(null);
    }
    
    public void print(Education education) {
        Iterator<Person> people = this.getEmployeeList().iterator();
        
        while (people.hasNext()) {
            Person p = people.next();
            boolean toPrint = education == null
                    || p.getEducation().equals(education);
            
            if (toPrint) {
                System.out.println(p);                
            }
        }
    }       
    
    public void fire(Education education) {
        Iterator<Person> people = this.getEmployeeList().iterator();
        
        while (people.hasNext()) {
            if (people.next().getEducation() == education) {
                people.remove();
            }
        }
    }
        
}
