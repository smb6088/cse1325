package emporium;

import product.*;
import java.util.ArrayList;

public class Emporium 
{

	private ArrayList<MixInFlavor> mixinflavors = new ArrayList<>();
	private ArrayList<IceCreamFlavor> icecreamflavors = new ArrayList<>();
	private ArrayList<Scoop> scoops = new ArrayList<>();

	public void addMixInFlavor(MixInFlavor flavor)
	{
		this.mixinflavors.add(flavor);
	}

	public void addIceCreamFlavor(IceCreamFlavor flavor)
	{
		this.icecreamflavors.add(flavor);
	}

	public void addScoop(Scoop scoop)
	{
		this.scoops.add(scoop);
	}

	public Object[] iceCreamFlavors()
	{
		return icecreamflavors.toArray();
	}

	public Object[] mixInFlavors()
	{
		return mixinflavors.toArray();
	}

	public Object[] scooop()
	{
		return scoops.toArray();
	}

}