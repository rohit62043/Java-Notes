# Integrating JDBC Template with H2 Database

## Adding JDBC Template for Database Operations

### Step 1: Configure JDBC Template

1. **Declare JDBC Template**:

   - Declare a private instance variable `JdbcTemplate jdbc` in your `StudentService` class.
   - Use Spring's `@Autowired` annotation to inject `JdbcTemplate` instance managed by Spring.
   - Example:
     ```java
     @Service
     public class StudentService {
         @Autowired
         private JdbcTemplate jdbc;

         // Methods like addStudent and getStudents go here
     }
     ```

2. **Implement `addStudent` Method**:
   - Modify the `addStudent` method to use `jdbc.update` to execute an SQL insert query.
   - Example:
     ```java
     public void addStudent(Student student) {
         String sql = "INSERT INTO student (roll_number, name, marks) VALUES (?, ?, ?)";
         int rows = jdbc.update(sql, student.getRollNumber(), student.getName(), student.getMarks());
         System.out.println(rows + " row(s) affected");
     }
     ```

### Step 2: Handling Table Creation in H2 Database

1. **Ensure Table Existence**:

   - H2 database typically provides an embedded mode where tables are automatically created if they don't exist when JDBC operations are executed.
   - Ensure that the H2 database URL (`jdbc:h2:mem:testdb`) is configured in `application.properties` or `application.yml`.

2. **Create `student` Table**:

   - If the table doesn't exist, create it manually using SQL.
   - Example:
     ```sql
     CREATE TABLE IF NOT EXISTS student (
         roll_number INT PRIMARY KEY,
         name VARCHAR(100),
         marks INT
     );
     ```

3. **Populate Data**:
   - Optionally, populate the table with initial data using insert statements.

### Next Steps

In the next video, we will:

- Configure H2 database settings in `application.properties` or `application.yml`.
- Explore how to execute SQL queries using JDBC Template to interact with the H2 database.
- Handle exceptions and errors that may occur during database interactions.

Stay tuned for the continuation where we dive deeper into configuring and interacting with the H2 database using Spring JDBC Template.
