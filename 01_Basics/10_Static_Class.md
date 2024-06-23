# Can a Class be Static in Java?

## Static Nested Classes

- **Definition**: In Java, a class can be made static only if it is a nested class.
- **Static Nested Class**: A static nested class is a static member of the outer class.

## Characteristics of Static Nested Classes

- **Access to Outer Class**: Can access static members of the outer class, but not non-static members directly.
- **Creation**: No need for an instance of the outer class to create an instance of the static nested class.

## Syntax

```java
class OuterClass {
    static class StaticNestedClass {
        // members of the static nested class
    }
}
```

## Example

```java
class OuterClass {
    static String staticOuterVariable = "Static Variable";

    static class StaticNestedClass {
        void display() {
            System.out.println("Static Nested Class");
            System.out.println("Accessing: " + staticOuterVariable);
        }
    }

    public static void main(String[] args) {
        OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
        nestedObject.display();
    }
}
```

## Key Points

- Static Members: Can access static members of the outer class.
- Instantiation: Does not require an instance of the outer class.
- Usage: Useful for logically grouping classes that are only used in one place, improving encapsulation.

## Summary

- A class itself cannot be declared static unless it is a nested class.(i.e outer class can't be static)
- Static nested classes are a feature in Java that allows better organization and encapsulation of code.
