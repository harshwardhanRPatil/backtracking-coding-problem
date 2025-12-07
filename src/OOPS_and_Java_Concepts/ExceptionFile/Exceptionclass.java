package OOPS_and_Java_Concepts.FunctionInterface.ExceptionFile;


class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class Exceptionclass {

    public static void main(String[] args) {
        try {
            validateAge(15);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validateAge(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("Age must be 18 or above.");
        }
    }
}
