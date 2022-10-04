import java.util.Scanner;
import java.util.ArrayList;

public class TestScoop {
	public static void main(String[] args) {
		ArrayList<IceCreamFlavor> flavors = new ArrayList<>();
		ArrayList<MixInFlavor> mixins = new ArrayList<>();
		ArrayList<Scoop> scoops = new ArrayList<>();
		MixInAmount mount;
		int options;
		String name = new String();
		String description = new String();
		int cost;
		int i = 0;
		int choice;
		int price;
		System.out.println("Create new mixin(0), ice cream flavor(1), or quit(-1) ?");
		Scanner scan = new Scanner(System.in);
		options = scan.nextInt();
		while(options != -1)
		{
			if(options == 0)
			{
				scan.nextLine();
				System.out.println("Creating new MixIn Flavor!!\n");
				System.out.println("Name? ");
				name = scan.nextLine();
				System.out.println("Description? ");
				description = scan.nextLine();
				System.out.println("Price? ");
				price = scan.nextInt();
				System.out.println("Cost? ");
				cost = scan.nextInt();

				mixins.add(new MixInFlavor(name, description, cost, price));
				//mixins.addMixIn();
			}
			else if(options == 1)
			{
				scan.nextLine();
				System.out.println("Creating new Ice-Cream Flavor!!\n");
				System.out.println("Name? ");
				name = scan.nextLine();
				System.out.println("Description? ");
				description = scan.nextLine();
				System.out.println("Price? ");
				price = scan.nextInt();
				System.out.println("Cost? ");
				cost = scan.nextInt();

				flavors.add(new IceCreamFlavor(name, description, cost, price));

			}
			else if(options == 2)
			{
				scan.nextLine();
				for(IceCreamFlavor fav : flavors){
					System.out.println( i +")" + flavors.toString());
					i++;
				}
				i = 0;
				System.out.println("Flavor? ");
				choice = scan.nextInt();
				while(choice == -1)
				{
					for(MixInFlavor fav : mixins){
						System.out.println( i +")" + mixins.toString());
						i++;
					}
					i= 0;
					System.out.println("MixIn? ");
					choice = scan.nextInt();

					for(MixInAmount fav : MixInAmount){
						System.out.println( i +")" + MixInAmount.values());
						i++;
					}
					i= 0;
					System.out.println("Amount? ");
					choice = scan.nextInt();

					for(MixInFlavor fav : mixins){
						System.out.println( i +")" + mixins.toString());
						i++;
					}
					i= 0;
					System.out.println("another mixin or no other mixin(-1) ?");
					choice = scan.nextInt();
				}
					System.out.println("List of Ice Cream Scoops:");

			}
			else{
				System.out.println("Invalid Option please select from the given choices");
			}

			System.out.println("Create new mixin(0), ice cream flavor(1), Scoop(2), or quit(-1) ?");
			options = scan.nextInt();
		}
		
	}
}