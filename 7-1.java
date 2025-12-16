/**
 * @author zinov
 */
public class InterfaceNewFeatures {
    
    // Практика #1: default и static методы
    interface MyInterface {
        // Абстрактный метод
        void abstractMethod();
        
        // default метод (неабстрактный)
        default void defaultMethod() {
            System.out.println("Default method in interface");
        }
        
        // static метод
        static void staticMethod() {
            System.out.println("Static method in interface");
        }
    }
    
    class MyClass implements MyInterface {
        @Override
        public void abstractMethod() {
            System.out.println("Implemented abstract method");
        }
        
        // Можно переопределить default метод
        @Override
        public void defaultMethod() {
            System.out.println("Overridden default method");
        }
    }
    
    // Практика #2: конфликт default методов
    interface InterfaceA {
        default void sameMethod() {
            System.out.println("Method from InterfaceA");
        }
    }
    
    interface InterfaceB {
        default void sameMethod() {
            System.out.println("Method from InterfaceB");
        }
    }
    
    // Ошибка компиляции: конфликт методов
    // class ConflictClass implements InterfaceA, InterfaceB {
    // }
    
    // Решение: явное переопределение
    class SolutionClass implements InterfaceA, InterfaceB {
        @Override
        public void sameMethod() {
            // Выбираем реализацию из InterfaceA
            InterfaceA.super.sameMethod();
            // Или InterfaceB.super.sameMethod();
            // Или своя реализация
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Практика #1 ===");
        System.out.println("Способы вызова методов:");
        System.out.println("1. static метод: MyInterface.staticMethod()");
        System.out.println("2. default метод: через объект класса");
        System.out.println("3. abstract метод: через объект класса");
        
        // Вызов static метода интерфейса
        MyInterface.staticMethod();
        
        System.out.println("\n=== Практика #2 ===");
        System.out.println("При конфликте default методов необходимо");
        System.out.println("явно переопределить метод в классе");
        System.out.println("и указать, какую реализацию использовать");
        System.out.println("через InterfaceName.super.methodName()");
    }
}
