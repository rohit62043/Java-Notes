# Configuring Spring Boot Application for Postgres Database

## Setting Up Postgres Database

1. **Database Setup**:

   - Ensure you have Postgres installed and running.
   - Create a database named `telusko`.
   - Create a table named `student` with appropriate schema and insert some sample data.

2. **Schema and Data**:
   - Use pgAdmin or any PostgreSQL client to execute SQL queries to create the table and insert data.

## Configuring Spring Boot Application

### 1. Update `pom.xml`

- Comment out H2 dependency and add PostgreSQL JDBC driver dependency.
- Example:
  ```xml
  <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>42.2.23</version> <!-- or any latest stable version -->
  </dependency>
  ```

### 2. Update application.properties

- Open src/main/resources/application.properties.
  Configure the following properties to connect to your PostgreSQL database:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/telusko
spring.datasource.username=postgres
spring.datasource.password=0000
spring.datasource.driver-class-name=org.postgresql.Driver
```

### 3. Application Code

- Ensure your Spring Boot application uses JdbcTemplate or Spring Data JDBC to interact with the database.
- Update your data access code to use PostgreSQL instead of H2.
- Example JdbcTemplate usage:

```java
@Autowired
private JdbcTemplate jdbc;

public List<Student> findAll() {
    String sql = "SELECT * FROM student";
    return jdbc.query(sql, (rs, rowNum) -> {
        Student student = new Student();
        student.setRollNumber(rs.getInt("roll_number"));
        student.setName(rs.getString("name"));
        student.setMarks(rs.getInt("marks"));
        return student;
    });
}
```

### 4. Run and Test

- Run your Spring Boot application and verify that it connects to PostgreSQL and retrieves data correctly.
- Make sure to handle any exceptions and error scenarios that may arise during database connectivity.
- By following these steps, you can configure your Spring Boot application to use a PostgreSQL database seamlessly. Remember to adjust configurations based on your specific database setup and credentials.
- `schema.sql` and `data.sql` is not needed Here You and need to make changes in `application.properties` while transfering from one database to other
