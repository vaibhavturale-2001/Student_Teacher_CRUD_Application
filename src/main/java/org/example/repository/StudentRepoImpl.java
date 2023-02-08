package org.example.repository;

import org.example.model.Student;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentRepoImpl {
    void insertSingle(Student s1);
    Student selectSingle(int sid,int tid);
    List<Student> selectAll();
    Student updateSingle(Student s1);
    Boolean deleteSingle(int sid, int tid);
    Boolean deleteAll();
}
