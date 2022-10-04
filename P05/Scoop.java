import java.util.ArrayList;

public class Scoop {
	public Scoop(IceCreamFlavor flavor){
		this.flavor = flavor;
		mixins = new ArrayList<>();
	}


	public void addMixIn(MixIn mixin)
	{
		mixins.add(mixin);
	}

	public String toString(){
		if(mixins.size() == 0)
		{
			return flavor + "";
		}
		else
		{
			String returnStr = "";
        	for (int i = 0; i < mixins.size() ; i++) {
            if(i == 0){
            	returnStr = mixins.get(i).toString();
            }
            else {
                returnStr = returnStr + ", " + mixins.get(i).toString();
            }
        }
        return flavor + " with  " + returnStr;
			
		}
	}

	private IceCreamFlavor flavor;
	private ArrayList<MixIn> mixins;
}