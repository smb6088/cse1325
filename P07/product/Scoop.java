package product;

import java.util.ArrayList;
import java.io.*;

public class Scoop {
    public Scoop(IceCreamFlavor flavor) {
        this.flavor = flavor;
        this.mixins = new ArrayList<>();
    }
    public Scoop(BufferedReader in) throws IOException {
        this.flavor = new IceCreamFlavor(in);
        mixins = new ArrayList<>();
        int nummixins = Integer.parseInt(in.readLine());
       while(nummixins -- > 0)
       {
        mixins.add(new MixIn(in));
       } 
    }
    public void addMixIn(MixIn mixin) {
        mixins.add(mixin);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(flavor.toString());
        if(mixins.size() > 0) {
            String separator = " with ";
            for(MixIn m : mixins) {
                result.append(separator + m.toString());
                separator = ", ";
            }
        }
        return result.toString();
    }

    public void save(BufferedWriter out) throws IOException
    {
        out.write("" + flavor + '\n');
        out.write("" + mixins.size()+ '\n');
        for(MixIn n: mixins){
            out.write(n.toString() + '\n');
            n.save(out);
        }
    }
    private IceCreamFlavor flavor;
    private ArrayList<MixIn> mixins;
}
