# Setting Up Spring JDBC Project with H2 Database

## Project Setup

### Step 1: Project Initialization

1. **Spring Initializr Setup**:

   - Go to Spring Initializr and configure your project as follows:
     - Project: Maven Project
     - Language: Java
     - Spring Boot Version: Latest available version (e.g., 3.2)
     - Group: com.telusko
     - Artifact: SpringJDBCExample
     - Name: Demo project for Spring Boot and JDBC
     - Packaging: Jar
     - Java Version: 17 or higher
   - Click on "Add Dependencies" and add the following dependencies:
     - **Spring JDBC**: Provides support for JDBC operations with Spring.
     - **H2 Database**: Lightweight, in-memory database ideal for development and testing.
   - Click "Generate" to download the project.

2. **Open Project in IntelliJ**:
   - Unzip the downloaded project folder and open it in IntelliJ IDEA.
   - Verify the project runs successfully to ensure setup correctness.

### Step 2: Creating Entity Class

1. **Define Student Class**:

   - Create a Java class named `Student` in the `model` package.
   - Add fields `rollNumber`, `name`, and `marks`.
   - Generate getters, setters, and a `toString()` method for easy object representation.

2. **Make Student a Managed Bean**:
   - Annotate the `Student` class with `@Component` or `@Service` to manage it as a Spring bean.
   - Ensure it's available for dependency injection throughout the application.

### Step 3: Designing Service and Repository Layers

1. **Service Layer**:

   - Create a `StudentService` class in the `service` package.
   - Implement methods to handle business logic related to students, like adding, retrieving, or updating students.

2. **Repository Layer**:
   - Create a `StudentRepository` class in the `repository` package.
   - Use Spring JDBC's `JdbcTemplate` to execute SQL queries for CRUD operations on the `Student` table in the H2 database.

### Next Steps

In the upcoming video, we'll delve deeper into implementing the Service and Repository layers. These layers will facilitate interaction between the main application logic (represented by `StudentService`) and the database operations (handled by `StudentRepository`).

Stay tuned for the next part where we'll build upon this foundation and explore how Spring JDBC and H2 work together to manage student data effectively.
