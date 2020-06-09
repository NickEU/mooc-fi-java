import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private final List<Card> cards;
    private int sumOfValues;

    public Hand() {
        this.cards = new ArrayList<>();
        this.sumOfValues = 0;
    }

    private List<Card> getCardsInHand() {
        return this.cards;
    }

    private int getSumOfValues() {
        return this.sumOfValues;
    }

    public void add(Card card) {
        this.getCardsInHand().add(card);
        this.sumOfValues += card.getValue();
    }

    public void sort() {
        Collections.sort(this.getCardsInHand());
    }

    public void sortBySuit() {
        Collections.sort(this.getCardsInHand(), new BySuitInValueOrder());
    }

    public void print() {
        this.getCardsInHand().forEach(System.out::println);
    }

    @Override
    public int compareTo(Hand o) {
        return this.getSumOfValues() - o.getSumOfValues();
    }
}
