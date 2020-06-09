import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
       if (o1.getSuit() == o2.getSuit()) {
           return o1.getValue() - o2.getValue();
       }
       
       return o1.getSuit().ordinal() - o2.getSuit().ordinal();
    }
        
}
