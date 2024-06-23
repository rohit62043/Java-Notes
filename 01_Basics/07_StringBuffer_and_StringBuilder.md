# String Buffer in Java

## Introduction

- **String Buffer**: A class used to create mutable strings. It allows for the modification of strings, unlike the immutable `String` class.
- **Initial Setup**:

```java
  StringBuffer sb = new StringBuffer();
```

## Key Characteristics

- Mutable: The content of a StringBuffer can be changed.
- Buffer Size: By default, a StringBuffer has a buffer size of 16 characters.
- Capacity Management:
  Default capacity is 16 characters.
  If an initial string is provided, the capacity becomes the length of the string plus 16.

```java
StringBuffer sb = new StringBuffer("Navin");
// Capacity becomes 21 (5 characters for "Navin" + 16 additional spaces)
```

## Basic Operations

- Print Capacity:

```java
System.out.println(sb.capacity());
// Prints the capacity of the StringBuffer

```

- Print Length:

```java
System.out.println(sb.length());
// Prints the length of the content in the StringBuffer
```

- Append Data:

```java
sb.append(" Reddy");
// Appends "Reddy" to the existing content
```

- Convert to String:

```java
String str = sb.toString();
// Converts the content of StringBuffer to a String
```

## Advanced Operations

- Delete Character:

```java
sb.deleteCharAt(2);
// Deletes the character at index 2
```

- Insert Data:

```java
sb.insert(0, "Java ");
// Inserts "Java " at the beginning (index 0)
```

- Insert Data at Specific Position:

```java
sb.insert(5, "Java ");
// Inserts "Java " after the 5th character
```

- Set Length:

```java
sb.setLength(30);
// Sets the length of the buffer to 30 characters
```

- Ensure Minimum Capacity:

```java
sb.ensureCapacity(100);
// Ensures that the buffer has a minimum capacity of 100 characters
```

## Methods Overview

- Append: Adds new data to the end of the buffer.
- DeleteCharAt: Removes a character at a specified index.
- Insert: Adds new data at a specified index.
- SetLength: Sets the length of the buffer.
- EnsureCapacity: Ensures the buffer has a specified minimum capacity.

## Difference Between StringBuffer and StringBuilder

**StringBuffer:**

- Thread-safe: Methods are synchronized, making it safe for use in concurrent environments.

**StringBuilder:**

- Not thread-safe: Methods are not synchronized, which makes it faster but unsafe for use in concurrent environments.

### Example Code

```java
public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Navin");
        System.out.println("Capacity: " + sb.capacity()); // 21
        System.out.println("Length: " + sb.length()); // 5

        sb.append(" Reddy");
        System.out.println("Appended: " + sb.toString()); // Navin Reddy

        sb.deleteCharAt(2);
        System.out.println("After Deletion: " + sb.toString()); // Nain Reddy

        sb.insert(5, "Java ");
        System.out.println("After Insertion: " + sb.toString()); // Navin Java Reddy

        sb.setLength(30);
        System.out.println("After Set Length: " + sb.toString()); // Navin Java Reddy (followed by spaces)

        sb.ensureCapacity(100);
        System.out.println("Ensured Capacity: " + sb.capacity()); // 100
    }
}
```

## Summary

- StringBuffer is a versatile and mutable string handler in Java, providing numerous methods to manipulate strings efficiently.
  Key methods include append, delete, insert, set length, and ensure capacity.
- The main difference between StringBuffer and StringBuilder is thread safety, with StringBuffer being thread-safe and StringBuilder not.
