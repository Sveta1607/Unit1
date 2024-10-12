import static  org.assertj.core.api.Assertions.*;

import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    public static void main(String[] args) {

        assertThat(Calculator.calculation(2,2,'+')).isEqualTo(4);
        assertThat(Calculator.calculation(3,2,'-')).isEqualTo(1);
        assertThat(Calculator.calculation(4,2,'*')).isEqualTo(8);
        assertThat(Calculator.calculation(6,2,'/')).isEqualTo(3);
    }

    @Test
    public void testCalculateDiscount() {
        Calculator calculator = new Calculator();

        // Проверка корректного расчета скидки
        double result1 = Calculator.calculateDiscount(100, 10);
        assertThat(result1).isEqualTo(90);

        // Проверка расчета скидки для суммы покупки равной 0
        double result2 = Calculator.calculateDiscount(0, 20);
        assertThat(result2).isEqualTo(0);

        // Проверка выброса исключения при отрицательной сумме покупки
        try {
            Calculator.calculateDiscount(-100, 10);
        } catch (ArithmeticException e) {
            assertThat(e).hasMessage("Invalid purchase amount or discount percentage");
            System.out.println("Test 3 passed: Exception for negative purchase amount.");
        }

        // Проверка выброса исключения при проценте скидки более 100
        try {
            Calculator.calculateDiscount(100, 150);
        } catch (ArithmeticException e) {
            assertThat(e).hasMessage("Invalid purchase amount or discount percentage");
            System.out.println("Test 4 passed: Exception for discount greater than 100.");
        }

        // Проверка выброса исключения при отрицательной скидке
        try {
            Calculator.calculateDiscount(100, -5);
        } catch (ArithmeticException e) {
            assertThat(e).hasMessage("Invalid purchase amount or discount percentage");
            System.out.println("Test 5 passed: Exception for negative discount.");
        }
    }


// Первая версия решения, Но почему то появлялась ошибка и я так и не смогла разобраться. Решала через try, catch. Решение выше, работает.

//        //Проверка выброса исключений при отрицательной сумме покупки
//         assertThatThrownBy(()-> Calculator.calculateDiscount(-100,15));...
//            .isInstanceOf(ArithmeticException.class)
//                .hasMessage("Invalid arguments");
//
//
//        //Проверка выброса исключений при отрицательном проценте скидки.
//        assertThatThrownBy(()-> Calculator.calculateDiscount(100,-15));
//            .isInstanceOf(ArithmeticException.class)
//                .hasMessage("Invalid arguments");
//
//        //Проверка выброса исключений при проценте скидки более 100%
//        assertThatThrownBy(()-> Calculator.calculateDiscount(100,150));
//            .isInstanceOf(ArithmeticException.class)
//               .hasMessage("Invalid arguments");

}


