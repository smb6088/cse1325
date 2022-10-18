package emporium;

import product.Item;
import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Scoop;
import java.io.*;

import java.util.ArrayList;

public class Emporium {

    public Emporium(){
        mixInFlavors = new ArrayList<>();
        iceCreamFlavors = new ArrayList<>();
        scoops = new ArrayList<>();

    }
    public Emporium(BufferedReader in) throws IOException{
        mixInFlavors = new ArrayList<>();
        int nummixInFlavors = Integer.parseInt(in.readLine());
        while(nummixInFlavors -- > 0)
        {
            mixInFlavors.add(new MixInFlavor(in));
        }
       iceCreamFlavors = new ArrayList<>();
        int numiceCreamFlavors = Integer.parseInt(in.readLine());
        while(numiceCreamFlavors -- > 0)
        {
            iceCreamFlavors.add(new IceCreamFlavor(in));
        }
        scoops = new ArrayList<>();
        int numscoops = Integer.parseInt(in.readLine());
        while(numscoops -- > 0)
        {
            scoops.add(new Scoop(in));
        }
    }

    public void addMixInFlavor(MixInFlavor flavor) {
        mixInFlavors.add(flavor);
    }

    public void addIceCreamFlavor(IceCreamFlavor flavor) {
        iceCreamFlavors.add(flavor);
    }

    public void addScoop(Scoop scoop) {
        scoops.add(scoop);
    }
    public Object[] iceCreamFlavors() {
        return this.iceCreamFlavors.toArray();
    }

    public Object[] mixInFlavors() {
        return this.mixInFlavors.toArray();
    }

    public Object[] scoops() {
        return this.scoops.toArray();
    }

    public void save(BufferedWriter out) throws IOException{
        out.write("" + mixInFlavors.size()+ '\n');
        for(MixInFlavor n : mixInFlavors)
        {
            out.write(n.toString()+ '\n');
            n.save(out);
        }
        out.write("" + iceCreamFlavors.size()+ '\n');
        for(IceCreamFlavor n : iceCreamFlavors)
        {
            out.write(n.toString()+ '\n');
            n.save(out);
        }
        out.write("" + scoops.size()+ '\n');
        for(Scoop n : scoops)
        {
            out.write(n.toString()+ '\n');
            n.save(out);
        }


    }

    private ArrayList<MixInFlavor> mixInFlavors;
    private ArrayList<IceCreamFlavor> iceCreamFlavors;
    private ArrayList<Scoop> scoops;
}
