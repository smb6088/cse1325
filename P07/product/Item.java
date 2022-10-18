package product;
import java.io.*;

public class Item {
    public Item(String name, String description, int cost, int price) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.price = price;
    }

    public Item(BufferedReader in) throws IOException
    {
        this.name = in.readLine();
        this.description = in.readLine();
        this.cost = Integer.parseInt(in.readLine());
        this.price = Integer.parseInt(in.readLine());
    }
    public String name() {return name;}
    public String description() {return description;}
    public int cost() {return cost;}
    public int price() {return price;}
    
    @Override
    public String toString() {
        return name;
    }

    public void save(BufferedWriter out) throws IOException
    {
        out.write(name + '\n');
        out.write(description + '\n');
        out.write(cost + '\n');
        out.write(price + '\n');
    }
    protected String name;
    protected String description;
    protected int cost;
    protected int price;
} 
