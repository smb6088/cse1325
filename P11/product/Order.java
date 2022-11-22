package product;

import java.util.ArrayList;

import person.Customer;
import person.Person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Order{
    private Customer customer;
	private ArrayList<Serving> servings;

	public Order(){
        this.customer = customer;
		this.servings = new ArrayList<>();
	}

	public Order(BufferedReader br) throws IOException {
        this.customer = new Customer(br);
		this.servings = new ArrayList<>();
		int numserve = Integer.parseInt(br.readLine());
        while(numserve-- > 0) servings.add(new Serving(br));
    }

    public void save(BufferedWriter bw) throws IOException {

        customer.save(bw);
    	bw.write("" + servings.size() + '\n');
        for(Serving mi : servings) mi.save(bw);
    	//servings.save(bw);
    }

    public void addServing(Serving serving) {
        servings.add(serving);
    }
    @Override
    public int price()
    {
        int result =0;
        for(Serving s: servings)
        {
            result = result + s.price();
        }
        return result;
    }
    @Override
    public String toString()
    {
    	StringBuilder result = new StringBuilder();
        result.append("" + customer.toString());
        int num = 1;
    	for(Serving m : servings)
    	{
            result.append("Order " + num + price()+ " :");
    		result.append("" + m.toString() + "\n");
            num++;
    	}

    	return result.toString();
    	
    }

}