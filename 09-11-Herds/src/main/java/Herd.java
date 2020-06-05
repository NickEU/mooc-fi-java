import java.util.LinkedList;
import java.util.List;

public class Herd implements Movable {
    private final List<Movable> creatures;
    
    public Herd() {
        this.creatures = new LinkedList<>();        
    }
    
    public void addToHerd(Movable movable) {
        this.creatures.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        this.creatures.forEach(member -> member.move(dx, dy));
    }

    @Override
    public String toString() {
        return this.creatures.stream()
                .map(org -> org.toString() + "\n")
                .reduce("", String::concat);
    }
    
    
    
}
