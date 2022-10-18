package product;

import java.io.*;

public class MixIn {
    public MixIn(MixInFlavor flavor, MixInAmount amount) {
        this.flavor = flavor;
        this.amount = amount;
    }

    public MixIn(BufferedReader in) throws IOException
    {
        this.flavor = new MixInFlavor(in);
         String amountname = in.readLine();
        this.amount = MixInAmount.valueOf(amountname);
    }
    @Override
    public String toString() {
//        return flavor.toString() + ((amount != MixInAmount.Normal)
        return flavor.toString() + (!amount.equals(MixInAmount.Normal)
                                 ? " (" + amount + ")"
                                 : "");
    }

    public void save(BufferedWriter out) throws IOException
    {
        flavor.save(out);
        out.write("" + amount.values() + '\n');

    }
    private MixInFlavor flavor;
    private MixInAmount amount;
}
