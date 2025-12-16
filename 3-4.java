/**
 * @author zinov
 */
public class A {
    // Первый нестатический блок
    {
        System.out.println("logic (1) id= " + this.id); // id еще не инициализирован = 0
    }

    // Статический блок
    static {
        System.out.println("static logic"); // Выполняется первым при загрузке класса
    }

    private int id = 1; // Инициализация поля

    public A(int id) {
        this.id = id; // Присваивание нового значения
        System.out.println("ctor id= " + id);
    }

    // Второй нестатический блок
    {
        System.out.println("logic (2) id= " + id); // id уже = 1 после инициализации
    }
}

public class Main {
    public static void main(String[] args) {
        new A(100); // Создание объекта
    }
}
