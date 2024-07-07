# Implementing AOP Logging in Spring

In this section, we'll implement logging for every method in the `JobService` class using AOP. We'll start by defining the aspect and specifying the pointcut and advice.

## Step-by-Step Implementation

### 1. Define the Aspect Class

First, we need to create an aspect class that contains the logging logic.

```java
package com.example.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.telusko.springbootrest.service.JobService.*(..))")
    public void logMethodCall() {
        logger.info("Method called.");
    }
}
```

- `Aspect`: LoggingAspect is annotated with `@Aspect` and `@Component`.
- `Advice`: The logMethodCall method is annotated with `@Before`, specifying it should run before any method in JobService.
- `Pointcut Expression`: The `@Before` annotation uses a pointcut expression to match all methods in the JobService class.

### 2. Understanding the Pointcut Expression

- The pointcut expression `execution(* com.telusko.springbootrest.service.JobService.*(..))` can be broken down as follows:

- `execution`: Indicates that the pointcut is an execution pointcut.
- `*`: Matches any return type.
- `com.telusko.springbootrest.service.JobService.*(..)`: Matches all methods in the JobService class, regardless of their name or arguments.

### 3. Running the Application

- To test the logging aspect:

- Ensure your Spring Boot application is running.
  = Use a tool like Postman to make HTTP requests to the application.
- Example Requests
  - Get All Jobs: GET /jobPost
  - Get Job by ID: GET /jobPost/{id}
  - For each request, the logMethodCall method will log "Method called" before executing the service method.

## Summary

- By implementing this logging aspect, we can monitor method calls in JobService without modifying the actual service class. This illustrates the power of AOP in separating cross-cutting concerns from business logic.

- In the next section, we will explore how to implement after advice to execute logic after method calls.
