public class ElectricVehicle extends Vehicle {
	public ElectricVehicle(int year, String make, String model, BodyStyle bodyStyle, double whPerMile, double kwhInBattery)
	{
		this.year = year;
		this.make = make;
		this.model = model;
		this.bodyStyle = bodyStyle;
		this.whPerMile = whPerMile;
		this.kwhInBattery = kwhInBattery;
	}

	@override
	public double range(){
		return kwhInBattery / (whPerMile/1000);
	}
	public double fuelConsumed(double miles)
	{
		return miles*(whPerMile/1000);
	}
	public double dollarsToTravel(double miles)
	{
		return fuelConsumed(mile) * (centsPerkKwhOfElectricity/100);
	}

	private double whPerMile;
	private double kwhInBattery;
	public static double centsPerkKwhOfElectricity;
}