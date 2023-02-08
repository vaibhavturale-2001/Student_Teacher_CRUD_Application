package org.example.repository;

import org.example.model.Student;
import org.example.model.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo implements StudentRepoImpl{
    String url="jdbc:mysql://localhost:3306/teststudent";
    String user="root";
    String pass="";
    @Override
    public void insertSingle(Student s1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,user,pass);
            Statement st=conn.createStatement();
            st.executeUpdate("insert into student values('"+s1.getId()+"','"+s1.getName()+"','"+s1.getEmail()+"')");
            st.executeUpdate("insert into teacher values('"+s1.getT1().getId()+"','"+s1.getT1().getName()+"','"+s1.getT1().getEmail()+"')");

        }catch(Exception e){
            System.out.println(e);
        }

    }
    @Override
    public  Student selectSingle(int sid,int tid){
        Student s1=new Student();
        Teacher t1=new Teacher();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,user,pass);
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from student where id='"+sid+"'");
            while(rs.next()){
                s1.setId(rs.getInt(1));
                s1.setName(rs.getString(2));
                s1.setEmail(rs.getString(3));
            }
            ResultSet rs1=st.executeQuery("select * from teacher where id='"+tid+"'");
            while(rs1.next()){
                t1.setId(rs1.getInt(1));
                t1.setName(rs1.getString(2));
                t1.setEmail(rs1.getString(3));
            }
            s1.setT1(t1);

        }catch(Exception e){
            System.out.println(e);
        }
        return  s1;
    }
    @Override
    public List<Student> selectAll(){
        List<Student>studentList=new ArrayList<>();
        List<Teacher> teacherList=new ArrayList<>();
        List<Student> studentsResult=new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,user,pass);
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from student");
            while(rs.next()){
                Student s1=new Student();
                s1.setId(rs.getInt(1));
                s1.setName(rs.getString(2));
                s1.setEmail(rs.getString(3));
                studentList.add(s1);
            }
            ResultSet rs1=st.executeQuery("select * from teacher");
            while(rs1.next()){
                Teacher t1=new Teacher();
                t1.setId(rs1.getInt(1));
                t1.setName(rs1.getString(2));
                t1.setEmail(rs1.getString(3));
                teacherList.add(t1);
            }
            for(int i=0;i<studentList.size();i++){
                if(teacherList.size()<i){
                    Student s2=studentList.get(i);
                    s2.setT1(teacherList.get(teacherList.size()));
                    studentsResult.add(s2);
                }else{
                    Student s2=studentList.get(i);
                    s2.setT1(teacherList.get(i));
                    studentsResult.add(s2);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return studentsResult;
    }
    @Override
    public  Student updateSingle(Student s1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,user,pass);
            Statement st=conn.createStatement();
            st.executeUpdate("update student set name='"+s1.getName()+"',email='"+s1.getEmail()+"'where id='"+s1.getId()+"'");
            st.executeUpdate("update teacher set name='"+s1.getT1().getName()+"',email='"+s1.getT1().getEmail()+"'where id='"+s1.getT1().getId()+"'");

        }catch(Exception e){
            System.out.println(e);
        }
        return selectSingle(s1.getId(),s1.getT1().getId());
    }
    @Override
    public Boolean deleteSingle(int sid, int tid){
        Boolean result=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,user,pass);
            Statement st=conn.createStatement();
            int studentResult=st.executeUpdate("delete from student where id='"+sid+"'");
            int teacherResult=st.executeUpdate("delete from teacher where id='"+tid+"'");
            if(studentResult>0||teacherResult>0){
                result=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return  result;
    }
    @Override
    public Boolean deleteAll(){
        Boolean result=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,user,pass);
            Statement st=conn.createStatement();
            int studentResult=st.executeUpdate("delete from student");
            int teacherResult=st.executeUpdate("delete from teacher");
            if(studentResult>0||teacherResult>0){
                result=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }
}
