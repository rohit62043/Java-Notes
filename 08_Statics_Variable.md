# Static Keyword in Java

## Introduction

- **Static Keyword**: Used to define class members that are common to all instances of a class.
- **Common Use Cases**: Static variables, static methods.

## Example: Mobile Phone Class

### Class Definition

- **Instance Variables**: Variables specific to each object instance.
  ```java
  class Mobile {
      String brand;
      int price;
      String name;
  }
  ```

## Creating Objects

- Creating and Setting Values:

```java
Mobile obj1 = new Mobile();
obj1.brand = "Apple";
obj1.price = 1500;
obj1.name = "SmartPhone";

Mobile obj2 = new Mobile();
obj2.brand = "Samsung";
obj2.price = 1700;
obj2.name = "SmartPhone";
```

## Display Method

- Method to Display Object Values:

```java
public void show() {
    System.out.println("Brand: " + brand);
    System.out.println("Price: " + price);
    System.out.println("Name: " + name);
}

// Calling the method
obj1.show();
obj2.show();
```

## Static Variables

- **_Defining a Static Variable:_**

```java
static String name;
```

- **_Effect of Static Variable:_**

  - Shared among all instances of the class.
  - Changing the value through one instance affects all instances.

  ```java
  obj1.name = "Phone";
  // Both obj1.name and obj2.name will now be "Phone"
  ```

## Accessing Static Variables

- Using Class Name:

```java
Mobile.name = "Phone";
```

- Access Warning: It is recommended to access static variables using the class name, not through an instance.

```java
// Warning: The static field Mobile.name should be accessed in a static way
```

## Memory Management

- Instance vs Static Variables:
  - Instance variables: Stored in the heap, specific to each object.
  - Static variables: Stored in a special static memory area, shared by all objects.

## Summary

    - Static Variables: Belong to the class, not individual objects.
    - Usage: Accessed using the class name, shared by all instances.
    - Advantages: Saves memory, ensures consistency across all instances.

## Upcoming Topics

    - Static Methods: How to create and use them.
    - Instance Variables in Static Methods: Whether and how they can be used.
    - Example Code

```java
class Mobile {
    String brand;
    int price;
    static String name;

    public void show() {
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        Mobile obj1 = new Mobile();
        obj1.brand = "Apple";
        obj1.price = 1500;
        Mobile.name = "SmartPhone";

        Mobile obj2 = new Mobile();
        obj2.brand = "Samsung";
        obj2.price = 1700;

        obj1.show();
        obj2.show();

        obj1.name = "Phone";

        obj1.show();
        obj2.show();
    }
}
```
