import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Item> itemsInCart;
    
    public ShoppingCart() {
        this.itemsInCart = new ArrayList<>();
    }
    
    public void add(String product, int price) {
        Item item = new Item(product, 1, price);
        int foundId = this.itemsInCart.indexOf(item);
        if (foundId == -1) {
            this.itemsInCart.add(item);             
        } else {
            this.itemsInCart.get(foundId).increaseQuantity();                       
        }
    }
    
    public int price() {
        int price = 0;
        
        price = this.itemsInCart.stream()
                .map((item) -> item.price())
                .reduce(price, Integer::sum);
        
        return price;
    }
    
    public void print() {
        this.itemsInCart.forEach(System.out::println);
    }
    
}
