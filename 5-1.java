/**
 * @author zinov
 */
public class InnerClassesDemo {
    
    // Практика #1: спецификаторы доступа
    public class PublicInner {}
    protected class ProtectedInner {}
    class PackagePrivateInner {} // default
    private class PrivateInner {}
    
    // Практика #2: доступ внутреннего класса к внешнему
    class Outer {
        private String privateField = "private";
        String defaultField = "default";
        protected String protectedField = "protected";
        public String publicField = "public";
        
        class Inner {
            void accessOuter() {
                // Внутренний класс имеет доступ ко всем полям внешнего
                System.out.println(privateField);
                System.out.println(defaultField);
                System.out.println(protectedField);
                System.out.println(publicField);
            }
        }
    }
    
    // Практика #3: доступ внешнего класса к внутреннему
    class Outer2 {
        // Внешний класс может создать экземпляр внутреннего
        // и обращаться к его членам согласно спецификаторам доступа
        
        class Inner2 {
            private String privateInnerField = "inner private";
            String defaultInnerField = "inner default";
            
            private void privateMethod() {
                System.out.println("Inner private");
            }
            
            void defaultMethod() {
                System.out.println("Inner default");
            }
        }
        
        void testAccess() {
            Inner2 inner = new Inner2();
            
            // System.out.println(inner.privateInnerField); // ERROR: private
            System.out.println(inner.defaultInnerField); // OK: default
            
            // inner.privateMethod(); // ERROR: private
            inner.defaultMethod(); // OK: default
        }
    }
    
    // Статический вложенный класс
    static class StaticNested {
        // Не имеет доступа к нестатическим полям внешнего класса
    }
    
    public static void main(String[] args) {
        System.out.println("=== Практика #1 ===");
        System.out.println("Внутренние классы могут иметь все спецификаторы доступа:");
        System.out.println("public - доступен везде");
        System.out.println("protected - в пакете + наследникам");
        System.out.println("default - только в пакете");
        System.out.println("private - только во внешнем классе");
        
        System.out.println("\n=== Практика #2 ===");
        System.out.println("Внутренний класс имеет доступ ко ВСЕМ полям внешнего класса,");
        System.out.println("включая private, независимо от спецификаторов доступа");
        
        System.out.println("\n=== Практика #3 ===");
        System.out.println("Внешний класс имеет доступ к внутреннему согласно");
        System.out.println("спецификаторам доступа внутреннего класса");
        System.out.println("private - только внутри внутреннего класса");
        System.out.println("default - доступен во внешнем классе");
    }
}
