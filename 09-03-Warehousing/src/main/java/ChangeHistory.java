import java.util.ArrayList;

public class ChangeHistory {
    private final ArrayList<Double> ledger;
    
    public ChangeHistory() {
        this.ledger = new ArrayList<>();
    }
    
    public void add(double status) {
        this.ledger.add(status);
    }
    
    public void clear() {
        this.ledger.clear();
    }
    
    public double maxValue() {
        double maxVal = 0.0;
        for (Double val : this.ledger) {
            if (val > maxVal) {
                maxVal = val;                
            }
        }
        return maxVal;
    }
    
    public double minValue() {
        double minVal = Double.MAX_VALUE;
        if (this.ledger.isEmpty()) {
            minVal = 0.0;
        } else {
            for (Double val : this.ledger) {
                if (val < minVal) {
                    minVal = val;                
                }
            }
        }
        return minVal;
    }
    
    public double average() {
        double count = this.ledger.size();
        
        if (count == 0) {
            return 0.0;
        }
        
        double sum = this.ledger.stream()
                .reduce(0.0, (acc, val) -> acc + val);
        
        return sum / count;
    }
    
    
    @Override
    public String toString() {
        return this.ledger.toString();
    }
    
}
