/**
 * @author zinov
 */
public class A {
    public void printNum(Integer i) {
        System.out.printf("Integer = %d%n", i);
    }
    public void printNum(int i) {
        System.out.printf("int = %d%n", i);
    }
    public void printNum(Float f) {
        System.out.printf("Float = %.4f%n", f);
    }
    public void printNum(Number n) {
        System.out.println("Number=" + n);
    }
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        Number[] num = {new Integer(1), 11, 1.11f, 11.11};
        
        // цикл for (1) - компилятор видит тип Number для n
        for (Number n : num) {
            a.printNum(n); // Всегда printNum(Number n)
        }
        
        // (2) - точные типы известны при компиляции
        a.printNum(new Integer(1)); // printNum(Integer i)
        a.printNum(11);             // printNum(int i) 
        a.printNum(1.11f);          // printNum(Float f)
        a.printNum(11.11);          // printNum(Number n) - Double
    }
}
