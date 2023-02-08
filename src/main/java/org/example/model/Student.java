package org.example.model;

public class Student{
    Teacher t1;
    int id;
    String name,email;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Teacher getT1() {
        return t1;
    }

    public void setT1(Teacher t1) {
        this.t1 = t1;
    }

}
