/**
 * Демонстрация перегрузки и переопределения методов
 * 
 * @author zinov
 */
public class MethodsDemo {
    public static void main(String[] args) {
        System.out.println("=== Перегрузка методов (overloading) ===");
        Calculator calc = new Calculator();
        
        System.out.println("calc.add(5, 3) = " + calc.add(5, 3));
        System.out.println("calc.add(5.5, 3.2) = " + calc.add(5.5, 3.2));
        System.out.println("calc.add(5, 3, 2) = " + calc.add(5, 3, 2));
        System.out.println("calc.add(\"Hello\", \"World\") = " + calc.add("Hello", "World"));
        
        System.out.println("\n=== Переопределение методов (overriding) ===");
        
        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();
        
        animal.makeSound();  // Животное издает звук
        dog.makeSound();    
        cat.makeSound();   
        
        // Полиморфизм
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        
        System.out.println("\n=== Полиморфизм ===");
        myDog.makeSound(); 
        myCat.makeSound();  
    }
}

// ========== Пример перегрузки методов ==========
class Calculator {
    
    // Перегрузка: методы с одним именем, но разными параметрами
    
    // 1. Сложение двух целых чисел
    int add(int a, int b) {
        return a + b;
    }
    
    // 2. Сложение двух чисел с плавающей точкой (разные типы параметров)
    double add(double a, double b) {
        return a + b;
    }
    
    // 3. Сложение трех целых чисел (разное количество параметров)
    int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // 4. Конкатенация строк (разные типы параметров)
    String add(String a, String b) {
        return a + b;
    }
    
    // Ошибка компиляции: нельзя перегружать только по возвращаемому типу
    // double add(int a, int b) { // ОШИБКА: уже есть метод с такими параметрами
    //     return (double)(a + b);
    // }
}

// ========== Пример переопределения методов ==========
class Animal {
    public void makeSound() {
        System.out.println("Животное издает звук");
    }
    
    public void eat() {
        System.out.println("Животное ест");
    }
}

class Dog extends Animal {
    // Переопределение метода makeSound()
    @Override
    public void makeSound() {
        System.out.println("Гав-гав!");
    }
    
    // Дополнительный метод, специфичный для Dog
    public void wagTail() {
        System.out.println("Собака виляет хвостом");
    }
}

class Cat extends Animal {
    // Переопределение метода makeSound()
    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }
    
    // Переопределение метода eat() с вызовом родительского метода
    @Override
    public void eat() {
        super.eat(); // вызов метода родительского класса
        System.out.println("Кошка ест рыбу");
    }
}

// ========== Пример с ограничениями ==========
class Parent {
    public void publicMethod() {
        System.out.println("Public method in Parent");
    }
    
    protected void protectedMethod() {
        System.out.println("Protected method in Parent");
    }
    
    private void privateMethod() {
        System.out.println("Private method in Parent");
    }
    
    // final метод нельзя переопределить
    public final void finalMethod() {
        System.out.println("Final method in Parent");
    }
}

class Child extends Parent {
    // OK: переопределение public метода
    @Override
    public void publicMethod() {
        System.out.println("Public method in Child");
    }
    
    // OK: переопределение protected метода (можно сделать public)
    @Override
    public void protectedMethod() {
        System.out.println("Protected method in Child (now public)");
    }
}
