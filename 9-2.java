/**
 * @author zinov
 */
public class ExceptionHandlingDemo {
    
    // Метод, который может генерировать исключения
    public static void processData(int value) {
        if (value < 0) {
            // Это исключение будет "поймано"
            throw new IllegalArgumentException("Значение не может быть отрицательным");
        }
        
        if (value > 100) {
            // Это исключение НЕ будет обработано - приведет к аварийной остановке
            throw new RuntimeException("Значение слишком большое");
        }
        
        System.out.println("Обработка значения: " + value);
    }
    
    public static void main(String[] args) {
        System.out.println("=== Пример 1: Исключение будет перехвачено ===");
        try {
            processData(-5); // Генерирует IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }
        
        System.out.println("\n=== Пример 2: Исключение приведет к аварийной остановке ===");
        processData(200); // Генерирует RuntimeException - НЕ обработано!
        
        // Этот код никогда не выполнится
        System.out.println("Эта строка не будет напечатана");
    }
}
