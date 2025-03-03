public class InterFaceTest {
    public static void main(String[] args) {
        student student1 = (a, b) -> a + b;
        int result = student1.add(5, 3);
        System.out.println("Result: " + result);  // Output: Result: 8
    }
}
