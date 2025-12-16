/**
 * @author zinov
 */
public class CustomExceptionDemo {
    
    // Практика #1: собственный класс исключения
    static class InvalidAgeException extends Exception {
        
        // Конструктор 1: по умолчанию
        public InvalidAgeException() {
            super("Некорректный возраст");
        }
        
        // Конструктор 2: с сообщением
        public InvalidAgeException(String message) {
            super(message);
        }
        
        // Конструктор 3: с сообщением и причиной
        public InvalidAgeException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
    // Пример использования
    static class Person {
        private String name;
        private int age;
        
        public Person(String name, int age) throws InvalidAgeException {
            this.name = name;
            if (age < 0 || age > 150) {
                throw new InvalidAgeException("Возраст должен быть от 0 до 150");
            }
            this.age = age;
        }
        
        public void setAge(int age) throws InvalidAgeException {
            if (age < 0) {
                throw new InvalidAgeException("Возраст не может быть отрицательным");
            }
            this.age = age;
        }
    }
    
    public static void main(String[] args) {
        try {
            Person person = new Person("Иван", -5);
        } catch (InvalidAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        
        try {
            Person person = new Person("Мария", 25);
            person.setAge(200);
        } catch (InvalidAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
