# Fine-Tuning Logging Aspect in Spring

After restarting the system, the issue with the server port was resolved. Now, the Tomcat server is running on port 8080. Here's how to refine our logging aspect to target specific methods and retrieve more detailed information about the method calls.

## Specific Method Logging

You can customize the logging aspect to log only specific methods rather than all methods in `JobService`. For example, to log only the `updateJob` method, you can modify the pointcut expression.

### Example: Logging Only `updateJob` Method

```java
@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
    public void logMethodCall() {
        logger.info("Method called.");
    }
}
```

### Checking Specific Method Execution

- To verify that the logging is called only for the updateJob method, you can use JoinPoint to get details about the method being executed.

```java
@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("Method called: " + methodName);
    }
}
```

### Example: Logging Method Call Details

- To log details for the getJob method:

```java
@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.telusko.springbootrest.service.JobService.getJob(..))")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("Method called: " + methodName);
    }
}
```

### Running the Application

- Start the Application: Restart the Spring Boot application to apply the changes.
- Send a Request: Use Postman to send a request to the getJob endpoint.
- Check Logs: Verify that the log shows "Method called: getJob" in the console.
- Console Output Example

```plaintext
Method called: getJob
```

### Logging Multiple Methods

- To log multiple methods, you can use the pipe symbol (|) in the pointcut expression.

```java
@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("Method called: " + methodName);
    }
}
```

### Summary

- By refining the pointcut expressions and utilizing JoinPoint, you can target specific methods and log detailed information about method calls. This approach allows you to effectively monitor and debug your application without modifying the business logic.

- In the next section, we will explore how to implement after advice to execute logic after method calls.
