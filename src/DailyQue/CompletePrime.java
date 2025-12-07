package DailyQue;

// https://leetcode.com/problems/complete-prime-number/

class CompletePrimeSolution{
    public boolean completePrime(int num) {
        if(!isPrime(num)) return false;
        String s = String.valueOf(num);
        int prefix = 0;

        for (int i = 0; i < s.length(); i++) {
            prefix = prefix * 10 + (s.charAt(i) - '0');
            if(! isPrime(prefix)){
                return false;
            }
        }
        int power_valie=1;
        int surfix = 0;
        for (int i = s.length()-1; i >=0; i--) {
            surfix =  (s.charAt(i) - '0')* power_valie + surfix;
            power_valie*=10;
            if(! isPrime(surfix)){
                return false;
            }
        }
        return true;
    }

    public boolean isPrime(int n){
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
public class CompletePrime {
    public static void main(){
        CompletePrimeSolution completePrimeSolution= new CompletePrimeSolution();
    System.out.println(completePrimeSolution.completePrime(31));
    }
}
