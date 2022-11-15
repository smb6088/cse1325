package product;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Serving {

	public Serving(Container container)
	{
		this.container = container;
		this.scoops = new ArrayList<>();
		this.toppings = new ArrayList<>();
	}

	public Serving(BufferedReader br) throws IOException {

		this.container = new Container(br);
		this.scoops = new ArrayList<>();
		int numscoop = Integer.parseInt(br.readLine());
        while(numscoop-- > 0) scoops.add(new Scoop(br));
        this.toppings = new ArrayList<>();
        int numMixIns = Integer.parseInt(br.readLine());
        while(numMixIns-- > 0) toppings.add(new MixIn(br));
    }

    public void save(BufferedWriter bw) throws IOException {

    	container.save(bw);
    	bw.write("" + scoops.size() + '\n');
        for(Scoop mi : scoops) mi.save(bw);
        bw.write("" + toppings.size() + '\n');
        for(MixIn mi : toppings) mi.save(bw);
    }

    public void addScoop(Scoop scoop) {
        scoops.add(scoop);
    }

    public void addTopping(MixIn topping) {
        toppings.add(topping);
    }

	private Container container;
	private ArrayList<Scoop> scoops;
	private ArrayList<MixIn> toppings;
}