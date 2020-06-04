
public class Main {

    public static void main(String[] args) {
        PaymentTerminal unicafeExactum = new PaymentTerminal();
        System.out.println(unicafeExactum);
        double change = unicafeExactum.eatHeartily(4.3);
        System.out.println(unicafeExactum);
        System.out.println(change);
        PaymentTerminal cafe2 = new PaymentTerminal();
        System.out.println(unicafeExactum);
    }
}

