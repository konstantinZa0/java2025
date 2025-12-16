/**
 * @author zinov
 */
import java.util.Formatter;
import java.util.Date;

public class FormatterDemo {
    
    // Практика #1: 5 спецификаторов
    public static void demonstrateSpecifiers() {
        Formatter fmt = new Formatter();
        
        // %s - строка
        fmt.format("Строка: %s%n", "Hello");
        
        // %d - целое число
        fmt.format("Число: %d%n", 100);
        
        // %f - число с плавающей точкой
        fmt.format("Дробное: %.2f%n", 3.14159);
        
        // %b - логическое значение
        fmt.format("Логическое: %b%n", true);
        
        // %c - символ
        fmt.format("Символ: %c%n", 'A');
        
        System.out.println(fmt);
        fmt.close();
    }
    
    // Практика #2: метод flush()
    public static void demonstrateFlush() {
        System.out.println("\n=== Практика #2 ===");
        System.out.println("flush() принудительно записывает буферизованные данные");
        System.out.println("Нужен для:");
        System.out.println("1. Форматтеров (Formatter)");
        System.out.println("2. Потоков вывода (OutputStream, Writer)");
        System.out.println("3. Обеспечения своевременной записи данных");
    }
    
    // Практика #3: спецификаторы времени
    public static void demonstrateTimeSpecifiers() {
        System.out.println("\n=== Практика #3 ===");
        Date now = new Date();
        
        Formatter fmt = new Formatter();
        
        // %tH - час (00-23)
        fmt.format("Час: %tH%n", now);
        
        // %tM - минуты
        fmt.format("Минуты: %tM%n", now);
        
        // %tS - секунды
        fmt.format("Секунды: %tS%n", now);
        
        // %tY - год (4 цифры)
        fmt.format("Год: %tY%n", now);
        
        // %tB - месяц (полное название)
        fmt.format("Месяц: %tB%n", now);
        
        System.out.println(fmt);
        fmt.close();
    }
    
    public static void main(String[] args) {
        demonstrateSpecifiers();
        demonstrateFlush();
        demonstrateTimeSpecifiers();
        
        // Дополнительный пример с printf
        System.out.println("\n=== Пример с printf ===");
        System.out.printf("Имя: %s, Возраст: %d, Зарплата: %.2f%n", 
                         "Иван", 30, 1500.50);
    }
}
