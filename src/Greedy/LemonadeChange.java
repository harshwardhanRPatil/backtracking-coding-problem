package Greedy;


import java.util.Arrays;

class LemonadeChangeSolution {
    public boolean lemonadeChange(int[] bills) {
        Arrays.sort(bills);
        int five=0;
        int ten=0;
        int twenty=0;
        for(int i=0;i<bills.length;i++){

            if (bills[i] == 5) {
                five++;
            }
            else if(bills[i]==10){
               if (five == 0) return false;
               five--;
               ten++;
           }
           else{
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }
                else if (five >= 3) {
                    five -= 3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
public class LemonadeChange {
    public static void main(String args[]){
        LemonadeChangeSolution lemonadeChangeSolution= new LemonadeChangeSolution();
    System.out.println(lemonadeChangeSolution.lemonadeChange(new int[]{5,5,20,5,5,10,5,10,5,20}));
    }
}
