class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
         int n = position.length;
        if (n == 0) return 0;

        // Pair positions and times to reach target
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        // Sort cars by position in descending order
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double lastTime = 0;

        // Iterate through the sorted cars
        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            if (time > lastTime) {
                fleets++; // New fleet is formed
                lastTime = time; // Update the last fleet's time
            }
        }

        return fleets;
    }
}