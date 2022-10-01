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
			return flavor + 
		}
	}

	private IceCreamFlavor flavor;
	private ArrayList<MixIn> mixins;
}