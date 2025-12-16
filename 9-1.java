/**
 * @author zinov
 */
public class ExceptionsDemo {
    
    // Практика #1: классы исключений
    public static void explainExceptionClasses() {
        System.out.println("=== Практика #1 ===");
        System.out.println("Throwable - базовый класс всех исключений и ошибок");
        System.out.println("Error - серьезные системные ошибки (не обрабатываются)");
        System.out.println("Exception - проверяемые исключения (требуют обработки)");
        System.out.println("RuntimeException - непроверяемые исключения");
    }
    
    // Практика #2: примеры исключений
    public static void demonstrateExceptions() {
        System.out.println("\n=== Практика #2 ===");
        
        // 1. ArithmeticException
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("1. ArithmeticException: " + e.getMessage());
        }
        
        // 2. ArrayIndexOutOfBoundsException
        try {
            int[] arr = new int[5];
            int value = arr[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("2. ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
        
        // 3. IllegalArgumentException
        try {
            setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("3. IllegalArgumentException: " + e.getMessage());
        }
        
        // 4. ClassCastException
        try {
            Object obj = "String";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("4. ClassCastException: " + e.getMessage());
        }
        
        // 5. NullPointerException
        try {
            String str = null;
            int length = str.length();
        } catch (NullPointerException e) {
            System.out.println("5. NullPointerException: " + e.getMessage());
        }
    }
    
    private static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
    }
    
    public static void main(String[] args) {
        explainExceptionClasses();
        demonstrateExceptions();
    }
}
