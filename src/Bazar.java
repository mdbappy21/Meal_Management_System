import java.util.InputMismatchException;
import java.util.Scanner;

public class Bazar implements BazarInfo {
    public double totalcost = 0;//total cost.
    int BazarCount;
    double cost;
    Scanner input = new Scanner(System.in);

    public void AddBazar() {

        for (int i = 0; i < 100; i++) {
            try {
                System.out.print("\nHow many Bazar is needed : ");
                BazarCount = input.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("--Bazar invalid--");
                input.nextLine();
            }
        }
        System.out.println("--Enter Bazar cost--");

        for (int i = 0; i < BazarCount; i++) {
            for (int j = 0; j < 100; j++) {
                try {
                    System.out.print("Enter Bazar cost of day " + (i + 1) + " : ");
                    cost = input.nextDouble();
                    break;
                }
                catch (InputMismatchException e) {
                    System.out.println("--Invalid Bazar cost--");
                    input.nextLine();
                }
            }
            totalcost += cost;
        }
    }
}
