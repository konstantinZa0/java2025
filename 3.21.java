/**
 * Практика по спецификатору static
 * 
 * @author zinov
 */
public class StaticDemo {
    public static void main(String[] args) {
        System.out.println("=== Все варианты вызова статического метода printVars() ===");
        
        // Вариант 1: Через имя класса (рекомендуемый способ)
        System.out.println("1. Через имя класса:");
        A.printVars();
        
        // Вариант 2: Через объект класса (не рекомендуется, но работает)
        System.out.println("\n2. Через объект класса:");
        A obj1 = new A();
        obj1.printVars();
        
        // Вариант 3: Через null-ссылку (работает, т.к. метод статический)
        System.out.println("\n3. Через null-ссылку:");
        A obj2 = null;
        obj2.printVars(); // Не вызовет NullPointerException!
        
        // Вариант 4: Из другого статического метода того же класса
        System.out.println("\n4. Из другого статического метода класса A:");
        A.callPrintVars();
        
        // Вариант 5: Из нестатического метода того же класса
        System.out.println("\n5. Из нестатического метода класса A:");
        A obj3 = new A();
        obj3.nonStaticCall();
        
        // Вариант 6: Из наследника
        System.out.println("\n6. Из наследника класса A:");
        B.callParentStatic();
        
        // Вариант 7: Из другого класса в том же файле
        System.out.println("\n7. Из другого класса:");
        AnotherClass.callStaticMethod();
        
        System.out.println("\n=== Демонстрация статических полей ===");
        
        // Изменение статического поля видно всем
        A objA1 = new A();
        A objA2 = new A();
        
        System.out.println("До изменения:");
        System.out.println("objA1.a = " + objA1.a);
        System.out.println("objA2.a = " + objA2.a);
        System.out.println("A.a = " + A.a);
        
        A.a = 100; // Изменяем через класс
        
        System.out.println("\nПосле изменения A.a = 100:");
        System.out.println("objA1.a = " + objA1.a); // 100
        System.out.println("objA2.a = " + objA2.a); // 100
        System.out.println("A.a = " + A.a);         // 100
        
        objA1.a = 200; // Изменяем через объект
        
        System.out.println("\nПосле изменения objA1.a = 200:");
        System.out.println("objA1.a = " + objA1.a); // 200
        System.out.println("objA2.a = " + objA2.a); // 200 (видно всем!)
        System.out.println("A.a = " + A.a);         // 200
    }
}

class A {
    public static int a = 1;
    public static int b;
    
    public static void printVars() {
        System.out.println("   a = " + a + ", b = " + b);
    }
    
    // Вариант 4: Вызов из другого статического метода
    public static void callPrintVars() {
        printVars(); // Прямой вызов без указания класса
    }
    
    // Вариант 5: Вызов из нестатического метода
    public void nonStaticCall() {
        printVars(); // Прямой вызов
        // или
        A.printVars(); // Через имя класса
        // или
        this.printVars(); // Через this (не рекомендуется)
    }
}

// Вариант 6: Наследник
class B extends A {
    public static void callParentStatic() {
        A.printVars(); // Через имя родительского класса
        // или
        printVars();   // Прямой вызов (унаследован)
        // или
        B.printVars(); // Через имя наследника
    }
}

// Вариант 7: Другой класс
class AnotherClass {
    public static void callStaticMethod() {
        A.printVars(); // Через полное имя класса
    }
}
