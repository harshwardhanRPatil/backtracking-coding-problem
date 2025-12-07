package Array;

class KLengthApartSolution {
  public boolean kLengthApart(int[] nums, int k) {
    int last = -1;
    boolean firstOccurence = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1 && !firstOccurence) {
        last = i;
        firstOccurence = true;
      } else if (firstOccurence && nums[i] == 1) {
        if (i - last -1<k) {
          return false;
        }
        last = i;
      }
    }
    return true;
  }
}

public class KLengthApart {
  public static void main(String args[]) {
    KLengthApartSolution kLengthApartSolution = new KLengthApartSolution();
    System.out.println(kLengthApartSolution.kLengthApart(new int[] {1, 0, 1, 0, 1, 0, 0, 1}, 2));
  }
}
