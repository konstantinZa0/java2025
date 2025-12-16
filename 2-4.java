/**
 *  Wrapper Classes
 * 
 * @author zinov
 * @version 1.0
 */
public class WrapperClassesDemo {

    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА 1: Метод decode() ===\n");
        demonstrateDecode();
        
        System.out.println("\n=== ПРАКТИКА 2: Создание Boolean ===\n");
        demonstrateBooleanCreation();
        
        System.out.println("\n=== ПРАКТИКА 3: NullPointerException при автоупаковке ===\n");
        demonstrateNPE();
        
        System.out.println("\n=== ПРАКТИКА 4: Сравнение Integer и кэширование ===\n");
        demonstrateIntegerCache();
    }
    
    // ========== ПРАКТИКА 1: Метод decode() ==========
    private static void demonstrateDecode() {
        // decode() преобразует строку в число, распознавая разные системы счисления
        System.out.println("Integer.decode(\"10\") = " + Integer.decode("10"));     // десятичное: 10
        System.out.println("Integer.decode(\"0x10\") = " + Integer.decode("0x10")); // шестнадцатеричное: 16
        System.out.println("Integer.decode(\"0XFF\") = " + Integer.decode("0XFF")); // шестнадцатеричное: 255
        System.out.println("Integer.decode(\"#FF\") = " + Integer.decode("#FF"));   // шестнадцатеричное: 255
        System.out.println("Integer.decode(\"010\") = " + Integer.decode("010"));   // восьмеричное: 8
        
        // Для других типов
        System.out.println("Long.decode(\"0x100000000\") = " + Long.decode("0x100000000")); // long: 4294967296
        System.out.println("Short.decode(\"0x7FFF\") = " + Short.decode("0x7FFF"));         // short: 32767
    }
    
    // ========== ПРАКТИКА 2: Создание Boolean ==========
    private static void demonstrateBooleanCreation() {
        // 1. Через конструктор (устаревший, не рекомендуется с Java 9)
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("TRUE");
        Boolean b4 = new Boolean("yes"); // false
        
        // 2. Через valueOf() (рекомендуемый способ)
        Boolean b5 = Boolean.valueOf(true);
        Boolean b6 = Boolean.valueOf("true");
        Boolean b7 = Boolean.valueOf("TRUE");
        Boolean b8 = Boolean.valueOf("yes"); // false
        
        // 3. Через parseBoolean() возвращает примитив boolean
        boolean b9 = Boolean.parseBoolean("true");
        boolean b10 = Boolean.parseBoolean("false");
        boolean b11 = Boolean.parseBoolean("TRUE");
        boolean b12 = Boolean.parseBoolean("anything"); // false
        
        // 4. Автоупаковка
        Boolean b13 = true;
        
        System.out.println("Способы создания Boolean:");
        System.out.println("new Boolean(true) = " + b1);
        System.out.println("Boolean.valueOf(\"true\") = " + b6);
        System.out.println("Boolean.parseBoolean(\"TRUE\") = " + b9);
        System.out.println("Автоупаковка Boolean b = true = " + b13);
        
        // Важно: Boolean.valueOf() использует кэширование
        System.out.println("\nКэширование Boolean:");
        System.out.println("Boolean.valueOf(true) == Boolean.valueOf(true): " + 
                          (Boolean.valueOf(true) == Boolean.valueOf(true))); // true
        System.out.println("Boolean.valueOf(false) == Boolean.valueOf(false): " + 
                          (Boolean.valueOf(false) == Boolean.valueOf(false))); // true
    }
    
    // ========== ПРАКТИКА 3: NullPointerException при автоупаковке ==========
    private static void demonstrateNPE() {
        try {
            Integer nullInteger = null;
            // При автораспаковке null в примитив будет NPE
            int primitive = nullInteger; // NullPointerException здесь
        } catch (NullPointerException e) {
            System.out.println("NullPointerException при автораспаковке: " + e.getMessage());
        }
        
        // Другие примеры NPE при автораспаковке
        try {
            Integer nullInt = null;
            int result = nullInt + 10; // NPE при автораспаковке
        } catch (NullPointerException e) {
            System.out.println("NullPointerException в выражении: nullInt + 10");
        }
        
        try {
            Boolean nullBool = null;
            if (nullBool) { // NPE при автораспаковке в условии
                System.out.println("Не выполнится");
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException в условии if(nullBool)");
        }
    }
    
    // ========== ПРАКТИКА 4: Сравнение Integer и кэширование ==========
    private static void demonstrateIntegerCache() {
        System.out.println("Часть 1: i1 = 128");
        int i1 = 128;
        Integer a1 = i1;
        Integer b1 = i1;
        System.out.println("a1 == i1 " + (a1 == i1));           // true (автораспаковка)
        System.out.println("b1 == i1 " + (b1 == i1));           // true (автораспаковка)
        System.out.println("a1 == b1 " + (a1 == b1));           // false (разные объекты)
        System.out.println("a1.equals(i1) -> " + a1.equals(i1)); // true
        System.out.println("b1.equals(i1) -> " + b1.equals(i1)); // true
        System.out.println("a1.equals(b1) -> " + a1.equals(b1)); // true
        
        System.out.println("\nЧасть 2: i2 = 127");
        int i2 = 127;
        Integer a2 = i2;
        Integer b2 = i2;
        System.out.println("a2 == i2 " + (a2 == i2));           // true (автораспаковка)
        System.out.println("b2 == i2 " + (b2 == i2));           // true (автораспаковка)
        System.out.println("a2 == b2 " + (a2 == b2));           // true (кэширование!)
        System.out.println("a2.equals(i2) -> " + a2.equals(i2)); // true
        System.out.println("b2.equals(i2) -> " + b2.equals(i2)); // true
        System.out.println("a2.equals(b2) -> " + a2.equals(b2)); // true
        
        // Дополнительные примеры
        System.out.println("\nДополнительные примеры кэширования:");
        System.out.println("Integer.valueOf(127) == Integer.valueOf(127): " + 
                          (Integer.valueOf(127) == Integer.valueOf(127))); // true
        System.out.println("Integer.valueOf(128) == Integer.valueOf(128): " + 
                          (Integer.valueOf(128) == Integer.valueOf(128))); // false
        
        System.out.println("\n=== Объяснение ===");
        System.out.println("1. При сравнении Integer == int происходит автораспаковка Integer,");
        System.out.println("   и сравниваются примитивные значения.");
        System.out.println("2. Класс IntegerCache кэширует значения от -128 до 127 (по умолчанию).");
        System.out.println("3. При автоупаковке значений в этом диапазоне возвращаются кэшированные объекты.");
        System.out.println("4. Для 127: a2 и b2 ссылаются на один кэшированный объект (a2 == b2 true).");
        System.out.println("5. Для 128: a1 и b1 создаются как новые объекты (a1 == b1 false).");
        System.out.println("6. Метод equals() сравнивает значения, поэтому всегда возвращает true для одинаковых чисел.");
        
        System.out.println("\nНастройка кэша через системное свойство:");
        System.out.println("Можно изменить верхнюю границу кэша через -Djava.lang.Integer.IntegerCache.high=<значение>");
    }
}
