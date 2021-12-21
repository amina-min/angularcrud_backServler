/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.angular_studentmanagement;

/**
 *
 * @author ADMIN
 */
public class ApiResponse {
    private String msg;
    private Status status;

    public ApiResponse() {
        this.msg = "no massage";
        this.status = Status.FAILED;
    }

    public ApiResponse(String msg, Status status) {
        this.msg = msg;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
