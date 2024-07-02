# Spring Core vs Spring Boot

## Spring Core Project

In our journey with Spring Core, we have worked with multiple configurations and annotations:

1. **XML Configuration**: Traditional way of configuring Spring beans and dependencies.
2. **Java-based Configuration**: Using annotations to configure Spring beans.
   - **Component Annotations**:
     - `@Component`: Indicates that a class is a Spring-managed component.

### Example:

```java
@Component
public class Alien {
    @Autowired
    private Laptop laptop;
    // Other properties and methods
}
```

- In the above example, the @Component annotation marks the Alien class as a Spring-managed component, and @Autowired is used to inject the Laptop dependency.

## Spring Boot Project

- With Spring Boot, the configuration is minimal compared to Spring Core. Here’s why:

- Spring Boot Application Annotation:
  @SpringBootApplication: Indicates a Spring Boot application and triggers auto-configuration.
- Example:

```java
@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
}
```

- In the above example, @SpringBootApplication marks the class as a Spring Boot application and enables several features, including component scanning, auto-configuration, and property support.

## Key Differences

### Configuration:

- Spring Core requires explicit configuration using XML or Java-based annotations.
- Spring Boot uses @SpringBootApplication to enable auto-configuration, reducing the need for explicit configurations.

### Project Structure:

- In Spring Core, you manage the configuration and component scanning manually.
- In Spring Boot, it automatically scans components and configures them based on the project's dependencies and annotations.

## Additional Features:

- Spring Boot provides embedded servers, simplified dependency management, and production-ready features like metrics, health checks, and externalized configuration.

## Advanced Configuration

- In Spring Core, we used additional annotations like @Primary and @Qualifier to manage bean conflicts. These can also be applied in Spring Boot projects.

- Example with Qualifier and Primary

```java
@Component
public class Alien {
    @Autowired
    @Qualifier("desktop")
    private Computer computer;

    // Other properties and methods
}

@Component
@Primary
public class Laptop implements Computer {
    // Implementation details
}

@Component
public class Desktop implements Computer {
    // Implementation details
}
```

- In the above example, @Qualifier specifies which bean to inject when multiple beans of the same type exist, and @Primary marks a bean as the default choice for dependency injection.

## Next Steps

- In the upcoming videos, we will:

- Add more properties to our Spring Boot classes.
- Implement getters and setters.
  Work with additional annotations to manage dependencies.
