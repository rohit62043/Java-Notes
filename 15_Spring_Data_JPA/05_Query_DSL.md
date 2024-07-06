# Searching and Querying Data with Spring Data JPA

## Introduction

In this tutorial, we'll explore how to search and query `Student` records using Spring Data JPA. We'll cover basic querying by name and marks, and also touch upon more advanced querying using custom methods.

### Basic Querying by Name

#### 1. Finding by Name

To search for `Student` records by name, Spring Data JPA generates queries automatically based on method naming conventions:

```java
public interface StudentRepo extends JpaRepository<Student, Integer> {

    // Query method to find students by name
    List<Student> findByName(String name);

}
```

- Explanation:
  - The findByName(String name) method is automatically implemented by Spring Data JPA.
  - It queries the database for all Student records where the name matches the provided parameter.

## 2. Finding by Marks

- Similarly, querying by marks can be done using method naming conventions:

```java
public interface StudentRepo extends JpaRepository<Student, Integer> {

    // Query method to find students by marks
    List<Student> findByMarks(int marks);

}
```

- Explanation:
  - The findByMarks(int marks) method fetches all Student records with a specific marks value.

## Advanced Querying with Custom Queries

1.  Using Query Annotation
    - For more complex queries or queries involving conditions like greater than, use `@Query `annotation with JPQL:

```java
public interface StudentRepo extends JpaRepository<Student, Integer> {

    // Custom query method to find students with marks greater than a specified value
    @Query("SELECT s FROM Student s WHERE s.marks > :marks")
    List<Student> findByMarksGreaterThan(@Param("marks") int marks);

}
```

- Explanation:
- `@Query("SELECT s FROM Student s WHERE s.marks > :marks")` specifies a JPQL query.
- `@Param("marks")` int marks binds the marks parameter to the query.

## 2. Running Queries

- Execute these queries by calling respective methods in your service or controller classes:

```java
public class StudentService {

    @Autowired
    private StudentRepo repo;

    public void searchAndPrint() {
        // Searching by name
        List<Student> studentsByName = repo.findByName("Navin");
        System.out.println("Students by name 'Navin': " + studentsByName);

        // Searching by marks
        List<Student> studentsByMarks = repo.findByMarks(80);
        System.out.println("Students with marks 80: " + studentsByMarks);

        // Searching by marks greater than 72
        List<Student> studentsByMarksGreaterThan72 = repo.findByMarksGreaterThan(72);
        System.out.println("Students with marks greater than 72: " + studentsByMarksGreaterThan72);
    }
}
```

- Explanation:
- The StudentService class demonstrates calling different query methods from StudentRepo.
- It prints the results obtained from these queries.

## Conclusion

- Spring Data JPA simplifies data access by automatically generating queries based on method names. For more complex scenarios, use `@Query `annotation to define` custom JPQL queries`. Ensure method names follow the convention `findBy{PropertyName} `for automatic query generation.

- In the next tutorial, we'll explore how to perform delete and update operations on Student records using Spring Data JPA.
