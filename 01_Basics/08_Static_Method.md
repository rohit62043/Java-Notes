# Static Methods in Java

## Introduction

- **Static Method**: A method that belongs to the class, not instances of the class.
- **Access**: Can be called using the class name without creating an object.

## Instance Method vs Static Method

### Instance Method

- **Example**: `show()` method without static keyword.
- **Usage**: Requires an object to be called.
  ```java
  Mobile obj1 = new Mobile();
  obj1.show();
  ```

## Static Method

- Example: show1() method with static keyword.
- Definition:

```java
public static void show1() {
    System.out.println("In static method");
}
```

## Calling Static Method

- Directly using Class Name:

```java
Mobile.show1();
```

## Using Variables in Static Method

- Static Variables: Can be used directly in static methods.

```java
static String name;
public static void show1() {
    System.out.println(name);
}
```

- Instance Variables: Cannot be used directly in static methods.

- Reason: Static methods do not have access to instance-specific data.
- Solution: Pass the object as a parameter to the static method.

```java
public static void show1(Mobile obj) {
    System.out.println(obj.brand);
    System.out.println(obj.price);
}
```

## Main Method and Static

- Static Main Method:

```java
public static void main(String[] args) {
    // code
}
```

- Reason: The main method is the entry point of the program and needs to be called by the JVM without creating an object.

## Summary

- Static Method: Belongs to the class, can be called using the class name.
- Access: Static methods can access static variables directly but need object reference to access instance variables.
- Main Method: Static to allow the JVM to call it without creating an object.
- Example Code

```java
class Mobile {
    String brand;
    int price;
    static String name;

    public static void show1() {
        System.out.println("In static method");
        System.out.println(name);
    }

    public static void show1(Mobile obj) {
        System.out.println(obj.brand);
        System.out.println(obj.price);
    }

    public static void main(String[] args) {
        Mobile.name = "SmartPhone";

        Mobile obj1 = new Mobile();
        obj1.brand = "Apple";
        obj1.price = 1500;

        Mobile obj2 = new Mobile();
        obj2.brand = "Samsung";
        obj2.price = 1700;

        Mobile.show1();
        Mobile.show1(obj1);
        Mobile.show1(obj2);
    }
}
```

## Next Topic

- Static Block: Concept and usage of static blocks in Java.
