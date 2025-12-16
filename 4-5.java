/**
 * @author zinov
 */
public class StaticMethodDemo {
    
    class A {
        public static void method() {
            System.out.println("A.method()");
        }
    }
    
    class B extends A {
        // Это не переопределение, а сокрытие (hiding)
        public static void method() {
            System.out.println("B.method()");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Практика #1 ===");
        System.out.println("Динамический полиморфизм не работает со статическими методами,");
        System.out.println("потому что статические методы связываются на этапе компиляции,");
        System.out.println("а не на этапе выполнения (статическое связывание).");
        
        A obj1 = new A();
        A obj2 = new B();
        
        obj1.method(); // A.method() - вызов по типу ссылки A
        obj2.method(); // A.method() - а не B.method()! Вызов по типу ссылки, а не объекта
        B.method();    // B.method() - только при явном вызове через класс B
    }
}
