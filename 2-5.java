/**
 * Демонстрация условных операторов и тернарного оператора
 * 
 * @author zinov
 * @version 1.0
 */
public class ConditionalOperatorsDemo {

    /**
     * Главный метод программы
     * 
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        System.out.println("=== Практика #1: Замена if-else на тернарный оператор ===\n");
        
        // Тестирование с разными значениями
        testTernaryOperator(1);
        testTernaryOperator(2);
        testTernaryOperator(5);
        
        System.out.println("\n=== Дополнительные примеры ===\n");
        demonstrateAdditionalExamples();
    }
    
    /**
     * Практика #1: Замена цепочки if-else if-else на тернарный оператор
     * Оригинальный код:
     * int i = 0;
     * if (a == 1) {
     *     i = 1;
     * } else if (a == 2) {
     *     i = 2;
     * } else {
     *     i = 3;
     * }
     */
    private static void testTernaryOperator(int a) {
        System.out.println("Для a = " + a + ":");
        
        // Оригинальный код с if-else if-else
        int iOriginal = 0;
        if (a == 1) {
            iOriginal = 1;
        } else if (a == 2) {
            iOriginal = 2;
        } else {
            iOriginal = 3;
        }
        
        System.out.println("  if-else if-else результат: i = " + iOriginal);
        
        // Решение через тернарный оператор
        int iTernary = (a == 1) ? 1 : ((a == 2) ? 2 : 3);
        
        System.out.println("  Тернарный оператор результат: i = " + iTernary);
        
        // Проверка, что результаты совпадают
        if (iOriginal == iTernary) {
            System.out.println("  ✓ Результаты совпадают");
        } else {
            System.out.println("  ✗ Ошибка: результаты различаются");
        }
        System.out.println();
    }
    
    /**
     * Дополнительные примеры использования тернарного оператора
     */
    private static void demonstrateAdditionalExamples() {
        System.out.println("1. Простой пример:");
        int x = 10;
        String result1 = (x > 0) ? "положительное" : "отрицательное или ноль";
        System.out.println("   x = " + x + " -> " + result1);
        
        System.out.println("\n2. Вложенные тернарные операторы (не рекомендуется для сложной логики):");
        int score = 85;
        String grade = (score >= 90) ? "A" : 
                      (score >= 80) ? "B" : 
                      (score >= 70) ? "C" : 
                      (score >= 60) ? "D" : "F";
        System.out.println("   Оценка " + score + " -> " + grade);
        
        System.out.println("\n3. Тернарный оператор с присваиванием:");
        int y = 15;
        int max;
        max = (x > y) ? x : y;
        System.out.println("   max(" + x + ", " + y + ") = " + max);
        
        System.out.println("\n4. Тернарный оператор с вызовом методов:");
        String text = "Hello";
        int length = (text != null) ? text.length() : 0;
        System.out.println("   Длина строки \"" + text + "\" = " + length);
        
        System.out.println("\n5. Важно: тернарный оператор требует совместимых типов:");
        Object obj = true;
        // Оба выражения должны быть совместимых типов или приводимых
        String message = (obj instanceof Boolean) ? "Это Boolean" : "Не Boolean";
        System.out.println("   " + message);
        
        System.out.println("\n6. Проблема с null:");
        String str = null;
        String safeStr = (str != null) ? str : "значение по умолчанию";
        System.out.println("   Безопасное значение: " + safeStr);
    }
}

/**
 * Дополнительный пример с более сложным преобразованием if-else в тернарный оператор
 * 
 * @author zinov
 */
class AdditionalExample {
    
    public static void main(String[] args) {
        System.out.println("=== Сложный пример преобразования ===");
        
        int value = 42;
        
        // Сложная цепочка if-else if-else
        String category;
        if (value < 0) {
            category = "отрицательное";
        } else if (value == 0) {
            category = "ноль";
        } else if (value > 0 && value < 10) {
            category = "маленькое положительное";
        } else if (value >= 10 && value < 100) {
            category = "среднее положительное";
        } else {
            category = "большое положительное";
        }
        
        System.out.println("if-else if-else: " + value + " -> " + category);
        
        // Эквивалент через тернарный оператор (менее читаемый)
        String categoryTernary = 
            (value < 0) ? "отрицательное" :
            (value == 0) ? "ноль" :
            (value > 0 && value < 10) ? "маленькое положительное" :
            (value >= 10 && value < 100) ? "среднее положительное" :
            "большое положительное";
        
        System.out.println("Тернарный оператор: " + value + " -> " + categoryTernary);
        
        System.out.println("\nВывод: Для сложной логики лучше использовать if-else для читаемости.");
    }
}
