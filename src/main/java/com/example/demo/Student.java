package com.example.demo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private int age;

    private double gpa;

    @Column(updatable = false)
    private String createdAt;

    private String updatedAt;

    public Student(String firstName, String lastName, String email, int age, String createdAt, String updatedAt, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.gpa = gpa;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}