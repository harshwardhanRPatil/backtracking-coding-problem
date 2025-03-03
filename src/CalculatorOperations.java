//import java.lang.Math;
//
//// Interface for mathematical operations
//interface CalculatorOper {
//    double add(double a, double b);
//
//    double subtract(double a, double b);
//
//    double multiply(double a, double b);
//
//    double divide(double a, double b);
//
//    double sin(double angle);
//
//    double cos(double angle);
//
//    double tan(double angle);
//
//    double log(double base, double value);
//
//    double exp(double exponent);
//
//    double toDegrees(double radians);
//}
//
//class BasicCalculator implements CalculatorOper {
//
//    @Override
//    public double add(double a, double b) {
//        return a + b;
//    }
//
//    @Override
//    public double subtract(double a, double b) {
//        return a - b;
//    }
//
//    @Override
//    public double multiply(double a, double b) {
//        return a * b;
//    }
//
//    @Override
//    public double divide(double a, double b) {
//        if (b == 0) {
//            throw new ArithmeticException("Cannot divide by zero");
//        }
//        return a / b;
//    }
//
//    @Override
//    public double sin(double angle) {
//        return Math.sin(angle);
//    }
//
//    @Override
//    public double cos(double angle) {
//        return Math.cos(angle);
//    }
//
//    @Override
//    public double tan(double angle) {
//        return Math.tan(angle);
//    }
//
//    @Override
//    public double log(double base, double value) {
//        return Math.log(value) / Math.log(base);
//    }
//
//    @Override
//    public double exp(double exponent) {
//        return Math.exp(exponent);
//    }
//
//    @Override
//    public double toDegrees(double radians) {
//        return Math.toDegrees(radians);
//    }
//}
//
//// Calculator class that encapsulates the BasicCalculator
//class ScientificCalculator {
//
//    private final CalculatorOper calculator;
//
//    public ScientificCalculator(CalculatorOper calculator) {
//        this.calculator = calculator;
//    }
//
//    public double add(double a, double b) {
//        return calculator.add(a, b);
//    }
//
//    public double subtract(double a, double b) {
//        return calculator.subtract(a, b);
//    }
//
//    public double multiply(double a, double b) {
//        return calculator.multiply(a, b);
//    }
//
//    public double divide(double a, double b) {
//        return calculator.divide(a, b);
//    }
//
//    public double sin(double angle) {
//        return calculator.sin(angle);
//    }
//
//    public double cos(double angle) {
//        return calculator.cos(angle);
//    }
//
//    public double tan(double angle) {
//        return calculator.tan(angle);
//    }
//
//    public double log(double base, double value) {
//        return calculator.log(base, value);
//    }
//
//    public double exp(double exponent) {
//        return calculator.exp(exponent);
//    }
//
//    public double toDegrees(double radians) {
//        return calculator.toDegrees(radians);
//    }
//}
//
//public class CalculatorOperations {
//    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorOperations.class);
//    public static void main(String[] args) {
//        // Create an instance of the ScientificCalculator using BasicCalculator
//        ScientificCalculator scientificCalculator = new ScientificCalculator(new BasicCalculator());
//
//        // Example usage
//        double result1 = scientificCalculator.add(5, 3);
//        double result2 = scientificCalculator.sin(Math.toRadians(30));
//        double result3 = scientificCalculator.log(10, 100);
//
//        LOGGER.info("Result 1: " + result1);
//        LOGGER.info("Result 2: " + result2);
//        LOGGER.info("Result 3: " + result3);
//    }
//}
