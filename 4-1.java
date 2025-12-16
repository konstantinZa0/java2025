/**
 * @author zinov
 */
public class InheritanceDemo {
    
    // Практика #1: this и super
    class Parent {
        String name = "Parent";
        
        void print() {
            System.out.println("Parent print");
        }
        
        void show() {
            System.out.println("Parent show");
        }
    }
    
    class Child extends Parent {
        String name = "Child"; // Сокрытие поля
        
        // this - ссылка на текущий объект
        // super - ссылка на родительскую часть объекта
        
        void print() {
            System.out.println("Child print");
        }
        
        void demo() {
            print();          // Child.print() - текущий класс
            this.print();     // Child.print() - явно через this
            super.print();    // Parent.print() - родительский метод
            
            System.out.println(name);      // "Child" - поле текущего класса
            System.out.println(this.name); // "Child" - через this
            System.out.println(super.name);// "Parent" - поле родителя
            
            show();           // Parent.show() - унаследованный метод
            this.show();      // Parent.show()
            super.show();     // Parent.show()
        }
        
        // Вызов конструктора родителя
        Child() {
            super(); // Должен быть первой строкой
            // Дополнительная инициализация
        }
    }
    
    // Практика #2: спецификаторы доступа при наследовании
    class A {
        int a1;             // default (package-private)
        public int a2;      // public
        protected int a3;   // protected
        private int a4;     // private
        
        void method1() { }           // default
        public void method2() { }    // public
        protected void method3() { } // protected
        private void method4() { }   // private
    }
    
    class B extends A {
        void test() {
            a1 = 1;    // OK: default доступен в том же пакете
            a2 = 2;    // OK: public доступен везде
            a3 = 3;    // OK: protected доступен наследникам
            // a4 = 4; // ERROR: private недоступен
            
            method1(); // OK: default
            method2(); // OK: public
            method3(); // OK: protected
            // method4(); // ERROR: private
        }
    }
