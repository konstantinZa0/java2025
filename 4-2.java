/**
 * @author zinov
 */
public class FinalInheritanceDemo {
    
    // Практика #1: final метод нельзя переопределить
    class Parent {
        public final void finalMethod() {
            System.out.println("Этот метод final");
        }
        
        public void normalMethod() {
            System.out.println("Этот метод можно переопределить");
        }
    }
    
    class Child extends Parent {
        // Ошибка компиляции: нельзя переопределить final метод
        // @Override
        // public void finalMethod() {
        //     System.out.println("Попытка переопределения");
        // }
        
        @Override
        public void normalMethod() { // OK
            System.out.println("Переопределенный метод");
        }
    }
    
    // Практика #2: final класс нельзя наследовать
    final class FinalClass {
        public void method() {
            System.out.println("Метод final класса");
        }
    }
    
    // Ошибка компиляции: нельзя наследовать final класс
    // class SubClass extends FinalClass {
    //     // Cannot inherit from final FinalClass
    // }
    
    public static void main(String[] args) {
        System.out.println("=== Практика #1 ===");
        System.out.println("final методы нельзя переопределять в подклассах");
        System.out.println("При попытке компилятор выдаст ошибку");
        
        System.out.println("\n=== Практика #2 ===");
        System.out.println("final классы нельзя наследовать");
        System.out.println("При попытке компилятор выдаст ошибку");
    }
}
