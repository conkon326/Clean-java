public class Q4 {
    public static void main(String[] args) {
        int totalCargo = 600;
        int maxCapacity = 5000;

        int currentTruckLoad = 0;
        int truckCount = 0;
        int cargoWeight = totalCargo;
        
        while (cargoWeight > 0) {
            if (currentTruckLoad + cargoWeight <= maxCapacity) {
                currentTruckLoad += cargoWeight;
                cargoWeight--;
            } else {
                currentTruckLoad = 0;
                truckCount++;
            }
        }
        
        if (currentTruckLoad > 0) {
            truckCount++;
        }
        
        System.out.println(truckCount);
    }
}
