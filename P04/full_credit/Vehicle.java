public class Vehicle
{
	public Vehicle(int year, String make, String model, BodyStyle bodyStyle)
	{
		this.year = year;
		this.make = make;
		this.model = model;
		this.bodyStyle = bodyStyle;
	}

	@Override
	public double range(){

	}
	public double fuelCosumed(){

	}
	public double dollarsToTravel(double miles)
	{

	}
	public String toString()
	{
		return "";
	}

	private int year;
	private String make;
	private String model;
	private BodyStyle bodyStyle;
}