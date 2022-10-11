package emporium;

import product.*;
import java.util.ArrayList;

public class Emporium 
{

	private ArrayList<MixInFlavor> mixinflavors ;
	private ArrayList<IceCreamFlavor> icecreamflavors;
	private ArrayList<Scoop> scoops;

	public void addMixInFlavor(MixInFlavor flavor)
	{
		mixinflavors.add(flavor);
	}

	public void addIceCreamFlavor(IceCreamFlavor flavor)
	{
		icecreamflavors.add(flavor);
	}

	public void addScoop(Scoop scoop)
	{
		scoops.add(scoop);
	}

	public Object[] iceCreamFlavors()
	{
		return icecreamflavors.toArray();
	}

	public Object[] mixInFlavors()
	{
		return mixinflavors.toArray();
	}

	public Object[] scoops()
	{
		return scoops.toArray();
	}

}