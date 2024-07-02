# Stereotype Annotations in Spring

## Overview

In Spring, stereotype annotations are used to define the roles of various components within an application. While we have previously discussed the `@Component` annotation, which is a general-purpose annotation to mark a class as a Spring-managed component, there are other stereotype annotations that serve more specific purposes.

### Layers in a Full-fledged Application

In a typical application, especially a web application, there are multiple layers:

1. **Client**: Interacts with the server.
2. **Server**: Handles requests from the client and interacts with the database.
3. **Database**: Stores the data.

Within the server, there are typically multiple layers:

1. **Controller**: Handles incoming requests from the client.
2. **Service**: Performs business logic and processing.
3. **Repository (DAO)**: Interacts with the database to fetch or save data.

### Flow of Data

1. **Client** sends a request to the **Controller**.
2. The **Controller** forwards the request to the **Service**.
3. The **Service** interacts with the **Repository** to fetch or save data.
4. The **Repository** interacts with the **Database**.
5. Data flows back from the **Database** to the **Repository**.
6. The **Repository** sends the data back to the **Service**.
7. The **Service** processes the data and sends it back to the **Controller**.
8. The **Controller** sends the response back to the **Client**.

### Annotations for Different Layers

- **@Component**: Generic annotation for any Spring-managed component.
- **@Service**: Marks a class as a service layer component.
- **@Repository**: Marks a class as a data access object (DAO) component.

## Example

### Client Layer (Controller)

```java
@RestController
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping("/laptops")
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }
}
```

## Service Layer

```java
@Service
public class LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }
}
```

## Repository Layer

```java
@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
```

## Summary

- In summary, using specific stereotype annotations helps to clearly define the roles of different components within a Spring application.
- The `@Controller` annotation is used for handling incoming requests, the `@Service` annotation is used for business logic and processing, and the `@Repository` annotation is used for data access logic. This separation of concerns makes the application more modular and easier to maintain.
