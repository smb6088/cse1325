import java.util.Scanner;

public class Main{
	public static void main(String[] args) {

		Scanner time = new Scanner(System.in);
		System.out.printf("Hours? ");
		int hours = time.nextInt();
		System.out.printf("Minutes? ");
		int min = time.nextInt();
		System.out.printf("Second? ");
		int sec = time.nextInt();

		Clock t1 = new Clock(hours, min, sec);

		System.out.println("The Time is " + t1);

	}
}
