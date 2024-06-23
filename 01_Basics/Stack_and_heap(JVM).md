# Understanding the JVM (Java Virtual Machine)

## Overview

The JVM (Java Virtual Machine) is a crucial component of the Java Runtime Environment (JRE) and the Java Development Kit (JDK). It is responsible for executing Java code and managing memory. This guide provides a detailed overview of the JVM, focusing on memory management and variable handling.

## JVM Structure

### 1. JRE and JDK

- **JRE (Java Runtime Environment)**: Contains libraries and other files that JVM uses at runtime.
- **JDK (Java Development Kit)**: Includes JRE and development tools like compilers and debuggers.

### 2. JVM

- The JVM executes Java code and manages the memory.

## Memory Management

The JVM memory is divided into two main areas:

1. **Stack Memory**
2. **Heap Memory**

### Stack Memory

- **Characteristics**: Last In, First Out (LIFO) structure.
- **Purpose**: Stores local variables and function call data.
- **Example**:
  - When variables `n1` and `n2` are created inside a method, they are stored in the stack.
  - Each method call creates a new stack frame.

### Heap Memory

- **Characteristics**: Dynamically allocated memory.
- **Purpose**: Stores objects and instance variables.
- **Example**:
  - When an object is created using `new`, it is stored in the heap.
  - Instance variables of the object are stored within the object in the heap.

## Types of Variables

### 1. Local Variables

- Declared within methods.
- Stored in the stack.
- Example:
  ```java
  int n1 = 3;
  int n2 = 4;
  ```

### 2. Instance Variables

- Declared in the class but outside any method.
- Stored in the heap.
- Example:
  ```java
  class Calculator {
    int num = 5;
    }
  ```

## Example Code Analysis

### Code Setup

- Class and Method Definitions:

```java
public class Calculator {
    int num = 5;

    public int add(int n1, int n2) {
        return n1 + n2;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator obj = new Calculator();
        int result = obj.add(3, 4);
        System.out.println(result);
    }
}
```

## Memory Allocation:

- The main method creates a stack frame.
- obj is a reference variable stored in the stack.
- The actual Calculator object is stored in the heap.
- The add method creates another stack frame when called.

## Memory Representation

### 1. Stack Memory:

- Each method has its own stack frame.
  Local variables (n1, n2, result) are stored in these stack frames.

## 2. Heap Memory:

- Objects and instance variables are stored in the heap.
  Calculator object with num variable is stored in the heap.
  Variable Usage
  Accessing Instance Variables:

- Instance variables can be accessed using the object reference.
  Example:

```java
obj.num = 8;
```

### Multiple Objects:

- Multiple objects have their own copies of instance variables.
  Changing an instance variable in one object does not affect another object.
- Example:

```java
Calculator obj1 = new Calculator();
obj.num = 8;
System.out.println(obj.num);   // Outputs: 8
System.out.println(obj1.num);  // Outputs: 5
```

## Execution Flow

### Method Calls:

- Method calls are managed through the stack.
  When main calls add, a new stack frame is created for add.
  After add completes, the stack frame is removed.

### Object References:

- Objects are referenced using addresses stored in the stack.
- Example: obj might store the address 101, pointing to the Calculator object in the heap.

## Summary

- The JVM uses stack memory for local variables and method calls.
  The heap is used for objects and instance variables.
- Local variables are method-specific, while instance variables are object-specific.
- Understanding JVM memory management is crucial for efficient Java programming and debugging.
