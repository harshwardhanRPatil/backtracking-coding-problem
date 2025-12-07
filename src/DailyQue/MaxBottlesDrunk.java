package DailyQue;


class MaxBottlesDrunkSolution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {

        int bottleDrunk = numBottles;
        int emptyBottles = numBottles;

        while (emptyBottles >= numExchange) {
            emptyBottles -= numExchange;
            numExchange++;
            bottleDrunk++;
            emptyBottles++;
        }
        return bottleDrunk;
    }
}
public class MaxBottlesDrunk {
    public static void main(String args[]){
        MaxBottlesDrunkSolution maxBottlesDrunkSolution=new MaxBottlesDrunkSolution();
    System.out.println(maxBottlesDrunkSolution.maxBottlesDrunk(13,6));
    }
}
