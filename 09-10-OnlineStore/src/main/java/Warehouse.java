import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private final Map<String, Integer> priceTable;
    private final Map<String, Integer> stockTable;
    
    public Warehouse() {
        this.priceTable = new HashMap<>();
        this.stockTable = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.priceTable.put(product, price);
        if (this.stockTable.putIfAbsent(product, stock) != null) {
            this.stockTable.put(product, this.stockTable.get(product) + stock);
        }        
    }
    
    public int price(String product) {
        return this.priceTable.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return this.stockTable.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        Integer currentStock = this.stockTable.get(product);
        if (currentStock == null) {
            return false;
        }
        
        if (currentStock > 1) {
             this.stockTable.put(product, currentStock - 1);
             return true;
        }
        
        if (currentStock == 1) {
            this.stockTable.remove(product);
            this.priceTable.remove(product);
        }
        
        return false;
    }
    
    public Set<String> products() {
        return this.priceTable.keySet();
    }
    
    
    
}
