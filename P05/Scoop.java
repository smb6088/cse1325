public class Scoop {
	public Scoop(IceCreamFlavor flavor){
		this.flavor = flavor;
	}

	@Override
	public addMixIn(MixIn mixins)
	{
		return mixins.add();
	}

	public String toString(){
		if(mixins.size() == 0)
		{

		return flavor;

		}
		else
		{
			String returnStr = "";
        	for (int i = 0; i < mixins.size() ; i++) {
            if(i == 0){
            	returnStr = mixins.get(i);
            }
            else {
                returnStr = returnStr + ", " + mixins.get(i);
            }
        }
        return flavor + " with  " + returnStr;
			
		}
	}

	private IceCreamFlavor flavor;
	private ArrayList<MixIn> mixins;
}