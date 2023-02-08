package org.example.service;

import org.example.model.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentServiceImpl{
    void insertSingle(Student s1);
    void insertMultiple(List<Student> studentList);
    Student selectSingle(int sid,int tid);
    List<Student> selectMultiple(List<Integer>sids,List<Integer>tids);
    List<Student> selectAll();
    Student updateSingle(Student s1);
    List<Student> updateMultiple(List<Student> studentList1);
    Boolean deleteSingle(int sid,int tid);
    Boolean deleteMultiple(List<Integer>sids,List<Integer>tids);
    Boolean deleteAll();
}
