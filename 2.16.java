public class Narrowing {
    public static void main(String[] args) {
        double d = 123.456;
        int i = (int) d;       // 123 (дробная часть отбрасывается)
        byte b = (byte) 300;   // 44 (300 - 256 = 44 из-за переполнения)
        char c = (char) 65;    // 'A' (ASCII код)
        
        System.out.println("double to int: " + i);
        System.out.println("300 to byte: " + b);
        System.out.println("65 to char: " + c);
    }
}