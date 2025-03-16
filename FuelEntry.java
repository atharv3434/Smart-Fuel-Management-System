public class FuelEntry {
    private double liters;
    private double cost;
    private double distance;

    public FuelEntry(double liters, double cost, double distance) {
        this.liters = liters;
        this.cost = cost;
        this.distance = distance;
    }

    public double getLiters() { return liters; }
    public double getCost() { return cost; }
    public double getDistance() { return distance; }

    public double calculateMileage() {
        return (liters == 0) ? 0 : distance / liters;
    }

    @Override
    public String toString() {
        return "⛽ Liters: " + liters + " | 💰 Cost: ₹" + cost + " | 🚘 Distance: " + distance + " km | 📊 Mileage: " + String.format("%.2f", calculateMileage()) + " km/l";
    }
}
