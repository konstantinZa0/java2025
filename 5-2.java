/**
 * @author zinov
 */
public interface InterfaceWithNestedClass {
    
    // Статический вложенный класс в интерфейсе
    public static class NestedClass {
        public void printMessage() {
            System.out.println("Метод вложенного класса в интерфейсе");
        }
        
        public static void staticMethod() {
            System.out.println("Статический метод вложенного класса");
        }
    }
    
    void interfaceMethod(); // метод интерфейса
}

// Использование
class Demo {
    public static void main(String[] args) {
        // Создание экземпляра вложенного класса
        InterfaceWithNestedClass.NestedClass nested = 
            new InterfaceWithNestedClass.NestedClass();
        
        // Вызов метода
        nested.printMessage();
        
        // Вызов статического метода
        InterfaceWithNestedClass.NestedClass.staticMethod();
    }
}
