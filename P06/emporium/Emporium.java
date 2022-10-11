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

}