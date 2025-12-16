/**
 * @author zinov
 */
public class FinallyDemo {
    
    public static void main(String[] args) {
        
        System.out.println("=== Практика #1 ===");
        System.out.println("try без catch и finally - НЕЛЬЗЯ");
        System.out.println("Ошибка компиляции: 'try' без 'catch', 'finally' или объявлений ресурсов");
        
        // Ошибка компиляции:
        // try {
        //     System.out.println("test");
        // }
        
        System.out.println("\n=== Практика #2 ===");
        System.out.println("try только с finally - МОЖНО");
        try {
            System.out.println("В блоке try");
            // throw new RuntimeException(); // Даже если исключение - finally выполнится
        } finally {
            System.out.println("Блок finally выполняется всегда");
        }
        
        System.out.println("\n=== Практика #3 ===");
        System.out.println("try с двумя finally - НЕЛЬЗЯ");
        System.out.println("Ошибка компиляции: у try может быть только один блок finally");
        
        // Ошибка компиляции:
        // try {
        //     System.out.println("try");
        // } finally {
        //     System.out.println("finally 1");
        // } finally {
        //     System.out.println("finally 2");
        // }
        
        System.out.println("\n=== Пример с try-catch-finally ===");
        try {
            System.out.println("Внутри try");
            int result = 10 / 0; // Вызовет исключение
        } catch (ArithmeticException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        } finally {
            System.out.println("Этот блок выполнится в любом случае");
        }
    }
}
