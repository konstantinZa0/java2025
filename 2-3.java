public class OperatorsDemo {
    public static void main(String[] args) {
        // Базовые типы
        int a = 10, b = 3;
        double d = 5.5;
        boolean bool1 = true, bool2 = false;
        
        // 1. Операторы присваивания: =, +=, -=, *=, /=, %=
        System.out.println("=== Операторы присваивания ===");
        int x = 10;  // = 
        x += 5;      // x = x + 5 (15)
        x -= 3;      // x = x - 3 (12)
        x *= 2;      // x = x * 2 (24)
        x /= 4;      // x = x / 4 (6)
        x %= 4;      // x = x % 4 (2)
        
        // 2. Тернарный оператор ?:
        System.out.println("=== Тернарный оператор ===");
        int max = (a > b) ? a : b;  // 10
        String result = (a % 2 == 0) ? "четное" : "нечетное";  // "четное"
        
        // 3. Логические ИЛИ: ||
        System.out.println("=== Логическое ИЛИ ===");
        boolean or1 = bool1 || bool2;  // true || false = true
        boolean or2 = (a > 5) || (b < 1);  // true || false = true
        
        // 4. Логические И: &&
        System.out.println("=== Логическое И ===");
        boolean and1 = bool1 && bool2;  // true && false = false
        boolean and2 = (a > 5) && (b > 2);  // true && true = true
        
        // 5. Побитовое ИЛИ: |
        System.out.println("=== Побитовое ИЛИ ===");
        int bitOr = 5 | 3;  // 0101 | 0011 = 0111 (7)
        
        // 6. Побитовое исключающее ИЛИ: ^
        System.out.println("=== Побитовое XOR ===");
        int bitXor = 5 ^ 3;  // 0101 ^ 0011 = 0110 (6)
        boolean boolXor = true ^ false;  // true
        
        // 7. Побитовое И: &
        System.out.println("=== Побитовое И ===");
        int bitAnd = 5 & 3;  // 0101 & 0011 = 0001 (1)
        
        // 8. Операторы сравнения: ==, !=
        System.out.println("=== Сравнение ===");
        boolean eq1 = a == 10;  // true
        boolean eq2 = a != b;   // true
        
        // 9. Операторы сравнения: >, >=, <, <=
        System.out.println("=== Операторы сравнения ===");
        boolean gt = a > b;    // true
        boolean ge = a >= 10;  // true
        boolean lt = b < a;    // true
        boolean le = b <= 3;   // true
        
        // 10. Побитовые сдвиги: >>, >>>, <<
        System.out.println("=== Побитовые сдвиги ===");
        int rightShift = 8 >> 1;     // 1000 >> 1 = 0100 (4)
        int unsignedRightShift = -8 >>> 1;  // Сдвиг без учета знака
        int leftShift = 3 << 2;      // 0011 << 2 = 1100 (12)
        
        // 11. Арифметические: +, -
        System.out.println("=== Арифметические + и - ===");
        int sum = a + b;      // 13
        int diff = a - b;     // 7
        String concat = "a=" + a + ", b=" + b;  // "a=10, b=3"
        
        // 12. Арифметические: *, /, %
        System.out.println("=== Арифметические *, /, % ===");
        int mult = a * b;     // 30
        int div = a / b;      // 3 (целочисленное деление)
        double realDiv = (double) a / b;  // 3.333...
        int mod = a % b;      // 1
        
        // 13. ++, -- (префиксная и постфиксная формы)
        System.out.println("=== Инкремент/декремент ===");
        int prefInc = ++a;    // a увеличивается до 11, prefInc = 11
        int postInc = b++;    // postInc = 3, потом b увеличивается до 4
        
        int c = 5;
        int prefDec = --c;    // c уменьшается до 4, prefDec = 4
        int postDec = c--;    // postDec = 4, потом c уменьшается до 3
        
        // 14. Побитовое НЕ: ~
        System.out.println("=== Побитовое НЕ ===");
        int bitNot = ~5;      // ~0101 = 1010 (в дополнении до двух: -6)
        
        // 15. Логическое НЕ: !
        System.out.println("=== Логическое НЕ ===");
        boolean not = !bool1;  // false
        
        // 16. Операторы со String
        System.out.println("=== Операторы со String ===");
        String s1 = "Hello";
        String s2 = "World";
        String s3 = s1 + " " + s2;  // "Hello World"
        s1 += "!";                  // "Hello!"
        
        boolean strEq = s1.equals("Hello!");  // true (сравнение содержимого)
        boolean strRefEq = s1 == "Hello!";    // false (сравнение ссылок)
        
        // Вывод результатов
        System.out.println("x = " + x);
        System.out.println("max = " + max);
        System.out.println("result = " + result);
        System.out.println("concat = " + concat);
        System.out.println("prefInc = " + prefInc + ", postInc = " + postInc);
        System.out.println("s3 = " + s3);
    }
}

