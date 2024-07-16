# Implementing Dependency Injection in Spring

In this tutorial, we'll explore how to implement dependency injection using Spring, starting with a Spring Boot application and transitioning to understand the Spring framework's underlying mechanisms.

## Setting Up with Java 21

To ensure compatibility, we've upgraded to Java 21 for our application setup and execution.

## Introduction to Dependency Injection

Dependency Injection (DI) allows us to delegate the creation and management of objects (beans) to a container, facilitating loose coupling and easier testing.

- Alien.java

```java
package com.telusko.app;

import org.springframework.stereotype.Component;

@Component
public class Alien {
    public  void code() {
        System.out.println("Coding");
    }
    }

```

- SpringBootFirstApplication.java

```java
package com.telusko.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootFirstApplication {

    public static void main(String[] args) {

       ApplicationContext context= SpringApplication.run(SpringBootFirstApplication.class, args);

        //we want spring can create that object
        //Alien obj =new Alien();
        //obj.code();

        Alien obj;
        obj=context.getBean(Alien.class);
        Alien obj1=context.getBean(Alien.class);
        obj.code();
        obj1.code();

        //Question are we getting two different object or single object
        //this question can answer in upcoming Spring lecture

    }

}
```

### Using the Application Context

1. **Understanding Spring's Container**:

   - Spring manages objects within an Inversion of Control (IoC) container.
   - We leverage `SpringApplication.run` to obtain a `ConfigurableApplicationContext`, which grants access to the IoC container.

2. **Creating a Simple Class**:
   - Introduce a basic class, `Alien`, representing a programmer in our context.
   - Define a method `code()` within `Alien` to simulate coding activities.

### Manual Object Creation

3. **Manual Object Invocation**:
   - Initially, instantiate `Alien` manually in `main()` and invoke its `code()` method.

### Implementing Dependency Injection

4. **Leveraging Spring for Object Management**:

   - Utilize Spring's `@Component` annotation on `Alien` to inform Spring to manage this class.
   - Update `main()` to retrieve `Alien` from the context using `context.getBean(Alien.class)`.

5. **Verifying Dependency Injection**:
   - Execute the application to confirm that Spring now manages object creation and initialization.

### Multiple Object Instances

6. **Creating Multiple Instances**:

   - Demonstrate creating multiple `Alien` instances from the context using `context.getBean(Alien.class)`.

7. **Observing Object Behavior**:
   - Verify whether Spring provides the same or different instances for each request.

## Conclusion and Next Steps

In the next tutorial, we'll delve deeper into dependency management within Spring, exploring scenarios involving dependencies between objects (`Alien` and potentially other classes). Understanding these concepts lays a solid foundation for advanced Spring development.

Stay tuned for more insights into Spring's powerful features!
