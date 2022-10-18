package product;

import java.io.*;

public class MixInFlavor extends Item {
    public MixInFlavor(String name, String description, int cost, int price) {
        super(name, description, cost, price);
    }

    public MixInFlavor(BufferedReader in) throws IOException{
        super(in);
    }

}