//#2 практика
class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class InstanceofDemo {
    public static void main(String[] args) {
        // 1. Базовые примеры
        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();
        
        System.out.println("=== Базовые проверки ===");
        System.out.println("dog instanceof Dog: " + (dog instanceof Dog));      // true
        System.out.println("dog instanceof Animal: " + (dog instanceof Animal)); // true
        System.out.println("animal instanceof Dog: " + (animal instanceof Dog)); // false
        
        // 2. Проверка с null
        System.out.println("\n=== Проверка с null ===");
        Animal nullAnimal = null;
        System.out.println("nullAnimal instanceof Animal: " + (nullAnimal instanceof Animal));  // false
        System.out.println("null instanceof Object: " + (null instanceof Object));  // false
        System.out.println("null instanceof String: " + (null instanceof String));  // false
        
        // 3. Практическое применение
        System.out.println("\n=== Практическое применение ===");
        Animal[] animals = {new Dog(), new Cat(), new Animal()};
        
        for (Animal a : animals) {
            if (a instanceof Dog) {
                System.out.println("Это собака");
                // Можно безопасно привести тип
                Dog d = (Dog) a;
            } else if (a instanceof Cat) {
                System.out.println("Это кот");
            } else {
                System.out.println("Неизвестное животное");
            }
        }
        
        // 4. С Java 14: Pattern Matching for instanceof
        System.out.println("\n=== Pattern Matching (Java 14+) ===");
        Object obj = "Hello World";
        
        // Старый способ (до Java 14)
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println("Длина строки (старый способ): " + str.length());
        }
        
        // Новый способ (Java 14+)
        if (obj instanceof String str) {
            System.out.println("Длина строки (новый способ): " + str.length());
        }
        
        // 5. Проверка интерфейсов
        System.out.println("\n=== Проверка интерфейсов ===");
        Runnable runnable = new Thread();
        System.out.println("runnable instanceof Runnable: " + (runnable instanceof Runnable));  // true
        System.out.println("runnable instanceof Thread: " + (runnable instanceof Thread));      // true
        
        // 6. Особый случай: всегда false для несвязанных типов
        System.out.println("\n=== Несвязанные типы ===");
        String str = "test";
        // Ошибка компиляции: несвязанные типы
        // System.out.println(str instanceof Integer);  // Не компилируется
        
        Integer num = 42;
        // Правильная проверка через Object
        Object obj2 = num;
        System.out.println("obj2 instanceof String: " + (obj2 instanceof String));  // false
        System.out.println("obj2 instanceof Integer: " + (obj2 instanceof Integer)); // true
    }
}

// Дополнительный пример с наследованием
class Parent {}
class Child extends Parent {}
class GrandChild extends Child {}

class InstanceofInheritance {
    public static void main(String[] args) {
        GrandChild gc = new GrandChild();
        
        System.out.println("gc instanceof GrandChild: " + (gc instanceof GrandChild));  // true
        System.out.println("gc instanceof Child: " + (gc instanceof Child));           // true
        System.out.println("gc instanceof Parent: " + (gc instanceof Parent));         // true
        System.out.println("gc instanceof Object: " + (gc instanceof Object));         // true
        
        Parent parent = new Child();
        System.out.println("parent instanceof Child: " + (parent instanceof Child));    // true
        System.out.println("parent instanceof GrandChild: " + (parent instanceof GrandChild));  // false
    }
}
