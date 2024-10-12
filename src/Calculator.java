public class Calculator {
    public static int calculation(int firstOperand, int
            secondOperand, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    public static double calculateDiscount(double amount, double discount){
        if(amount < 0 || discount <0 || discount > 100){
            throw new ArithmeticException("Invalid purchase amount or discount percentage");
        }
        double discountAmount = amount * discount / 100;
        return amount - discountAmount;
    }

}
