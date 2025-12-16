/**
 * @author zinov
 */
public class StringBuildersDemo {
    
    // Практика #1: методы StringBuffer/StringBuilder
    public static void demonstrateMethods() {
        System.out.println("=== StringBuilder ===");
        StringBuilder sb = new StringBuilder("Hello");
        
        // 1. append() - добавление в конец
        sb.append(" World");
        System.out.println("1. append(): " + sb);
        
        // 2. insert() - вставка в указанную позицию
        sb.insert(5, ",");
        System.out.println("2. insert(): " + sb);
        
        // 3. delete() - удаление части строки
        sb.delete(5, 6);
        System.out.println("3. delete(): " + sb);
        
        // 4. reverse() - реверс строки
        System.out.println("4. reverse(): " + sb.reverse());
        sb.reverse(); // возвращаем обратно
        
        // 5. replace() - замена части строки
        sb.replace(6, 11, "Java");
        System.out.println("5. replace(): " + sb);
        
        // 6. setCharAt() - замена символа
        sb.setCharAt(0, 'h');
        System.out.println("6. setCharAt(): " + sb);
        
        // 7. charAt() - получение символа
        System.out.println("7. charAt(1): " + sb.charAt(1));
        
        // 8. length() - длина
        System.out.println("8. length(): " + sb.length());
        
        // 9. capacity() - текущая емкость
        System.out.println("9. capacity(): " + sb.capacity());
        
        // 10. substring() - получение подстроки
        System.out.println("10. substring(0, 5): " + sb.substring(0, 5));
        
        // StringBuffer - потокобезопасный аналог
        System.out.println("\n=== StringBuffer (аналогичные методы) ===");
        StringBuffer buffer = new StringBuffer("Test");
        buffer.append(" Buffer");
        System.out.println("StringBuffer: " + buffer);
    }
    
    // Практика #2: преобразования между типами
    public static void demonstrateConversions() {
        System.out.println("\n=== Преобразования ===");
        
        // 1. String -> StringBuilder/StringBuffer
        String str = "Hello";
        StringBuilder sb = new StringBuilder(str);
        StringBuffer buffer = new StringBuffer(str);
        
        // 2. StringBuilder/StringBuffer -> String
        String fromSB = sb.toString();
        String fromBuffer = buffer.toString();
        
        // 3. StringBuilder -> StringBuffer (через String)
        StringBuffer sbToBuffer = new StringBuffer(sb.toString());
        
        // 4. StringBuffer -> StringBuilder (через String)
        StringBuilder bufferToSB = new StringBuilder(buffer.toString());
        
        System.out.println("String -> StringBuilder: " + sb);
        System.out.println("String -> StringBuffer: " + buffer);
        System.out.println("StringBuilder -> String: " + fromSB);
        System.out.println("StringBuffer -> String: " + fromBuffer);
    }
    
    public static void main(String[] args) {
        demonstrateMethods();
        demonstrateConversions();
    }
}
