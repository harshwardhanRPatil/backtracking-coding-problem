package Binary_Search;


class NthDigitSolution {
    public int findNthDigit(int n) {
        if(n<10) return n;

        long i = 1;       // digit length
        long count = 9;   // how many numbers with i digits
        long start = 1;   // starting number with i digits

        // Find which group the digit belongs to
        while (n > i * count) {
            n -= i * count;
            i++;
            count *= 10;
            start *= 10;
        }

        // Find the actual number containing the digit
//        1+16-1/2= 1+7
//        7-1
        long number = start + (n - 1) / i;

        // Find the digit inside the number
        String s = Long.toString(number);
    System.out.println(s);
        return s.charAt((int)((n - 1) % i)) - '0';
    }
}
public class NthDigit {
    public static void main(String args[]){
NthDigitSolution nthDigitSolution=new NthDigitSolution();
    System.out.println(nthDigitSolution.findNthDigit(16));
    }
}
