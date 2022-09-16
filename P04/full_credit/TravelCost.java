import java.util.Scanner;
import java.util.ArrayList;

public class TravelCost {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("What is the price per Gallon of gas (dollars)?");
		GasVehicle.dollarsPerGallonOfGas = scan.nextDouble();
		System.out.print("What is the price per KWh of electricity (cents)?");
		ElectricVehicle.centsPerkKwhOfElectricity = scan.nextDouble();
		double miles;
		System.out.print("How many miles is your trip?");
		miles = scan.nextDouble();
		ArrayList<Vehicle> vehicles1 = new ArrayList<>();
		ArrayList<Vehicle> vehicles2 = new ArrayList<>();
		vehicles1.add(new ElectricVehicle(2022, "Telsa",    "Model S Plaid",   BodyStyle.Sedan,     297, 100  ));
        vehicles1.add(new ElectricVehicle(2022, "Telsa",    "Model 3 LR",      BodyStyle.Sedan,     242,  82  ));
        vehicles1.add(new ElectricVehicle(2022, "GM",       "Bolt",            BodyStyle.Hatchback, 286,  66  ));
        vehicles1.add(new ElectricVehicle(2022, "Nissan",   "LEAF",            BodyStyle.Hatchback, 269,  60  ));
        vehicles1.add(new ElectricVehicle(2022, "Ford",     "Mustang Mach-E",  BodyStyle.SUV,       347,  88  ));
        vehicles1.add(new ElectricVehicle(2022, "Ford",     "F-150 Lightning", BodyStyle.Truck,     511, 131  ));
        vehicles2.add(new GasVehicle(     2022, "Ford",     "F-150",           BodyStyle.Truck,      25,  23  ));
        vehicles2.add(new GasVehicle(     2022, "Toyota",   "Prius Hybrid",    BodyStyle.Hatchback,  55,  11.4));
        vehicles2.add(new GasVehicle(     2022, "Toyota",   "RAV4",            BodyStyle.Crossover,  31,  14.5));
        vehicles2.add(new GasVehicle(     2022, "Nissan",   "Rogue",           BodyStyle.Hatchback,  33,  14.5));
        vehicles2.add(new GasVehicle(     2022, "Chrysler", "Pacifica",        BodyStyle.Minivan,    24,  19  ));
        vehicles2.add(new GasVehicle(     2022, "Chrysler", "Pacifica Hybrid", BodyStyle.Minivan,    30,  16.5));

        for(Vehicle num: vehicles1)
        {
        	System.out.println(  num.dollarsToTravel(ElectricVehicle.centsPerkKwhOfElectricity) + "(Range " + Math.round(num.range()) + ")"  + num.toString());
        }
        for(Vehicle number: vehicles2)
        {
        	System.out.println(  number.dollarsToTravel(GasVehicle.dollarsPerGallonOfGas) + "(Range " + Math.round(number.range()) + ")"  + number.toString());
        }
	}
}