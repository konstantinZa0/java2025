/**
 * @author zinov
 */
import java.io.*;
import java.util.Arrays;

public class StreamsDemo {
    
    // Практика #1: InputStream.read()
    public static void demonstrateInputStream() throws IOException {
        System.out.println("=== Практика #1: InputStream.read() ===");
        
        // Создаем строку и преобразуем в байты
        String data = "Hello";
        byte[] bytes = data.getBytes();
        
        // ByteArrayInputStream - подкласс InputStream
        InputStream input = new ByteArrayInputStream(bytes);
        
        int byteRead;
        System.out.print("Прочитанные байты: ");
        while ((byteRead = input.read()) != -1) {
            System.out.print(byteRead + " ");
        }
        System.out.println();
        input.close();
    }
    
    // Практика #2: OutputStream.write(int)
    public static void demonstrateOutputStream() throws IOException {
        System.out.println("\n=== Практика #2: OutputStream.write(int) ===");
        
        // ByteArrayOutputStream - подкласс OutputStream
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        // Запись байтов по одному
        output.write(72);  // H
        output.write(101); // e
        output.write(108); // l
        output.write(108); // l
        output.write(111); // o
        
        System.out.println("Записано: " + output.toString());
        output.close();
    }
    
    // Практика #3: Зачем Reader/Writer?
    public static void explainReaderWriter() {
        System.out.println("\n=== Практика #3 ===");
        System.out.println("InputStream/OutputStream работают с байтами");
        System.out.println("Reader/Writer работают с символами (char)");
        System.out.println("Reader/Writer:");
        System.out.println("1. Учитывают кодировку символов");
        System.out.println("2. Работают с Unicode");
        System.out.println("3. Преобразуют байты в символы и обратно");
    }
    
    // Практика #4: AutoCloseable
    public static void demonstrateAutoCloseable() {
        System.out.println("\n=== Практика #4: AutoCloseable ===");
        
        // try-with-resources автоматически закрывает ресурсы
        try (FileWriter writer = new FileWriter("test.txt")) {
            writer.write("Пример с AutoCloseable");
            System.out.println("Файл записан");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        // writer.close() вызывается автоматически
    }
    
    public static void main(String[] args) throws IOException {
        demonstrateInputStream();
        demonstrateOutputStream();
        explainReaderWriter();
        demonstrateAutoCloseable();
    }
}
