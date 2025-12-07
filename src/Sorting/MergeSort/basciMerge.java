package Sorting.MergeSort;

import java.util.Arrays;

public class basciMerge {

  public static void main(String args[]) {
   int[] valuerange={3,5,62,54,2,65,27};
   valuerange=mergeSort(valuerange);
    System.out.println(Arrays.toString(valuerange));
  }

  static int[] mergeSort(int[] arr) {
    if (arr.length == 1) return arr;
    int mid = arr.length / 2;

    int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
    int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

    return mergering(arr, left, right);
  }

  static int[] mergering(int[] arr, int[] left, int[] right) {
    int i = 0;
    int j = 0;
    int k = 0;
    int[] mix = new int[left.length + right.length];

    while (i < left.length && j < right.length) {
      if (left[i] > right[j]) {
        mix[k] = right[j];
        j++;
      } else {
        mix[k] = left[i];
        i++;
      }
      k++;
    }
    while (i < left.length) {
      mix[k] = left[i];
      i++;
      k++;
    }
    while (j < right.length) {
      mix[k] = right[j];
      j++;
      k++;
    }
    return mix;
  }
}
