/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.angular_studentmanagement;

import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class ShowStudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        
        try {
            List<Student> st= showStudent();
             resp.getWriter().print(gson.toJson(st));            
        } catch (SQLException ex) {
            Logger.getLogger(ShowStudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShowStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
    public List<Student> showStudent() throws SQLException, ClassNotFoundException {
        
        List<Student> studentList = new ArrayList<>();

        Connection conn = DBConnection.getConnect();
        String sql = "select * from student";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            studentList.add(new Student(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("contract"),
                    rs.getString("subject"),
                    rs.getString("location"),
                    rs.getString("address")
            ));
            
        }

        return studentList;

    }

}
