/**
 * @author zinov
 */
public class MultipleExceptionsDemo {
    
    // Практика #1
    static class Ex1 extends Exception {}
    static class Ex2 extends Ex1 {}
    static class Ex3 extends Ex2 {}
    
    public static void demonstrateMultipleCatches() {
        System.out.println("=== Ситуация 1: Одинаковая обработка ===");
        try {
            // Код, который может генерировать исключения
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            // Одинаковая обработка для разных исключений
            System.out.println("Ошибка: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n=== Ситуация 2: Иерархия исключений ===");
        try {
            throw new Ex3(); // Самый специфичный
        } catch (Ex3 e) {
            System.out.println("Поймано Ex3");
        } catch (Ex2 e) {
            System.out.println("Поймано Ex2");
        } catch (Ex1 e) {
            System.out.println("Поймано Ex1");
        }
        
        // Ошибка: нельзя ловить подкласс после суперкласса
        /*
        try {
            throw new Ex3();
        } catch (Ex1 e) {  // Суперкласс
            System.out.println("Ex1");
        } catch (Ex3 e) {  // ОШИБКА: недостижимый код
            System.out.println("Ex3");
        }
        */
    }
    
    // Практика #2
    public static void demonstrateFinalInCatch() {
        System.out.println("\n=== Практика 2: final в catch ===");
        try {
            throw new Exception("Тестовое исключение");
        } catch (final Exception e) {
            // final означает, что переменную e нельзя переприсвоить
            // e = new Exception(); // ОШИБКА: нельзя изменить final переменную
            System.out.println("Исключение: " + e.getMessage());
        }
    }
    
    // Вложенные try
    public static void demonstrateNestedTry() {
        System.out.println("\n=== Вложенные try ===");
        try {
            // Внешний блок
            try {
                // Внутренний блок
                throw new NullPointerException("Внутреннее исключение");
            } catch (NullPointerException e) {
                System.out.println("Внутренний catch: " + e.getMessage());
                throw new RuntimeException("Переброс исключения");
            }
        } catch (RuntimeException e) {
            System.out.println("Внешний catch: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        demonstrateMultipleCatches();
        demonstrateFinalInCatch();
        demonstrateNestedTry();
    }
}
