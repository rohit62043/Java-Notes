# Controller for Students

## Introduction

In this guide, we will create a controller for managing student resources. This includes fetching and adding student data. We'll also explore how CSRF protection works in this context.

## Step-by-Step Implementation

### 1. Create a Student Class

Define a class `Student` to represent a student with the following fields:

- `int id`
- `String name`
- `String technology`

Use Lombok annotations to simplify the code by generating getters, setters, constructors, and `toString` methods.

```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private String technology;
}
```

### 2. Add Lombok Dependency

- Add Lombok to your project's dependencies. Reload Maven after adding the dependency.

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.20</version>
    <scope>provided</scope>
</dependency>
```

### 3. Create StudentController

- Create a StudentController to manage the student resources.

### 3.1. Define the Controller

- Mark the class with @RestController and define a list of students with some initial data.

```java
Copy code
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "Navin", "Java"));
        students.add(new Student(2, "Kiran", "Blockchain"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }
}
```

### 4. Handling CSRF

- CSRF protection is enabled by default in Spring Security. To perform POST requests, a CSRF token must be included.

### 4.1. Fetching CSRF Token

- To fetch a CSRF token, we need a method that returns the token. This can be accessed and used in the POST request to ensure it's not blocked.

```java
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/csrf")
public class CsrfController {
    @GetMapping
    public CsrfToken csrf(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }
}
```

### 5. Testing with Postman

### 5.1. GET Request

- Use the browser or Postman to make a GET request to /students.
- Verify the list of students is returned.

### 5.2. POST Request

- Fetch the CSRF token by making a GET request to /csrf.
- Include the CSRF token in the headers of your POST request to /students.
- Send a new student record as JSON in the body.
- Example of adding a student:

```json
{
  "id": 3,
  "name": "Harsh",
  "technology": "JavaScript"
}
```

- Include the CSRF token in the headers:

```makefile
X-CSRF-TOKEN: <token_value>
```

### Conclusion

- By following these steps, you will have a basic controller for managing student resources with CSRF protection enabled. This setup is not production-ready but serves as a good starting point for learning purposes.

That's one way of solving this.
The second way of solving this is,
what if you will not even allow for some other website
to use your session id?
I mean, problem solved, right?
The entire problem started
because some other malicious website
is using your session ID to access a particular resource.
What if you don't allow that?
What if you say, "Hey,
you can only use it from the same website."
So problem solved, right?
How do we do that?
Let's see that in the upcoming videos.
But at this point, now we know how to use CSRF token.
What is CSRF?
And that's it from this video.
In the next video, let's try to expand this more
with the same site property.
