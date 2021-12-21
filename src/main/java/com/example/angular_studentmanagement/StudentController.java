


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.angular_studentmanagement;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class StudentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        StringBuilder sb = new StringBuilder();

        String line = "";
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        Gson gson = new Gson();
        Student st = gson.fromJson(sb.toString(), Student.class);
        ApiResponse apires = new ApiResponse();
        apires.setStatus(Status.SUCCESS);

        try {
            Student dbst = saveStudent(st);
            if (dbst != null) {
                apires.setMsg("Student insert successfull");
                apires.setStatus(Status.SUCCESS);
            } else {
                apires.setMsg("insert Failed");
                apires.setStatus(Status.FAILED);
            }

        } catch (ClassNotFoundException ex) {
            apires.setMsg(ex.getLocalizedMessage());
        } catch (SQLException ex) {
             apires.setMsg(ex.getLocalizedMessage());
        }

        resp.getWriter().print(gson.toJson(apires));

    }

    public static Student saveStudent(Student student) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getConnect();
        String sql = "insert into student(name, contract, subject, location, address) values(?, ?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, student.getName());
        pst.setString(2, student.getContract());
        pst.setString(3, student.getSubject());
        pst.setString(4, student.getLocation());
        pst.setString(5, student.getAddress());
        int rs = pst.executeUpdate();
        if (rs > 0) {
            return student;
        }
        return null;
    }

    
    
    
    
    
    
    
    
    
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Updateeeeeeeeee");
        BufferedReader br = req.getReader();
        StringBuilder sb = new StringBuilder();

        String line = "";
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        Gson gson = new Gson();
        Student st = gson.fromJson(sb.toString(), Student.class);
        ApiResponse apires = new ApiResponse();
        try {
            Student dbst = updateStudent(st);
            if (dbst != null) {
                apires.setMsg("Student update successfull");
                apires.setStatus(Status.SUCCESS);
            } else {
                apires.setMsg("update Failed");
                apires.setStatus(Status.FAILED);
            }

        } catch (ClassNotFoundException ex) {
            apires.setMsg(ex.getLocalizedMessage());
        } catch (SQLException ex) {
             apires.setMsg(ex.getLocalizedMessage());
        }

        resp.getWriter().print(gson.toJson(apires));     
    }
    
    public static Student updateStudent(Student student) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getConnect();
        String sql = "update student set name=?, contract = ?, subject = ?, location =?, address=? where id = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, student.getName());
        pst.setString(2, student.getContract());
        pst.setString(3, student.getSubject());
        pst.setString(4, student.getLocation());
        pst.setString(5, student.getAddress());
        pst.setInt(6, student.getId());
        int rs = pst.executeUpdate();
        if (rs > 0) {
            return student;
        }
        return null;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id = req.getParameter("id");
        System.out.println(id);      
        Gson gson = new Gson();
        ApiResponse apires = new ApiResponse();
        try {
            boolean isDeleted = deleteStudent(id);
            if (isDeleted) {
                apires.setMsg("Student Delete successfull");
                apires.setStatus(Status.SUCCESS);
            } else {
                apires.setMsg("Delete Failed");
                apires.setStatus(Status.FAILED);
            }

        } catch (ClassNotFoundException ex) {
            apires.setMsg(ex.getLocalizedMessage());
        } catch (SQLException ex) {
             apires.setMsg(ex.getLocalizedMessage());
        }

        resp.getWriter().print(gson.toJson(apires));       
        
    }
    
    public static boolean deleteStudent(String id) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getConnect();
        String sql = "delete from student where id = ?";
        PreparedStatement pst = conn.prepareStatement(sql);       
        pst.setInt(1, Integer.parseInt(id));
        int rs = pst.executeUpdate();
        if (rs > 0) {
            return true;
        }
        return false;
    }


   
    
    
    

}
