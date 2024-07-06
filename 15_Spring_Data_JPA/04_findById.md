```java
package com.rohit.student;

import com.rohit.student.model.Student;
import com.rohit.student.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(StudentApplication.class, args);
		Student s1= context.getBean(Student.class);
		Student s2=context.getBean(Student.class);
		Student s3=context.getBean(Student.class);

		StudentRepo repo=context.getBean(StudentRepo.class);

		s1.setRollNo(101);
		s1.setName("Navin");
		s1.setMarks(75);


		s2.setRollNo(102);
		s2.setName("Kiran");
		s2.setMarks(80);


		s3.setRollNo(103);
		s3.setName("Harsh");
		s3.setMarks(70);

//		repo.save(s1);
//		repo.save(s2);
//		repo.save(s3);
//
//		List<Student> s=repo.findAll();

		Optional<Student> s=repo.findById(103);

		System.out.println(s.orElse(new Student()));
	}

}
```

### Explanation:

- `findById(103)` queries the database for a Student record where rollNumber is 103.
- The result is wrapped in an `Optional<Student>` to handle cases where no record exists for the given primary key.
- `.orElse(new Student())`provides a default Student object if no record is found to prevent `NullPointerException`.
