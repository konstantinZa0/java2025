// Файл: com/example/package1/ClassA.java
package com.example.package1;

public class ClassA {
    private String privateField = "private";
    String defaultField = "default (package-private)";
    protected String protectedField = "protected";
    public String publicField = "public";
    
    private void privateMethod() {
        System.out.println("Private method in ClassA");
    }
    
    void defaultMethod() {
        System.out.println("Default method in ClassA");
    }
    
    protected void protectedMethod() {
        System.out.println("Protected method in ClassA");
    }
    
    public void publicMethod() {
        System.out.println("Public method in ClassA");
        privateMethod(); // доступ к private внутри класса
    }
}

// Файл: com/example/package1/ClassB.java
package com.example.package1;

public class ClassB {
    public void testAccess() {
        ClassA obj = new ClassA();
        
        // System.out.println(obj.privateField); // Ошибка: private доступен только внутри ClassA
        System.out.println("ClassB (тот же пакет): " + obj.defaultField);    // OK
        System.out.println("ClassB (тот же пакет): " + obj.protectedField);  // OK
        System.out.println("ClassB (тот же пакет): " + obj.publicField);     // OK
        
        // obj.privateMethod(); // Ошибка
        obj.defaultMethod();    // OK
        obj.protectedMethod();  // OK
        obj.publicMethod();     // OK
    }
}

// Файл: com/example/package2/ClassC.java (другой пакет)
package com.example.package2;

import com.example.package1.ClassA;

public class ClassC extends ClassA {
    public void testAccess() {
        ClassA obj = new ClassA();
        
        // System.out.println(obj.privateField); // Ошибка
        // System.out.println(obj.defaultField); // Ошибка: разные пакеты
        // System.out.println(obj.protectedField); // Ошибка: доступ через объект, а не наследование
        System.out.println("ClassC (другой пакет): " + obj.publicField); // OK
        
        // obj.privateMethod(); // Ошибка
        // obj.defaultMethod(); // Ошибка
        // obj.protectedMethod(); // Ошибка: доступ через объект
        obj.publicMethod(); // OK
        
        // Тест protected через наследование
        System.out.println("\nЧерез наследование:");
        System.out.println("ClassC наследует: " + protectedField); // OK через наследование
        protectedMethod(); // OK через наследование
    }
}

// Файл: com/example/package2/ClassD.java (другой пакет, не наследник)
package com.example.package2;

import com.example.package1.ClassA;

public class ClassD {
    public void testAccess() {
        ClassA obj = new ClassA();
        
        // System.out.println(obj.privateField); // Ошибка
        // System.out.println(obj.defaultField); // Ошибка: разные пакеты
        // System.out.println(obj.protectedField); // Ошибка: не наследник
        System.out.println("ClassD (другой пакет, не наследник): " + obj.publicField); // OK
        
        // obj.privateMethod(); // Ошибка
        // obj.defaultMethod(); // Ошибка
        // obj.protectedMethod(); // Ошибка
        obj.publicMethod(); // OK
    }
}

// Файл: Main.java (для запуска)
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тест спецификаторов доступа ===\n");
        
        System.out.println("1. Тест из того же пакета:");
        com.example.package1.ClassB classB = new com.example.package1.ClassB();
        classB.testAccess();
        
        System.out.println("\n2. Тест из другого пакета (наследник):");
        com.example.package2.ClassC classC = new com.example.package2.ClassC();
        classC.testAccess();
        
        System.out.println("\n3. Тест из другого пакета (не наследник):");
        com.example.package2.ClassD classD = new com.example.package2.ClassD();
        classD.testAccess();
        
        System.out.println("\n=== Сводка по спецификаторам ===");
        System.out.println("private: доступен только внутри своего класса");
        System.out.println("default (без спецификатора): доступен в том же пакете");
        System.out.println("protected: доступен в том же пакете + наследникам в других пакетах");
        System.out.println("public: доступен везде");
    }
}
