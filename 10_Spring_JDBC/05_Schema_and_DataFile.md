# Creating Schema and Populating Data in H2 Database

## Creating Schema and Data Scripts

### Step 1: Create `schema.sql`

1. **Create Table Definition**:
   - Create a file named `schema.sql` in your `src/main/resources` folder.
   - Define the table structure for `student` including columns `roll_number`, `name`, and `marks`.
   - Example:
     ```sql
     CREATE TABLE IF NOT EXISTS student (
         roll_number INT PRIMARY KEY,
         name VARCHAR(50),
         marks INT
     );
     ```

### Step 2: Create `data.sql`

1. **Populate Data**:
   - Create a file named `data.sql` in the same `src/main/resources` folder.
   - Use insert statements to populate initial data into the `student` table.
   - Example:
     ```sql
     INSERT INTO student (roll_number, name, marks) VALUES
     (101, 'Navin', 78),
     (102, 'Kiran', 79),
     (103, 'Harsh', 68),
     (104, 'Sushil', 82);
     ```

## Integrating Schema and Data in H2 Database

### Step 3: Verify Schema and Data Loading

1. **Run Application**:

   - Ensure your Spring Boot application is configured to load `schema.sql` and `data.sql` on startup.
   - Verify in your `application.properties` or `application.yml` that H2 is configured correctly, typically with a URL like `jdbc:h2:mem:testdb`.

2. **Verify Data Insertion**:

   - Modify your existing `addStudent` method in `StudentService` to also retrieve data using `findAll` or similar method.
   - Example:
     ```java
     public void addStudent(Student student) {
         String sql = "INSERT INTO student (roll_number, name, marks) VALUES (?, ?, ?)";
         int rows = jdbc.update(sql, student.getRollNumber(), student.getName(), student.getMarks());
         System.out.println(rows + " row(s) affected");

         List<Student> students = jdbc.query("SELECT * FROM student", new BeanPropertyRowMapper<>(Student.class));
         System.out.println("Students in database:");
         students.forEach(s -> System.out.println(s.getRollNumber() + ", " + s.getName() + ", " + s.getMarks()));
     }
     ```

3. **Run and Validate**:
   - Run your application and check the console output for the number of rows affected during insertion.
   - Also, ensure that data from `data.sql` is retrieved correctly using `findAll`.

### Next Steps

In the next video, we will:

- Enhance the `StudentService` to include methods for retrieving and manipulating data using JDBC Template.
- Handle exceptions and edge cases that may occur during database operations.
- Explore more advanced features of Spring JDBC for data access and manipulation.

Stay tuned for the continuation where we further explore working with data in H2 using Spring JDBC Template!
