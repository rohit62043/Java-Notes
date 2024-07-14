### Implementing Spring Security in a Web Application

To begin implementing Spring Security in our project, we'll start with setting up a basic Spring Boot application using Spring Initializr and then proceed to secure a resource endpoint.

#### Setting Up the Project

1. **Spring Initializr Setup:**

   - Navigate to [Spring Initializr](https://start.spring.io/).
   - Configure the project as follows:
     - **Project:** Maven
     - **Language:** Java
     - **Spring Boot Version:** 3.2.2 (latest stable version)
     - **Group:** com.telusko
     - **Artifact:** spring-sec-demo
     - **Packaging:** JAR
     - **Java:** 21 (or your preferred Java version)
   - Add dependencies:
     - `Spring Web` for creating a web application.
     - `Spring Security` for implementing security features.
     - `DevTools` for faster application reloads during development.
   - Generate the project and unzip it.

2. **Import the Project:**

   - Open the project in your preferred IDE (e.g., IntelliJ IDEA Community/Ultimate, Eclipse, VS Code).

3. **Project Structure Overview:**
   - Explore the project structure:
     - `src/main/java`: Contains the main Java application code.
     - `pom.xml`: Lists project dependencies including Spring Web, Spring Security, and DevTools.

#### Creating a Basic Controller

Now, let's create a simple REST controller to test our application.

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String greet() {
        return "Hello World";
    }
}
```

### Running the Application

- Run the Application:

- Start your Spring Boot application from your IDE or using Maven (mvn spring-boot:run).

### Accessing the Endpoint:

- Open your browser and navigate to http://localhost:8080/hello.
- Verify that you receive the response "Hello World", confirming the endpoint is accessible without authentication.

### Implementing Spring Security

- In the next steps, we'll secure our /hello endpoint and create a login form to restrict access.

### Enable Spring Security:

- Uncomment the Spring Security dependency in your pom.xml.
- Reload Maven dependencies and restart your application.

### Creating a Login Form:

- Configure Spring Security to require authentication for accessing /hello.
- Implement a login form to authenticate users.
- Ensure passwords are stored securely using hashing.

### Verifying Username and Password:

- Implement authentication logic to validate credentials against a user database or repository.

### Conclusion

By following these steps, you'll be able to integrate Spring Security into your Spring Boot application, secure endpoints, and manage user authentication effectively. Stay tuned for the next video where we'll delve deeper into configuring Spring Security and implementing authentication.
