package com.example.demo.entity;

public class User {
    private String id;
    private String name;
    private String password;
    private String sex;
    private String discribe;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDiscribe() {
        return discribe;
    }

    public void setDiscribe(String discribe) {
        this.discribe = discribe;
    }

    public String getId()
    {
        return id;
    }
    public  String getName()
    {
        return name;
    }
    public  String getPassword()
    {
        return password;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
    }
}
