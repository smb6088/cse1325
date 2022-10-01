public class MixIn {
	public MixIn(MixInFlavor flavor, MixInAmount amount)
	{
		this.flavor = flavor;
		this.amount = amount;
	}

	@Override
	public String toString(){
		return flavor + " (" + amount +")";
	}

	private MixInFlavor flavor;
	private MixInAmount amount;
}