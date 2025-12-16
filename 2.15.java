public class MixedTypes {
    public static void main(String[] args) {
        int a = 10;
        double b = 3.5;
        
        double result1 = a + b;  // int + double = double (13.5)
        float result2 = a * 2.0f; // int * float = float (20.0)
        long result3 = a + 100L; // int + long = long (110)
        
        System.out.println("a + b = " + result1); // 13.5
        System.out.println("a * 2.0f = " + result2); // 20.0
        System.out.println("a + 100L = " + result3); // 110
    }
}