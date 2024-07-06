package com.rohit.student.repo;

import com.rohit.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    @Query("Select s from Student s where s.name = ?1")//optional
    public List<Student> findByName(String Name);

    public List<Student> findByMarksGreaterThan(int mark);
}
