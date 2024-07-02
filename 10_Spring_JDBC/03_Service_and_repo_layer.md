# Creating Service and Repository Layers with Spring JDBC

## Implementing Service Layer

### Step 1: Create `StudentService` Class

1. **Create Service Class**:

   - Create a Java class named `StudentService` in the `service` package.
   - Annotate it with `@Service` to mark it as a Spring service component.
   - Implement methods like `addStudent` and `getStudents` for managing student data.

2. **Add `addStudent` Method**:
   - Implement the `addStudent` method in `StudentService` to handle adding a student to the database.
   - Use dependency injection to access the `StudentRepository` (`repo`) where actual database operations will be performed.
   - Example:
     ```java
     @Service
     public class StudentService {
         @Autowired
         private StudentRepository repo;

         public void addStudent(Student student) {
             repo.save(student);
             System.out.println("Added");
         }

         public List<Student> getStudents() {
             return repo.findAll();
         }
     }
     ```

### Step 2: Create `StudentRepository` Class

1. **Create Repository Class**:

   - Create a Java class named `StudentRepository` in the `repository` package.
   - Annotate it with `@Repository` to mark it as a Spring repository component responsible for database interactions.

2. **Implement Database Operations**:
   - Use `JdbcTemplate` for executing SQL queries against the H2 database.
   - Implement methods like `save` and `findAll` to handle CRUD operations.
   - Example:
     ```java
     @Repository
     public class StudentRepository {
         @Autowired
         private JdbcTemplate jdbcTemplate;

         public void save(Student student) {
             String sql = "INSERT INTO student (roll_number, name, marks) VALUES (?, ?, ?)";
             jdbcTemplate.update(sql, student.getRollNumber(), student.getName(), student.getMarks());
         }

         public List<Student> findAll() {
             String sql = "SELECT * FROM student";
             return jdbcTemplate.query(sql, (rs, rowNum) ->
                     new Student(rs.getInt("roll_number"), rs.getString("name"), rs.getInt("marks")));
         }
     }
     ```

### Next Steps

In the upcoming video, we'll integrate these layers with the H2 database using `JdbcTemplate`. We'll see how to configure the database connection, perform CRUD operations, and retrieve data from the database. Stay tuned for the next part where we dive deeper into Spring JDBC and H2 integration.
