//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
//public class StockPricing {
//    private static final Logger LOGGER = LoggerFactory.getLogger(StockPricing.class);
//
//    public static void main(String[] args) {
//        //you have any value as you need i am consider all positive value as winning
//        int[] invesment = {12,34,-1,23,-34,0,0,-24,1,43};
//        try {
//            findStreaks(invesment);
//        } catch (
//                Exception e) {
//            LOGGER.error("An error occurred: {}", e.getMessage());
//        }
//    }
//
//    public static void findStreaks(int[] invesment) throws IllegalArgumentException {
//        //as you ask thowing error if data are not there
//        if (invesment == null || invesment.length == 0) {
//            throw new IllegalArgumentException("Input array is null or empty");
//        }
//        int longestWinningStreak = 0;
//        int curentWin = 0;
//
//        int shortestLosingStreak = 0;
//        int curentlost = 0;
//
//        for (int returns : invesment) {
//            if(returns>0){
//                curentWin+=1;
//                curentlost=0;
//            }
//            if(returns <0){
//                curentWin=0;
//                curentlost-=1;
//            }
//            longestWinningStreak = Math.max(longestWinningStreak, curentWin);
//            shortestLosingStreak = Math.min(shortestLosingStreak, curentlost);
//        }
//        LOGGER.info("Longest Winning Streak: {}", longestWinningStreak);
//        LOGGER.info("Shortest Losing Streak: {}", shortestLosingStreak);
//
//    }
//}