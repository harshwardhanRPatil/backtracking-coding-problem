package BackTracking;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

  public static void main(String args[]) {
    int[] numbers = {1, 2, 3, 4, 5};
    Double average = 0.0;
    for (Integer i : numbers) {
      average += i;
    }
    DecimalFormat df = new DecimalFormat("0.00");
    Double sum = average / numbers.length;
    System.out.println(df.format(sum));
  }
}
