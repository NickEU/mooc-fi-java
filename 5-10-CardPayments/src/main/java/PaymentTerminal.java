import java.util.EnumMap;
import java.util.Map;

public class PaymentTerminal {
    
    private enum Meal {
        AFFORDABLE(2.5), HEARTY(4.3);

        private final double price;
        
        Meal(double price) {
            this.price = price;
        }

        private double getPrice() {
            return price;
        }
    }

    private double money;  // amount of cash
    private final Map<Meal, Integer> mealsSold;

    public PaymentTerminal() {
        this.money = 1000f;
        this.mealsSold = new EnumMap<>(Meal.class);

        for (Meal meal : Meal.values()) {
            mealsSold.put(meal, 0);
        }
    }

    public void addMoneyToCard(PaymentCard card, double sum) {
        if (sum < 0) { return; }

        card.addMoney(sum);
        this.money += sum;
    }

    public double eatAffordably(double payment) {
        return this.tryEat(payment, Meal.AFFORDABLE);
    }

    public boolean eatAffordably(PaymentCard card) {
        return this.tryEat(card, Meal.AFFORDABLE);
    }

    public double eatHeartily(double payment) {
        return this.tryEat(payment, Meal.HEARTY);
    }

    public boolean eatHeartily(PaymentCard card) {
        return this.tryEat(card, Meal.HEARTY);
    }

    private double tryEat(double payment, Meal meal) {
        double price = meal.getPrice();
        if (payment < price) {
            return payment;
        }
        mealsSold.put(meal, mealsSold.get(meal) + 1);
        this.money += price;
        return payment - price;
    }

    private boolean tryEat(PaymentCard card, Meal meal) {
        double price = meal.getPrice();
        boolean transactionWasSuccessful = card.takeMoney(price);
        if (transactionWasSuccessful) {
            mealsSold.put(meal, mealsSold.get(meal) + 1);
        }
        return transactionWasSuccessful;
    }


    @Override
    public String toString() {
        return "money: " + money + ", number of sold affordable meals: "
                + mealsSold.get(Meal.AFFORDABLE) + ", number of sold hearty meals: "
                + mealsSold.get(Meal.HEARTY);
    }
}
