import java.util.Scanner;

public class Main{
	public static void main(String[] args) {

		Scanner time = new Scanner(System.in);
		System.out.println("Hours?");
		int hours = time.nextInt();
		System.out.println("Minutes?");
		int min = time.nextInt();
		System.out.println("Second?");
		int sec = time.nextInt();

		Clock t1 = new Clock(hours, min, sec);

		System.out.println(t1);

	}
}
