import java.util.Scanner;

public class FuelApp {
    private static FuelManager fuelManager = new FuelManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🚗 Welcome to Smart Fuel Management System 🚗");

        while (true) {
            System.out.println("\n1. Log Fuel Entry");
            System.out.println("2. View Fuel History");
            System.out.println("3. Calculate Mileage");
            System.out.println("4. Estimate Fuel Cost");
            System.out.println("5. Delete Fuel Entry");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    fuelManager.logFuelEntry();
                    break;
                case 2:
                    fuelManager.viewFuelHistory();
                    break;
                case 3:
                    fuelManager.calculateMileage();
                    break;
                case 4:
                    fuelManager.estimateFuelCost();
                    break;
                case 5:
                    fuelManager.deleteFuelEntry();
                    break;
                case 6:
                    System.out.println("Exiting... Drive safe! 🚘");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
