/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.angular_studentmanagement;

/**
 *
 * @author ADMIN
 */
public class Student {
    private int id;
    private String name;
    private String contract;
    private String subject;
    private String location;
    private String address;

    public Student() {
    }

    public Student(int id, String name, String contract, String subject, String location, String address) {
        this.id = id;
        this.name = name;
        this.contract = contract;
        this.subject = subject;
        this.location = location;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLocation() {
        return location;
    }

    public void setLocaton(String location) {
        this.location = location;
    }
    
}
