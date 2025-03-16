import java.util.*;

public class FuelManager {
    private List<FuelEntry> fuelHistory;
    private Scanner sc;

    public FuelManager() {
        this.fuelHistory = FuelStorage.loadFuelHistory();
        this.sc = new Scanner(System.in);
    }

    public void logFuelEntry() {
        System.out.print("Enter fuel quantity (liters): ");
        double liters = sc.nextDouble();
        System.out.print("Enter total cost (₹): ");
        double cost = sc.nextDouble();
        System.out.print("Enter distance traveled (km): ");
        double distance = sc.nextDouble();
        sc.nextLine(); // Consume newline

        fuelHistory.add(new FuelEntry(liters, cost, distance));
        FuelStorage.saveFuelHistory(fuelHistory);
        System.out.println("✅ Fuel Entry Logged Successfully!");
    }

    public void viewFuelHistory() {
        if (fuelHistory.isEmpty()) {
            System.out.println("📄 No fuel history found.");
            return;
        }

        System.out.println("\n📜 Fuel Consumption History:");
        for (int i = 0; i < fuelHistory.size(); i++) {
            System.out.println((i + 1) + ". " + fuelHistory.get(i));
        }
    }

    public void calculateMileage() {
        if (fuelHistory.isEmpty()) {
            System.out.println("📌 No fuel logs available to calculate mileage.");
            return;
        }

        double totalDistance = 0, totalLiters = 0;
        for (FuelEntry entry : fuelHistory) {
            totalDistance += entry.getDistance();
            totalLiters += entry.getLiters();
        }

        double avgMileage = (totalLiters == 0) ? 0 : totalDistance / totalLiters;
        System.out.println("📊 Your Average Mileage: " + String.format("%.2f", avgMileage) + " km/l");
    }

    public void estimateFuelCost() {
        System.out.print("Enter estimated distance to travel (km): ");
        double distance = sc.nextDouble();
        System.out.print("Enter current fuel price per liter (₹): ");
        double fuelPrice = sc.nextDouble();
        sc.nextLine(); // Consume newline

        if (fuelHistory.isEmpty()) {
            System.out.println("❌ No mileage data available.");
            return;
        }

        double totalDistance = 0, totalLiters = 0;
        for (FuelEntry entry : fuelHistory) {
            totalDistance += entry.getDistance();
            totalLiters += entry.getLiters();
        }

        double avgMileage = (totalLiters == 0) ? 0 : totalDistance / totalLiters;
        double estimatedCost = (avgMileage == 0) ? 0 : (distance / avgMileage) * fuelPrice;

        System.out.println("💰 Estimated Fuel Cost for " + distance + " km: ₹" + String.format("%.2f", estimatedCost));
    }

    public void deleteFuelEntry() {
        viewFuelHistory();
        System.out.print("Enter fuel log number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < fuelHistory.size()) {
            fuelHistory.remove(index);
            FuelStorage.saveFuelHistory(fuelHistory);
            System.out.println("✅ Fuel Entry Deleted Successfully!");
        } else {
            System.out.println("❌ Invalid entry number.");
        }
    }
}
