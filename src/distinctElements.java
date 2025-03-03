//import java.util.HashSet;
//import java.util.Set;
//
//public class distinctElements {
//    private static final Logger LOGGER = LoggerFactory.getLogger(StockPricing.class);
//
//    public static void main(String[] args) {
//        int[] nums = {4, 6, 1, 5, 8};
//        int target = 13;
//        if (nums == null || nums.length < 2) {
//            LOGGER.info("Array is empty");
//            return;
//        }
//        Set<Integer> numberSet = new HashSet<>();
//        for (int num : nums) {
//            int second_half = target - num;
//            if (numberSet.contains(num)) {
////                when we find the target value second half we can print this message and return the value
//                LOGGER.info("There are 2 element that sum if equal to target value");
//                return;
//            }
//            numberSet.add(second_half);
//        }
//        //after going to all the value we are not able to find any 2 value  sum euqal to target
//        LOGGER.info("There no 2 element that sum if equal to target value");
//
//    }
//}
