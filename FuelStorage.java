import java.io.*;
import java.util.*;

public class FuelStorage {
    private static final String FILE_PATH = "fuel_history.txt";

    public static void saveFuelHistory(List<FuelEntry> fuelHistory) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(fuelHistory);
        } catch (IOException e) {
            System.out.println("❌ Error saving fuel history.");
        }
    }

    public static List<FuelEntry> loadFuelHistory() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<FuelEntry>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
