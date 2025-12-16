/**
 * Класс Калькулятор для выполнения базовых арифметических операций.
 * 
 * @author Зинов Константин
 * @version 1.0
 * @since 2024
 */
public class Calculator {
    
    /**
     * Складывает два целых числа.
     * 
     * @param a первое слагаемое
     * @param b второе слагаемое
     * @return сумма a и b
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Делит одно число на другое.
     * 
     * @param dividend делимое
     * @param divisor делитель
     * @return результат деления
     * @throws ArithmeticException если делитель равен нулю
     * @see java.lang.ArithmeticException
     */
    public double divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return (double) dividend / divisor;
    }
    
    /**
     * Проверяет, является ли число четным.
     * 
     * @param number число для проверки
     * @return true если число четное, false если нечетное
     * @deprecated Используйте {@link #isEvenNumber(int)} вместо этого
     */
    @Deprecated
    public boolean checkEven(int number) {
        return number % 2 == 0;
    }
