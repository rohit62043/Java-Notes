# Fetching Data using JDBC Template with Spring

## Implementing `findAll` Method

### Step 1: Implement `findAll` Method

1. **Define SQL Query**:

   - Create a SQL query string to fetch all data from the `student` table.
   - Example:
     ```java
     String sql = "SELECT * FROM student";
     ```

2. **Execute Query with JDBC Template**:

   - Use the `query` method of `JdbcTemplate` to execute the SQL query.
   - Provide the SQL query string and a `RowMapper` instance.
   - Example:
     ```java
     List<Student> students = jdbc.query(sql, new RowMapper<Student>() {
         @Override
         public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
             Student student = new Student();
             student.setRollNumber(rs.getInt("roll_number"));
             student.setName(rs.getString("name"));
             student.setMarks(rs.getInt("marks"));
             return student;
         }
     });
     ```

3. **Lambda Expression Simplification**:

   - Since `RowMapper` is a functional interface, it can be simplified using lambda expressions.
   - Example:
     ```java
     List<Student> students = jdbc.query(sql, (rs, rowNum) -> {
         Student student = new Student();
         student.setRollNumber(rs.getInt("roll_number"));
         student.setName(rs.getString("name"));
         student.setMarks(rs.getInt("marks"));
         return student;
     });
     ```

4. **Return the List of Students**:
   - Return the list of `Student` objects fetched from the database.
   - Example:
     ```java
     return students;
     ```

### Next Steps

In this implementation, we've used `JdbcTemplate` to fetch data from the `student` table in the H2 database. The `findAll` method retrieves all rows from the table and maps them to `Student` objects using `RowMapper`. Lambda expressions are leveraged to simplify the `RowMapper` implementation, reducing code verbosity.

Next, consider:

- Error handling and exception management for database operations.
- Testing the `findAll` method to ensure correct retrieval of data.
- Exploring additional features of Spring JDBC for more advanced data access scenarios.

Stay tuned for more insights into Spring JDBC and further enhancements to your application's data handling capabilities!
