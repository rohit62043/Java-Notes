# Static Variables, Methods, and Blocks in Java

## Static Variables

- **Definition**: Belongs to the class, not instances.
- **Initialization**: Can be initialized inside the constructor, but this initializes it every time an object is created.
- **Optimization**: Use static block for initializing static variables only once.

## Static Methods

- **Definition**: Belongs to the class, not instances.
- **Access**: Can be called directly using the class name.
- **Instance Variables in Static Methods**:
  - Cannot be accessed directly.
  - Can be accessed by passing the object reference.

## Static Block

- **Purpose**: Used to initialize static variables.
- **Execution**: Runs only once when the class is loaded, irrespective of the number of objects created.
- **Syntax**:
  ```java
  static {
      // initialization code
  }
  ```

## Example Code

```java
class Mobile {
    String brand;
    int price;
    static String name;

    static {
        System.out.println("In static block");
        name = "Phone";
    }

    public Mobile() {
        System.out.println("In constructor");
        this.brand = "";
        this.price = 200;
    }

    public static void show1(Mobile obj) {
        System.out.println(obj.brand);
        System.out.println(obj.price);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // Forcing class loading without creating an object
        Class.forName("Mobile");

        Mobile obj1 = new Mobile();
        Mobile.show1(obj1);

        Mobile obj2 = new Mobile();
        Mobile.show1(obj2);
    }
}
```

## Key Points

- Static Variables: Initialized once using a static block, shared across all instances.
- Static Methods: Accessed using class name, cannot access instance variables directly.
- Static Block: Initializes static variables, runs once when the class is loaded.
- Class Loading: Can be forced using Class.forName("ClassName").

## Summary

- Static Keyword: Indicates class-level methods and variables.
- Static Block: Ensures static variables are initialized once.
- Initialization: Static block runs before any object is created, ensuring proper initialization.

## Usage Scenario

- Practical Use: Common in JDBC when loading drivers.
- Optimization: Avoid redundant initialization, saving memory and processing time.
