 public class GasVehicle extends Vehicle {
	public GasVehicle(int year, String make, String model, BodyStyle bodyStyle, double milesPerGallon, double gallonsinTank)
	{
		super(year, make, model, bodyStyle);
		this.milesPerGallon = milesPerGallon;
		this.gallonsinTank = gallonsinTank;
	}

	@Override
	public double range() {
		return gallonsinTank * milesPerGallon;
	}
		
	@Override
	public double fuelConsumed(double miles) { 
		return (miles/milesPerGallon);
	}
	@Override
	public double dollarsToTravel(double miles)
	{
		return (fuelConsumed(miles) * dollarsPerGallonOfGas);
	}

	private double milesPerGallon;
	private double gallonsinTank;
	public static double dollarsPerGallonOfGas;
}