package product;
import java.io.*;

public class IceCreamFlavor extends Item {
    public IceCreamFlavor(String name, String description, int cost, int price) {
        super(name, description, cost, price);
    }

     public IceCreamFlavor(BufferedReader in) throws IOException {
        super(in);
    }
}
