/**
 * @author zinov
 */
public class VarargsDemo {
    
    // Перегруженные методы с varargs
    
    // 1. Метод без параметров
    public static void printValues() {
        System.out.println("Нет значений");
    }
    
    // 2. Метод с одним параметром
    public static void printValues(int a) {
        System.out.println("Одно значение: " + a);
    }
    
    // 3. Метод с двумя параметрами  
    public static void printValues(int a, int b) {
        System.out.println("Два значения: " + a + ", " + b);
    }
    
    // 4. Метод с varargs
    public static void printValues(int... values) {
        System.out.print("Varargs: ");
        for (int val : values) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    // 5. Другой тип varargs
    public static void printValues(String... strings) {
        System.out.print("Строки: ");
        for (String str : strings) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
    
    // 6. Смешанные параметры + varargs
    public static void printValues(String prefix, int... values) {
        System.out.print(prefix + ": ");
        for (int val : values) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        printValues();              // Нет значений
        printValues(1);             // Одно значение: 1
        printValues(1, 2);          // Два значения: 1, 2
        printValues(1, 2, 3);       // Varargs: 1 2 3
        printValues(1, 2, 3, 4);    // Varargs: 1 2 3 4
        printValues("A", "B", "C"); // Строки: A B C
        printValues("Числа", 5, 6, 7); // Числа: 5 6 7
    }
}
