/**
 * @author zinov
 */
public class InterfaceDemo {
    
    // Практика #1-4: область видимости интерфейсов
    
    interface PackagePrivateInterface { // default (package-private)
        void method();
    }
    
    public interface PublicInterface { // public
        void method();
    }
    
    // protected interface ProtectedInterface { // ERROR: нельзя protected
    //     void method();
    // }
    
    // private interface PrivateInterface { // ERROR: нельзя private
    //     void method();
    // }
    
    public static void main(String[] args) {
        System.out.println("=== Практика #1 ===");
        System.out.println("interface Interface - default (package-private)");
        System.out.println("Виден только в том же пакете");
        
        System.out.println("\n=== Практика #2 ===");
        System.out.println("public interface Interface - public");
        System.out.println("Виден везде");
        
        System.out.println("\n=== Практика #3 ===");
        System.out.println("protected interface Interface - ОШИБКА КОМПИЛЯЦИИ");
        System.out.println("Интерфейсы не могут быть protected");
        
        System.out.println("\n=== Практика #4 ===");
        System.out.println("private interface Interface - ОШИБКА КОМПИЛЯЦИИ");
        System.out.println("Интерфейсы не могут быть private");
        
        System.out.println("\n=== Правила ===");
        System.out.println("Интерфейсы могут быть только public или default");
        System.out.println("Все методы в интерфейсе - public abstract");
        System.out.println("Все поля - public static final");
    }
}
