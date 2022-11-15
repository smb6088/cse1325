package product;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Order{
	private ArrayList<Serving> servings;

	public Order(){
		this.servings = new ArrayList<>();
	}

	public Order(BufferedReader br) throws IOException {
		this.servings = new ArrayList<>();
		int numserve = Integer.parseInt(br.readLine());
        while(numserve-- > 0) servings.add(new Serving(br));
    }

    public void save(BufferedWriter bw) throws IOException {

    	bw.write("" + servings.size() + '\n');
        for(Serving mi : servings) mi.save(bw);
    	//servings.save(bw);
    }

    public void addServing(Serving serving) {
        servings.add(serving);
    }

    @Override
    public String toString()
    {
    	StringBuilder result = new StringBuilder();
    	for(Serving m : servings)
    	{
    		result.append("" + m.toString() + "\n");
    	}

    	return result.toString();
    	
    }

}