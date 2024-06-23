## Overloading the main Method in Java

- In Java, the main method can be overloaded just like any other method. Overloading refers to defining multiple methods with the same name but with different parameter lists. However, only the standard public static void main(String[] args) method is recognized as the entry point of a Java program by the JVM. Other overloaded main methods can be defined, but they won't be invoked automatically when the program is run.

- Here's an example demonstrating overloading of the main method:

```java
public class Main {

    // Overloaded main method with no parameters
    public static void main() {
        System.out.println("This is the overloaded main method with no parameters.");
    }

    // Overloaded main method with an int parameter
    public static void main(int num) {
        System.out.println("This is the overloaded main method with an int parameter: " + num);
    }

    // Standard main method with String array parameter
    public static void main(String[] args) {
        System.out.println("This is the standard main method with String array parameter.");
        for (String arg : args) {
            System.out.println("Argument: " + arg);
        }
    }

    public static void main(String args) {
        System.out.println("This is another overloaded main method with a single String parameter: " + args);
    }

    public static void main(String arg1, String arg2) {
        System.out.println("This is another overloaded main method with two String parameters: " + arg1 + ", " + arg2);
    }
}
```

- In this example:

- The standard public static void main(String[] args) method is provided, which is the entry point of the Java program.
- Additional overloaded main methods are defined with different parameter lists, such as:
  - main() with no parameters.
  - main(int num) with an int parameter.
  - main(String args) with a single String parameter.
  - main(String arg1, String arg2) with two String parameters.
- However, when you run the program, only the standard main method with the String[] args parameter will be invoked by the JVM. The other overloaded main methods need to be called explicitly from within the program.
