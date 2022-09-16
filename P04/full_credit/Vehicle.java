public abstract class Vehicle
{
	public Vehicle(int year, String make, String model, BodyStyle bodyStyle)
	{
		this.year = year;
		this.make = make;
		this.model = model;
		this.bodyStyle = bodyStyle;
	}

	public abstract double range();
	public abstract double fuelConsumed(double miles);
	public abstract double dollarsToTravel(double miles);
	public String toString()
	{
		return  year + " " +  make + " " + model + " " + bodyStyle;
	}

	private int year;
	private String make;
	private String model;
	private BodyStyle bodyStyle;
}