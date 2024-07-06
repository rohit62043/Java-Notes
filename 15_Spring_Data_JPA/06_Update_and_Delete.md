# Updating and Deleting Records with Spring Data JPA

## Introduction

In this section, we will focus on updating and deleting `Student` records using Spring Data JPA. We'll demonstrate how to update an existing record and delete a record from the database.

### Updating Records

#### 1. Updating a Student Record

To update a `Student` record, use the `save` method provided by Spring Data JPA. If the entity with the same primary key exists, it will update the record; otherwise, it will insert a new one.

```java
// Example: Updating Kiran's marks to 65
Student s2 = repo.findById(102).orElse(new Student()); // Fetching Kiran by Id
s2.setMarks(65); // Updating the marks
repo.save(s2); // Saving the updated object back to the database
```

- Explanation:
- `repo.findById(102)` fetches the Student object with Id 102.
- `s2.setMarks(65)` updates the marks field of s2.
- `repo.save(s2)` saves the updated Student object s2 back to the database.

## Deleting Records

### 1. Deleting a Student Record

- Deleting a Student record is straightforward using the delete method provided by Spring Data JPA.

```java
// Example: Deleting Kiran's record
Student s2ToDelete = repo.findById(102).orElse(null); // Fetching Kiran by Id
if (s2ToDelete != null) {
    repo.delete(s2ToDelete); // Deletes the specified student object from the database
}
```

- Explanation:
- `repo.findById(102)` fetches the Student object with Id 102.
- `repo.delete(s2ToDelete)` deletes the Student object s2ToDelete from the database.

### Observation:

- The query should return no results for Kiran, confirming the deletion.

## Conclusion

- Updating and deleting records with Spring Data JPA is efficient and straightforward. The `save `method handles both updates and inserts, while the delete method removes records based on the specified entity. These operations are essential for maintaining and managing data in relational databases.

- In the next tutorial, we will integrate these operations into a job portal application using Spring Boot and React.
