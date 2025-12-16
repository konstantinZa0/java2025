/**
 * @author zinov
 */
public class OverloadingOverridingDemo {
    
    // Практика #1: Перегрузка (overloading)
    class Calculator {
        // Разные параметры, одно имя
        int add(int a, int b) {
            return a + b;
        }
        
        double add(double a, double b) {
            return a + b;
        }
        
        int add(int a, int b, int c) {
            return a + b + c;
        }
    }
    
    // Практика #2: Переопределение (overriding)
    class Animal {
        String sound() {
            return "Some sound";
        }
    }
    
    class Dog extends Animal {
        @Override
        String sound() {
            return "Woof";
        }
        
        // Ошибка компиляции: разные возвращаемые типы
        // @Override
        // int sound() { // Должен быть String
        //     return 5;
        // }
    }
    
    // Практика #3: Польза @Override
    class Parent {
        void method() {
            System.out.println("Parent");
        }
    }
    
    class Child extends Parent {
        // Без @Override - это новый метод (опечатка в имени)
        void metod() { // Ошибка в имени
            System.out.println("Child");
        }
        
        // С @Override - компилятор покажет ошибку
        // @Override
        // void metod() { // Ошибка: метод не переопределяет существующий
        //     System.out.println("Child");
        // }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Практика #1 ===");
        System.out.println("Перегрузка: методы с одним именем, разными параметрами");
        
        System.out.println("\n=== Практика #2 ===");
        System.out.println("Переопределение: метод в наследнике с той же сигнатурой");
        System.out.println("Если возвращаемые типы не совпадают - ошибка компиляции");
        
        System.out.println("\n=== Практика #3 ===");
        System.out.println("@Override помогает обнаружить:");
        System.out.println("1. Опечатки в имени метода");
        System.out.println("2. Несовпадение сигнатур");
        System.out.println("3. Попытку переопределить несуществующий метод");
    }
}
