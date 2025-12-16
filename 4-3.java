/**
 * @author zinov
 */
public class SuperThisDemo {
    
    // Практика #1: три варианта super
    class Parent {
        String field = "Parent field";
        
        Parent() {
            System.out.println("Parent constructor");
        }
        
        void method() {
            System.out.println("Parent method");
        }
    }
    
    class Child extends Parent {
        String field = "Child field";
        
        Child() {
            super(); // 1. Вызов конструктора родителя
        }
        
        void demo() {
            System.out.println(super.field); // 2. Доступ к полю родителя
            super.method(); // 3. Вызов метода родителя
        }
    }
    
    // Практика #2
    class A {
        int a = 10;
        void method() {
            System.out.println("A.method()");
        }
    }
    
    class B extends A {
        // Нет своих полей a и method()
    }
    
    class C extends B {
        void method() {
            int a = super.a; // Обращение к A.a (через B)
            super.method();  // Вызов A.method() (через B)
            System.out.println("a = " + a);
        }
    }
    
    // Практика #3: this() для цепочки конструкторов
    class A2 {
        int a;
        int b;
        int c;
        int z;
        
        public A2() {
            this(0, 0, 0); // Вызов конструктора с 3 параметрами
        }
        
        public A2(int a) {
            this(a, 0, 0); // Вызов конструктора с 3 параметрами
        }
        
        public A2(int a, int b) {
            this(a, b, 0); // Вызов конструктора с 3 параметрами
        }
        
        public A2(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
            z = 1;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Практика #1 ===");
        System.out.println("super используется для:");
        System.out.println("1. super() - вызов конструктора родителя");
        System.out.println("2. super.field - доступ к полю родителя");
        System.out.println("3. super.method() - вызов метода родителя");
        
        System.out.println("\n=== Практика #2 ===");
        System.out.println("Если в B нет поля a и метода method(),");
        System.out.println("то super.a и super.method() обратятся к A");
        
        System.out.println("\n=== Практика #3 ===");
        System.out.println("this() вызывает другой конструктор этого же класса");
        System.out.println("Должен быть первой строкой в конструкторе");
    }
}
