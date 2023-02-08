package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController{
    @Autowired
    private StudentServiceImpl ser;
    @RequestMapping("/insertSingleStud")
    @ResponseBody
    void insertSingle(@RequestBody Student s1){
        ser.insertSingle(s1);
    }
    @RequestMapping("/insertMultipleStud")
    @ResponseBody
    void insertMultiple(@RequestBody List<Student> studentList){
        ser.insertMultiple(studentList);
    }
    @RequestMapping("/selectSingleStud")
    @ResponseBody
    Student selectSingle(@RequestParam int sid,@RequestParam int tid){
        return ser.selectSingle(sid,tid);
    }
    @RequestMapping("/selectMultipleStud")
    @ResponseBody
    List<Student> selectMultiple(@RequestParam List<Integer>sids,@RequestParam List<Integer>tids){
        return ser.selectMultiple(sids,tids);
    }
    @RequestMapping("/selectAllStud")
    @ResponseBody
    List<Student> selectAll(){
        return ser.selectAll();
    }
    @RequestMapping("updateSingleStud")
    @ResponseBody
    Student updateSingle(@RequestBody Student s1){
        return ser.updateSingle(s1);
    }
    @RequestMapping("updateMultipleStud")
    @ResponseBody
    List<Student> updateMultiple(@RequestBody List<Student> studentList1){
        return ser.updateMultiple(studentList1);
    }
    @RequestMapping("/deleteSingleStud")
    @ResponseBody
    Boolean deleteSingle(@RequestParam int sid,@RequestParam int tid){
        return ser.deleteSingle(sid,tid);
    }
    @RequestMapping("/deleteMultipleStud")
    @ResponseBody
    Boolean deleteMultiple(@RequestParam List<Integer>sids,@RequestParam List<Integer>tids){
        return ser.deleteMultiple(sids,tids);
    }
    @RequestMapping("/deleteAll")
    @ResponseBody
    Boolean deleteAll(){
        return ser.deleteAll();
    }

}
