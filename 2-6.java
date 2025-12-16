/**
 * Демонстрация оператора switch в Java
 * 
 * @author zinov
 * @version 1.0
 */
public class SwitchOperatorDemo {

    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА 1: Типы переменных в switch ===\n");
        demonstrateSwitchTypes();
        
        System.out.println("\n=== ПРАКТИКА 2: Отсутствие break в case ===\n");
        demonstrateMissingBreak();
        
        System.out.println("\n=== Новые возможности switch (Java 14+) ===\n");
        demonstrateNewSwitchFeatures();
    }
    
    // ========== ПРАКТИКА 1: Типы переменных в switch ==========
    private static void demonstrateSwitchTypes() {
        System.out.println("До Java 7 в switch можно было использовать только:");
        System.out.println("- byte, short, char, int (и их обертки)");
        System.out.println("- enum");
        System.out.println("\nС Java 7 также можно использовать:");
        System.out.println("- String");
        System.out.println("\nПримеры для всех возможных типов:");
        
        // 1. int (и другие целочисленные)
        System.out.println("\n1. int:");
        int intValue = 2;
        switch (intValue) {
            case 1:
                System.out.println("   Значение: 1");
                break;
            case 2:
                System.out.println("   Значение: 2");
                break;
            default:
                System.out.println("   Другое значение");
        }
        
        // 2. byte
        System.out.println("\n2. byte:");
        byte byteValue = 10;
        switch (byteValue) {
            case 10:
                System.out.println("   Значение: 10");
                break;
            case 20:
                System.out.println("   Значение: 20");
                break;
        }
        
        // 3. short
        System.out.println("\n3. short:");
        short shortValue = 100;
        switch (shortValue) {
            case 100:
                System.out.println("   Значение: 100");
                break;
        }
        
        // 4. char
        System.out.println("\n4. char:");
        char charValue = 'A';
        switch (charValue) {
            case 'A':
                System.out.println("   Значение: A");
                break;
            case 'B':
                System.out.println("   Значение: B");
                break;
        }
        
        // 5. String (с Java 7)
        System.out.println("\n5. String (Java 7+):");
        String stringValue = "hello";
        switch (stringValue) {
            case "hello":
                System.out.println("   Приветствие");
                break;
            case "world":
                System.out.println("   Мир");
                break;
        }
        
        // 6. Enum
        System.out.println("\n6. Enum:");
        Day day = Day.MONDAY;
        switch (day) {
            case MONDAY:
                System.out.println("   Понедельник");
                break;
            case TUESDAY:
                System.out.println("   Вторник");
                break;
        }
        
        // 7. Обертки примитивных типов (autounboxing)
        System.out.println("\n7. Integer (автораспаковка):");
        Integer integerValue = 5;
        switch (integerValue) {
            case 5:
                System.out.println("   Значение: 5");
                break;
            case 10:
                System.out.println("   Значение: 10");
                break;
        }
        
        System.out.println("\nНЕЛЬЗЯ использовать в switch:");
        System.out.println("- long, float, double, boolean");
        System.out.println("- любые другие объекты кроме String и enum");
    }
    
    // ========== ПРАКТИКА 2: Отсутствие break в case ==========
    private static void demonstrateMissingBreak() {
        System.out.println("Пример без break (проваливание через case):");
        
        int value = 2;
        System.out.println("value = " + value);
        
        switch (value) {
            case 1:
                System.out.println("   case 1: i = 1");
                break;
            case 2:
                System.out.println("   case 2: i = 2 (нет break!)");
                // Здесь нет break, выполнение "проваливается" в следующий case
            case 3:
                System.out.println("   case 3: i = 3");
                break;
            default:
                System.out.println("   default");
        }
        
        System.out.println("\nЧто произошло:");
        System.out.println("1. value == 2, поэтому выполняется case 2");
        System.out.println("2. В case 2 нет break, поэтому выполнение продолжается");
        System.out.println("3. Выполняется код case 3 (пропуская проверку условия)");
        System.out.println("4. В case 3 есть break, поэтому выходим из switch");
        
        System.out.println("\nДругой пример с несколькими проваливаниями:");
        int day = 2;
        System.out.println("\nДень недели: " + day);
        
        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("   Будний день");
                break;
            case 6:
            case 7:
                System.out.println("   Выходной день");
                break;
            default:
                System.out.println("   Неверный день");
        }
        
        System.out.println("\nКогда проваливание полезно:");
        System.out.println("- Когда несколько case должны выполнять один и тот же код");
        System.out.println("- Для группировки case (как в примере с днями недели)");
        
        System.out.println("\nКогда проваливание опасно:");
        System.out.println("- Когда это происходит случайно (ошибка программиста)");
        System.out.println("- Когда логика требует выполнения только одного case");
        
        // Демонстрация с default в середине
        System.out.println("\nПример с default в середине:");
        int test = 5;
        switch (test) {
            case 1:
                System.out.println("   case 1");
                break;
            default:
                System.out.println("   default (в середине!)");
                // Здесь тоже нет break!
            case 2:
                System.out.println("   case 2");
                break;
        }
    }
    
    // ========== Новые возможности switch (Java 14+) ==========
    private static void demonstrateNewSwitchFeatures() {
        System.out.println("Новые возможности switch (Java 14+):");
        
        // Switch expression (возвращает значение)
        System.out.println("\n1. Switch как выражение (возвращает значение):");
        int number = 2;
        
        String result = switch (number) {
            case 1 -> "один";
            case 2 -> "два";
            case 3 -> "три";
            default -> "много";
        };
        
        System.out.println("   Число " + number + " -> " + result);
        
        // Блоки кода в стрелочном синтаксисе
        System.out.println("\n2. Блоки кода с yield:");
        int score = 85;
        
        String grade = switch (score / 10) {
            case 10, 9 -> "A";
            case 8 -> {
                System.out.println("   Хорошая работа!");
                yield "B";
            }
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
        
        System.out.println("   Оценка: " + grade);
        
        // Множественные значения в case
        System.out.println("\n3. Множественные значения через запятую:");
        int month = 2;
        
        String season = switch (month) {
            case 12, 1, 2 -> "Зима";
            case 3, 4, 5 -> "Весна";
            case 6, 7, 8 -> "Лето";
            case 9, 10, 11 -> "Осень";
            default -> "Неверный месяц";
        };
        
        System.out.println("   Месяц " + month + " -> " + season);
    }
    
    // Enum для демонстрации
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}

/**
 * Дополнительный класс для демонстрации ошибок компиляции
 * 
 * @author zinov
 */
class SwitchErrors {
    public static void main(String[] args) {
        System.out.println("=== Примеры ошибок компиляции ===");
        
        // Ошибка: нельзя использовать long
        /*
        long longValue = 100L;
        switch (longValue) {  // Ошибка компиляции
            case 100L:
                break;
        }
        */
        System.out.println("long в switch: ошибка компиляции");
        
        // Ошибка: нельзя использовать double
        /*
        double doubleValue = 3.14;
        switch (doubleValue) {  // Ошибка компиляции
            case 3.14:
                break;
        }
        */
        System.out.println("double в switch: ошибка компиляции");
        
        // Ошибка: нельзя использовать null в switch (NullPointerException)
        System.out.println("\nВажно: switch(null) вызовет NullPointerException");
        String nullString = null;
        try {
            switch (nullString) {  // NullPointerException
                case "test":
                    System.out.println("test");
                    break;
            }
        } catch (NullPointerException e) {
            System.out.println("Поймано NullPointerException при switch(null)");
        }
    }
}
