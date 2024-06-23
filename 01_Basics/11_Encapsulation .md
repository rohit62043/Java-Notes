# Encapsulation in Java

## Introduction to Encapsulation

- **Encapsulation**: A core concept in Object-Oriented Programming (OOP) that combines data and methods.
- **Analogy**: Similar to a medicine capsule keeping contents enclosed, encapsulation hides the internal state of an object and only allows access through methods.

## Implementing Encapsulation

### Designing a Class

- Example class: `Human`
- **Instance Variables**: Typically, characteristics like `age` and `name`.

### Example Code

```java
public class Human {
    // Private variables
    private int age;
    private String name;

    // Public getter for age
    public int getAge() {
        return age;
    }

    // Public setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Public getter for name
    public String getName() {
        return name;
    }

    // Public setter for name
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Human obj = new Human();
        obj.setAge(30);
        obj.setName("Reddy");

        System.out.println(obj.getName() + ": " + obj.getAge());
    }
}
```

## Key Concepts

- Private Variables:

  - Declaring instance variables as private restricts direct access from outside the class.
  - Example: private int age; and private String name;

- Public Methods (Getters and Setters):

  - Provide controlled access to private variables.
  - Getter Methods: Allow read-only access.
  - Example: public int getAge() { return age; }
  - Setter Methods: Allow write access.
  - Example: public void setAge(int age) { this.age = age; }

- Why Use Getters and Setters?:

  - Control Access: Control who can read/write the data.
  - Validation: Add validation logic inside setters.
  - Encapsulation: Enclose the data and methods within the class, hiding the internal implementation.

## Benefits of Encapsulation

- Improved Security: Sensitive data is protected from unauthorized access.
- Controlled Access: Public methods provide controlled ways to access and modify the data.
- Maintainability: Easier to manage and modify code.

## Practical Usage

- Default Values: Initialize variables with default values in constructors if needed.
- Indirect Access: Access and modify variables only through getter and setter methods.
- Example of Using Default Values

```java
public Human() {
    this.age = 0;  // default age
    this.name = "";  // default name
}
```

## Summary

- Encapsulation binds data (variables) and code (methods) together.
- Private Variables protect the data.
- Public Methods (getters and setters) provide controlled access.
- Encapsulation ensures that the internal representation of an object is hidden from the outside.

Next Steps
Understanding the naming conventions and more advanced uses of getter and setter methods.
