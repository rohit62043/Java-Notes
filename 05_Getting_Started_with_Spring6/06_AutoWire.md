# Adding Dependency and Wiring Layers in Spring

In this tutorial, we'll extend our Spring Boot application to introduce dependency between classes and understand the concept of wiring using annotations.

## Problem Statement

When an `Alien` object needs to perform tasks like `code()` and `compile()`, it depends on a `Laptop` object. We want to manage these dependencies using Spring's IoC container.

### Initial Setup

1. **Alien Class**:
   - Contains a method `code()` to simulate coding activities.
   - Initially, attempts to invoke `compile()` on a `Laptop` object.

### Introducing the `Laptop` Class

2. **Laptop Class**:
   - Defines a method `compile()` to simulate compilation activities.
   - Initially, the `Laptop` object is instantiated manually.

### Dependency Injection with Spring

3. **Using Spring's IoC Container**:
   - Update `Laptop` to annotate with `@Component` to inform Spring to manage this class.
   - Modify `Alien` to use `@Autowired` annotation to automatically inject `Laptop` dependency.

### Auto Wiring and Component Annotation

4. **Auto Wiring**:
   - Demonstrate `@Autowired` annotation to establish a dependency link between `Alien` and `Laptop`.
   - Ensure that Spring initializes and manages `Laptop` objects.

### Verifying Functionality

5. **Testing the Setup**:
   - Execute the application to confirm that `Alien` can invoke `Laptop` methods successfully, indicating successful dependency management by Spring.

## Conclusion and Next Steps

This tutorial has covered the basics of setting up dependency injection and wiring dependencies using annotations in Spring Boot. We've established a relationship between `Alien` and `Laptop` classes, ensuring that Spring manages object creation and linkage.

In future tutorials, we'll delve deeper into Spring framework configurations and explore additional features and concepts.

Stay tuned for more insights into advanced Spring development!
