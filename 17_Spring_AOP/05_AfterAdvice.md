# Implementing After Advice in Spring AOP

In this section, we will implement `After` advice and demonstrate its usage in logging method execution. We'll also cover additional types of advice like `AfterThrowing` and `AfterReturning`.

## Implementing After Advice

To implement `After` advice, we can reuse our logging aspect but change the annotation to `@After`. This advice will execute after the specified method(s) completes, regardless of whether it finishes successfully or throws an exception.

### Example: Logging After Method Execution

```java
@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @After("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("Method executed: " + methodName);
    }
}
```

### Running the Application

- Restart the Application: Restart your Spring Boot application to apply the changes.
- Send a Request: Use Postman to send a request to the getJob endpoint.
- Check Logs: Verify the log shows "Method executed: getJob" in the console.
- Console Output Example

```plaintext
Method executed: getJob
```

### Handling Exceptions with AfterThrowing

- AfterThrowing advice executes only when the advised method throws an exception.

- Example: Logging When an Exception Occurs

```java
@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.telusko.springbootrest.service.JobService.*(..))", throwing = "ex")
    public void logMethodCrash(JoinPoint jp, Throwable ex) {
        String methodName = jp.getSignature().getName();
        logger.error("Method has some issues: " + methodName, ex);
    }
}
```

### Testing Exception Logging

- To test AfterThrowing, intentionally cause an exception in the getJob method:

```java
public Job getJob(int id) {
    // Simulate an exception
    int error = 10 / 0;
    // Method logic
}
```

- Restart the Application: Apply the changes and restart.
- Send a Request: Use Postman to trigger the getJob endpoint.
- Check Logs: Verify the log shows an error message indicating the method and the exception.
- Console Output Example

```plaintext
Method has some issues: getJob
```

- Logging Successful Execution with AfterReturning
- AfterReturning advice executes after a method successfully returns.

- Example: Logging Successful Method Execution

```java
@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @AfterReturning("execution(* com.telusko.springbootrest.service.JobService.getJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("Method executed successfully: " + methodName);
    }
}
```

### Testing AfterReturning Advice

- Remove Simulated Exception: Ensure getJob method completes successfully.
- Restart the Application: Apply the changes and restart.
- Send a Request: Use Postman to trigger the getJob endpoint.
- Check Logs: Verify the log shows a success message.
- Console Output Example

```plaintext
Method executed successfully: getJob
```

## Summary

- By implementing After, AfterThrowing, and AfterReturning advice, we can monitor and log method executions in various scenarios. These logging mechanisms help in debugging and observing the application without altering business logic.

- After Advice: Logs after method execution (similar to finally block).
- AfterThrowing Advice: Logs when an exception occurs.
- AfterReturning Advice: Logs after a method returns successfully.
- In the next section, we will explore the Around advice to gain even more control over method execution.
