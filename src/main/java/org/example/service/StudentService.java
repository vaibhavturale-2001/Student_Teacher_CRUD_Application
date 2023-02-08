package org.example.service;

import com.google.protobuf.Internal;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repository.StudentRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentServiceImpl{
    @Autowired
    private StudentRepoImpl repo;
    @Override
    public void insertSingle(Student s1){
        repo.insertSingle(s1);
    }
    @Override
    public void insertMultiple(List<Student> studentList){
        for(int i=0;i<studentList.size();i++){
            repo.insertSingle(studentList.get(i));
        }
    }
    @Override
    public Student selectSingle(int sid,int tid){
        return repo.selectSingle(sid,tid);
    }
    @Override
    public List<Student> selectMultiple(List<Integer>sids,List<Integer>tids){
        List<Student> studentList=new ArrayList<>();
        for(int i=0;i<sids.size();i++){
            if(tids.size()<i){

                studentList.add(repo.selectSingle(sids.get(i),tids.get(tids.size())));
            }else{
                studentList.add(repo.selectSingle(sids.get(i),tids.get(i)));
            }
        }
        return studentList;
    }
    @Override
    public List<Student> selectAll(){
        return repo.selectAll();
    }
    @Override
    public Student updateSingle(Student s1){
        return repo.updateSingle(s1);
    }
    @Override
    public List<Student> updateMultiple(List<Student> studentList1){
        for(int i=0;i<studentList1.size();i++){
            repo.updateSingle(studentList1.get(i));
        }
        return studentList1;
    }
    @Override
    public Boolean deleteSingle(int sid,int tid){
        return repo.deleteSingle(sid, tid);
    }
    @Override
    public Boolean deleteMultiple(List<Integer>sids,List<Integer>tids){
        List<Boolean>countedList=new ArrayList<>();
        Boolean result=false;
        for(int i=0;i<sids.size();i++){
                countedList.add(repo.deleteSingle(sids.get(i),tids.get(i)));
            }
        for (int i=0;i<countedList.size();i++){
            if (countedList.get(i).equals(true)){
                result = true;
            }

        }
        return result;
    }
    @Override
    public Boolean deleteAll(){
        return repo.deleteAll();
    }
    }
