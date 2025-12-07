package Array.TwoPointer;

class MaxAreaWaterSolution {
  public int maxArea(int[] height) {

    int ans = 0;

    int left = 0;
    int right = height.length - 1;

    while (left < right) {
      int temp = Math.min(height[left], height[right]) * (right - left);
      ans = Math.max(temp, ans);
      if (height[left] >= height[right]) {
        right--;
      } else {
        left++;
      }
    }

    return ans;
  }
}

public class MaxAreaWater {
  public static void main(String args[]) {
    MaxAreaWaterSolution maxAreaWaterSolution = new MaxAreaWaterSolution();
    System.out.println(maxAreaWaterSolution.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    System.out.println(maxAreaWaterSolution.maxArea(new int[] {1, 1}));
  }
}
