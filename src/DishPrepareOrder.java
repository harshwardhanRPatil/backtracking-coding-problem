//import java.util.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//public class DishPrepareOrder {
//    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorOperations.class);
//    public static List<Integer> dishPrepareOrder(List<Integer> orderList) {
//        // Define the restaurant menu with unique IDs
//        List<Integer> menu = Arrays.asList(1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009);
//
//        // Create a map to store the order of each dish ID
//        Map<Integer, Integer> orderMap = new HashMap<>();
//
//        // Assign order values to each dish ID based on their index in the menu
//        for (int i = 0; i < menu.size(); i++) {
//            orderMap.put(menu.get(i), i);
//        }
//
//        // Sort the orderList based on the assigned order values
//        orderList.sort(Comparator.comparingInt(orderMap::get));
//
//        return orderList;
//    }
//
//    public static void main(String[] args) {
//        // Example usage
//        List<Integer> orderList = Arrays.asList(1005, 1002, 1008, 1001);
//        List<Integer> preparedOrder = dishPrepareOrder(orderList);
//
//        LOGGER.info("Prepared Order: " + preparedOrder);
//    }
//}
