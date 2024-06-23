# Understanding Anonymous Objects in Java

## 1. Object Creation in Java

- When creating objects in Java, typically, you declare a reference variable and then assign a new instance of the class to that variable.
- Example:
  ```java
  MyClass obj = new MyClass();
  ```

## 2. Introduction to Anonymous Objects

- Anonymous objects are objects that are created without assigning them to a reference variable.
- They are created directly at the point of use and are not stored in memory for later use.
- Example:

```java
new MyClass();
```

## 3. Difference Between Normal and Anonymous Objects

- Normal objects are created by declaring a reference variable and then assigning a new instance to it.
- Anonymous objects are created directly without assigning them to a reference variable.
- Example:

```java
// Normal Object Creation
MyClass obj = new MyClass();

// Anonymous Object Creation
new MyClass();
```

## 4. Object Creation Steps

- Object creation involves two steps: reference creation and object creation.
- Reference creation involves declaring a reference variable.
- Object creation involves using the 'new' keyword followed by the class name to create a new instance.
- Example:

```java
// Reference Creation
MyClass obj;

// Object Creation
obj = new MyClass();
```

- 5. Usage of Anonymous Objects
     Anonymous objects are useful when you need to perform a single operation or method call.
- They are not reusable and are discarded after the method call.
- Example:

```java
// Usage of Anonymous Object
new MyClass().show();
```

## 6. Limitations of Anonymous Objects

- Anonymous objects cannot be reused once created.
- Each time 'new' is used, a new object is created in memory.
- Example:

```java
// Multiple Anonymous Object Creation
new MyClass().show(); // Creates and uses one anonymous object
new MyClass().show(); // Creates and uses another anonymous object
```

Anonymous objects in Java are helpful for performing single, isolated tasks without the need for storing object references. However, they should be used judiciously due to their limited reusability and potential memory overhead.
