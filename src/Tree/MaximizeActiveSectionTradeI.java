package Tree;

class MaximizeActiveSectionTradeISolution {
    public int maxActiveSectionsAfterTrade(String s) {
        String t = "1" + s + "1"; // Augment s
        int n = t.length();
        int activeSections = 0;

        // Count initial contiguous '1' groups
        for (int i = 1; i < n - 1; i++) {
            if (t.charAt(i) == '1' && t.charAt(i - 1) == '0') {
                activeSections++;
            }
        }

        int maxActive = activeSections;

        // Iterate to check the best swap
        for (int i = 1; i < n - 1; i++) {
            if (t.charAt(i) == '0') {
                int left = (t.charAt(i - 1) == '1') ? 1 : 0;
                int right = (t.charAt(i + 1) == '1') ? 1 : 0;

                // Case 1: '0' is between two '1' groups → Merge two '1' groups
                if (left == 1 && right == 1) {
                    maxActive = Math.max(maxActive, activeSections + 1);
                }
                // Case 2: '0' is not between two '1' groups
                else if (left == 0 && right == 0) {
                    maxActive = Math.max(maxActive, activeSections - 1);
                }
            }
        }

        return maxActive;
    }
}
public class MaximizeActiveSectionTradeI {
    public static void main(String args[]){
        MaximizeActiveSectionTradeISolution maximizeActiveSectionTradeISolution=new MaximizeActiveSectionTradeISolution();
    System.out.println(maximizeActiveSectionTradeISolution.maxActiveSectionsAfterTrade("0100"));
    }
}
