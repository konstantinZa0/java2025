/**
 * @author zinov
 */
import java.util.StringJoiner;

public class StringDemo {
    
    // Практика #1: 10 методов String
    public static void demonstrateStringMethods() {
        String str = " Hello World! ";
        
        // 1. length() - длина строки
        System.out.println("1. length(): " + str.length());
        
        // 2. trim() - удаление пробелов по краям
        System.out.println("2. trim(): '" + str.trim() + "'");
        
        // 3. toUpperCase() / toLowerCase() - регистр
        System.out.println("3. toUpperCase(): " + str.toUpperCase());
        System.out.println("   toLowerCase(): " + str.toLowerCase());
        
        // 4. substring() - подстрока
        System.out.println("4. substring(1, 5): " + str.substring(1, 5));
        
        // 5. replace() - замена символов
        System.out.println("5. replace('l', 'L'): " + str.replace('l', 'L'));
        
        // 6. split() - разделение на массив
        String[] parts = str.trim().split(" ");
        System.out.println("6. split(): " + String.join(", ", parts));
        
        // 7. startsWith() / endsWith() - проверка начала/конца
        System.out.println("7. startsWith('He'): " + str.startsWith(" He"));
        System.out.println("   endsWith('! '): " + str.endsWith("! "));
        
        // 8. indexOf() / lastIndexOf() - поиск символа
        System.out.println("8. indexOf('o'): " + str.indexOf('o'));
        System.out.println("   lastIndexOf('o'): " + str.lastIndexOf('o'));
        
        // 9. contains() - проверка наличия подстроки
        System.out.println("9. contains('World'): " + str.contains("World"));
        
        // 10. equals() / equalsIgnoreCase() - сравнение
        System.out.println("10. equals(' Hello World! '): " + str.equals(" Hello World! "));
        System.out.println("    equalsIgnoreCase(' hello world! '): " + 
                          str.equalsIgnoreCase(" hello world! "));
    }
    
    // Практика #2: StringJoiner
    public static void demonstrateStringJoiner() {
        // С разделителем
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("Apple").add("Banana").add("Orange");
        System.out.println("\nStringJoiner с разделителем: " + joiner1);
        
        // С разделителем, префиксом и суффиксом
        StringJoiner joiner2 = new StringJoiner("; ", "[", "]");
        joiner2.add("Red").add("Green").add("Blue");
        System.out.println("StringJoiner с оформлением: " + joiner2);
        
        // Объединение джойнеров
        StringJoiner joiner3 = new StringJoiner("-");
        joiner3.merge(joiner2);
        System.out.println("Объединение: " + joiner3);
    }
    
    public static void main(String[] args) {
        System.out.println("=== Практика #1 ===");
        demonstrateStringMethods();
        
        System.out.println("\n=== Практика #2 ===");
        demonstrateStringJoiner();
        
        System.out.println("\n=== Практика #3 ===");
        System.out.println("Три двойные кавычки (\"\"\") используются");
        System.out.println("для создания текстовых блоков (Text Blocks)");
        System.out.println("начиная с Java 13. Позволяют создавать");
        System.out.println("многострочные строки с сохранением форматирования.");
        System.out.println("\nПример (Java 13+):");
        System.out.println("String html = \"\"\"");
        System.out.println("    <html>");
        System.out.println("        <body>");
        System.out.println("            <p>Hello</p>");
        System.out.println("        </body>");
        System.out.println("    </html>");
        System.out.println("\"\"\";");
    }
}
