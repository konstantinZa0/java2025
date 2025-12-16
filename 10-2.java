/**
 * @author zinov
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerDemo {
    
    public static void main(String[] args) {
        
        System.out.println("=== Практика #1: чтение из файла ===");
        
        try {
            // Создаем Scanner для чтения из файла
            Scanner fileScanner = new Scanner(new File("input.txt"));
            
            System.out.println("Содержимое файла:");
            
            // Чтение построчно
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            
            // Альтернатива: чтение слов
            // while (fileScanner.hasNext()) {
            //     String word = fileScanner.next();
            //     System.out.println(word);
            // }
            
            fileScanner.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
        
        // Дополнительный пример: чтение разных типов данных
        System.out.println("\n=== Пример с разными типами данных ===");
        
        String data = "Иван 25 85.5 true";
        Scanner dataScanner = new Scanner(data);
        
        String name = dataScanner.next();
        int age = dataScanner.nextInt();
        double score = dataScanner.nextDouble();
        boolean active = dataScanner.nextBoolean();
        
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Балл: " + score);
        System.out.println("Активен: " + active);
        
        dataScanner.close();
    }
}
