package greedy;

public class L134_gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }

        int curRemainingGas = 0, totalRemainingGas = 0, startingPoint = -1;

        for (int i = 0; i < gas.length; i++) {
            curRemainingGas += gas[i] - cost[i];
            totalRemainingGas += gas[i] - cost[i];
            if (curRemainingGas < 0) {
                startingPoint = i;
                curRemainingGas = 0;
            }
        }

        return totalRemainingGas < 0 ? -1 : startingPoint + 1;
    }
}
