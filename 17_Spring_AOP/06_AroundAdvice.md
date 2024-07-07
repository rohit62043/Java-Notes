# Implementing Around Advice in Spring AOP

In this section, we will implement `Around` advice to monitor the performance of methods by logging the time taken for their execution. We will also explore how to integrate this into our existing application.

## Understanding Around Advice

`Around` advice allows you to execute custom behavior both before and after the method invocation. This is useful for tasks like logging execution time, which involves capturing the start and end times around a method call.

### Use Case: Measuring Execution Time

Let's measure how much time it takes to execute the `getJob` method, which involves fetching data from a database.

### Step-by-Step Implementation

1. **Create a New Aspect Class:**

   Create a new class `PerformanceMonitorAspect` for monitoring performance.

   ```java
   @Aspect
   @Component
   public class PerformanceMonitorAspect {
       private static final Logger logger = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

       @Around("execution(* com.telusko.springbootrest.service.JobService.getJob(..))")
       public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
           long start = System.currentTimeMillis();

           Object result = jp.proceed();

           long end = System.currentTimeMillis();
           logger.info("Time taken by " + jp.getSignature().getName() + ": " + (end - start) + " ms");

           return result;
       }
   }
   ```

## Handling Around Advice:

- Start Time: Capture the start time using System.currentTimeMillis().
- Method Execution: Execute the method using jp.proceed().
- End Time: Capture the end time after the method execution.
- Logging: Log the time taken using the logger.
- Return Result: Return the result of the method execution.

### Testing the Around Advice

- Restart the Application: Restart your Spring Boot application to apply the changes.
- Send a Request: Use Postman to send a request to the getJob endpoint.
  = Check Logs: Verify the log shows the time taken for the getJob method execution.
  = Example Console Output

```plaintext
Time taken by getJob: 104 ms
```

### Expanding the Around Advice

- You can extend the Around advice to measure execution time for multiple methods by updating the pointcut expression.

```java
@Around("execution(* com.telusko.springbootrest.service.JobService.*(..))")
public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
    long start = System.currentTimeMillis();

    Object result = jp.proceed();

    long end = System.currentTimeMillis();
    logger.info("Time taken by " + jp.getSignature().getName() + ": " + (end - start) + " ms");

    return result;
}
```

### Testing Multiple Methods

- Restart the Application: Apply the changes and restart.
- Send Requests: Use Postman to trigger various endpoints like getAllJobs and deleteJob.
- Check Logs: Verify the log shows the time taken for each method execution.
- Example Console Output for Multiple Methods

```plaintext
Time taken by getJob: 104 ms
Time taken by getAllJobs: 79 ms
```

### Conclusion

- Around advice is a powerful tool in Spring AOP, allowing you to encapsulate cross-cutting concerns like performance monitoring without modifying business logic. This approach keeps your code clean and separates concerns effectively.

- Around Advice: Executes custom behavior before and after method invocation.
  Logging Execution Time: Captures start and end times to measure method performance.
  Extendable: Can be applied to multiple methods by updating the pointcut expression.
  In the next section, we will explore how to validate method inputs using AOP.
