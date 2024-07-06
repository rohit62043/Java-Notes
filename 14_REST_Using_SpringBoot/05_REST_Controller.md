# Building the Backend

## Setting Up the Project

1. **Create a New Project**:

   - Go to Spring Initializr.
   - Choose Maven, Spring Boot version, and Java 21.
   - Group: `com.telusko`
   - Artifact: `spring-boot-rest`
   - Packaging: Jar
   - Add Dependencies: `Spring Web`, `Lombok`
   - Generate and download the project.

2. **Setup in IDE**:
   - Unzip and open the project in your IDE (e.g., IntelliJ IDEA).
   - Copy the `model`, `repo`, and `service` packages from the previous project.

## Creating the Controller

1. **Create a Controller Class**:

   - Name it `JobRestController`.

2. **Define Endpoints**:

   - Add a method to handle GET requests for all job posts.
   - Use `@Autowired` to inject `JobService`.

3. **Controller Code**:

   ```java
   @RestController
   public class JobRestController {
       @Autowired
       private JobService service;

       @GetMapping("/jobPosts")
       public List<JobPost> getAllJobs() {
           return service.getAllJobs();
       }
   }
   ```

## Creating New Project:

- We reuse model, repo, and service from the previous project and create a new controller.

### RestController vs. Controller:

- @RestController automatically serializes returned objects to JSON.
- No need for @ResponseBody on individual methods when using @RestController.

## Handling Different Methods:

- Example URLs for CRUD operations:
- GET: /jobPosts
- POST: /jobPosts
- PUT: /jobPosts
- DELETE: /jobPosts

## Next Steps

Integrate this backend with a React application.
Implement and test other HTTP methods (POST, PUT, DELETE).
