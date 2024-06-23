## Access Modifiers in Java

In Java, access modifiers control the visibility and accessibility of classes, methods, and variables. There are four main access modifiers: `public`, `private`, `protected`, and `default`. Understanding how each works is crucial for encapsulation and security in Java programming.

### Public Access Modifier

- **Visibility:** Accessible from anywhere.
- **Usage:** Commonly used for methods and classes that need to be accessible across different packages.

**Example:**

```java
public class A {
    public int marks = 10;

    public void display() {
        System.out.println("Marks: " + marks);
    }
}
```

### Accessing Public Members:

```java
public class Demo {
    public static void main(String[] args) {
        A obj = new A();
        System.out.println(obj.marks); // Accessible
        obj.display(); // Accessible
    }
}
```

### Private Access Modifier

- Visibility: Accessible only within the same class.
- Usage: Commonly used for instance variables to achieve encapsulation.
  **Example:**

```java
public class B {
    private int marks = 10;

    private void display() {
        System.out.println("Marks: " + marks);
    }
}
```

### Accessing Private Members:

```java
public class Demo {
    public static void main(String[] args) {
        B obj = new B();
        // System.out.println(obj.marks); // Not accessible
        // obj.display(); // Not accessible
    }
}
```

### Protected Access Modifier

- Visibility: Accessible within the same package and subclasses in other packages.
- Usage: Used when the members need to be accessed by subclasses.

**_Example:_**

```java
package other;

public class C {
    protected int marks = 10;

    protected void display() {
        System.out.println("Marks: " + marks);
    }
}
```

### Accessing Protected Members:

```java
package demo;

import other.C;

public class D extends C {
    public static void main(String[] args) {
        D obj = new D();
        System.out.println(obj.marks); // Accessible
        obj.display(); // Accessible
    }
}
```

### Default Access Modifier

- Visibility: Accessible only within the same package.
- Usage: When no access modifier is specified, the default access is applied.
  **_Example:_**

```java
class E {
    int marks = 10;

    void display() {
        System.out.println("Marks: " + marks);
    }
}
```

### Accessing Default Members:

```java

public class Demo {
    public static void main(String[] args) {
        E obj = new E();
        System.out.println(obj.marks); // Accessible within the same package
        obj.display(); // Accessible within the same package
    }
}
```

## Summary of Access Modifiers

- Modifier Class Package Subclass World
- public Yes Yes Yes Yes
- protected Yes Yes Yes No
- default Yes Yes No No
- private Yes No No No

### Best Practices

- Public Classes: Make classes public if they need to be accessed from other packages.
- Private Variables: Keep instance variables private to achieve encapsulation.
- Public Methods: Make methods public if they need to be accessed from other classes.
- Protected Members: Use protected for members that should be accessible in subclasses.
- Avoid Default: Avoid using default access unless you specifically need package-level access.

Understanding and using access modifiers effectively helps in designing robust and secure Java applications.
