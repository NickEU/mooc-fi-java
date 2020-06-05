import java.util.Objects;

public class Item {
    private final String product;
    private int quantity;
    private final int unitPrice;
    
    public Item(String product, int qty, int unitPrice) {
        this.product = product;
        this.quantity = qty;
        this.unitPrice = unitPrice;
    }
    
    public void increaseQuantity() {
        this.quantity++;
    }
    
    public int price() {
        return this.quantity * this.unitPrice;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.product);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.unitPrice != other.unitPrice) {
            return false;
        }
        
        return Objects.equals(this.product, other.product);
    }
    
    

    @Override
    public String toString() {
        return product + ": " + quantity;
    }
    
    
}
