/**
 * Практика по модификатору final
 * 
 * @author zinov
 */
public class FinalDemo {
    public static void main(String[] args) {
        System.out.println("=== Варианты инициализации final поля ===");
        
        // Вариант 1: Инициализация при объявлении
        A obj1 = new A();
        System.out.println("obj1.a = " + obj1.a);
        
        // Вариант 2: Инициализация в конструкторе
        B obj2 = new B(10);
        System.out.println("obj2.a = " + obj2.a);
        
        B obj3 = new B(20);
        System.out.println("obj3.a = " + obj3.a);
        
        // Вариант 3: Инициализация в блоке инициализации
        C obj4 = new C();
        System.out.println("obj4.a = " + obj4.a);
        
        System.out.println("\n=== Другие примеры использования final ===");
        
        // final класс
        final FinalClass fc = new FinalClass();
        fc.sayHello();
        
        // final локальная переменная
        final int localFinal = 100;
        System.out.println("final локальная переменная: " + localFinal);
        
        // final параметр метода
        printValue(42);
    }
    
    // Метод с final параметром
    public static void printValue(final int value) {
        // value = 50; // Ошибка: нельзя изменить final параметр
        System.out.println("final параметр метода: " + value);
    }
}

// Класс с final полем
class A {
    public final int a = 5; // Вариант 1: инициализация при объявлении
}

class B {
    public final int a;
    
    // Вариант 2: инициализация в конструкторе
    public B(int value) {
        this.a = value; // Можно инициализировать здесь
    }
    
    // Если есть несколько конструкторов, каждый должен инициализировать final поле
    public B() {
        this(0); // Вызов другого конструктора
    }
}

class C {
    public final int a;
    
    // Вариант 3: инициализация в блоке инициализации
    {
        a = 15; // Инициализация в нестатическом блоке
    }
    
    // Конструктор
    public C() {
        // a уже инициализировано в блоке
        // a = 20; // Ошибка: нельзя присвоить второй раз
    }
}

// Вариант 4: Использование статического блока для static final
class D {
    public static final int CONSTANT;
    
    static {
        CONSTANT = 100; // Инициализация в статическом блоке
    }
}

// Вариант 5: lazy-инициализация в методе (с synchronized)
class E {
    private final String data;
    
    public E() {
        this.data = initData(); // Через вызов метода
    }
    
    private String initData() {
        return "Инициализировано в методе";
    }
}

// final класс - нельзя наследовать
final class FinalClass {
    public void sayHello() {
        System.out.println("Hello from final class");
    }
}

// Ошибка: нельзя наследовать final класс
// class ChildClass extends FinalClass { // ОШИБКА КОМПИЛЯЦИИ
// }

class Parent {
    // final метод - нельзя переопределить
    public final void finalMethod() {
        System.out.println("Этот метод нельзя переопределить");
    }
    
    public void normalMethod() {
        System.out.println("Этот метод можно переопределить");
    }
}

class Child extends Parent {
    // @Override
    // public void finalMethod() { // ОШИБКА: нельзя переопределить final метод
    //     System.out.println("Переопределение");
    // }
    
    @Override
    public void normalMethod() { // OK: можно переопределить
        System.out.println("Переопределенный метод");
    }
}
