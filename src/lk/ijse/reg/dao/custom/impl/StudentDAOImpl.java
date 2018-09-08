/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.reg.dao.CrudUtil;
import static lk.ijse.reg.dao.CrudUtil.executeUpdate;
import lk.ijse.reg.dao.custom.StudentDAO;
import lk.ijse.reg.db.DBConnection;
import lk.ijse.reg.entity.Student;

/**
 *
 * @author A C E R
 */
public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean save(Student entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO student VALUES (?,?,?)", entity.getSid(),entity.getName(),entity.getAddress());
//         Connection connection = DBConnection.getInstance().getConnection();
//        
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO student VALUES (?,?,?)");
//        
//        Student student = (Student) entity;
//        pstm.setObject(1, student.getSid());
//        pstm.setObject(2, student.getName());
//        pstm.setObject(3, student.getAddress());
//        
//        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Student student) throws Exception {
        return CrudUtil.executeUpdate("UPDATE student SET name=?, address=? WHERE sid=?", student.getName(),student.getAddress(),student.getSid());
                
//        Connection connection = DBConnection.getInstance().getConnection();
//        
//        PreparedStatement pstm = connection.prepareStatement("UPDATE student SET name=?, address=? WHERE sid=?");
//        
//        pstm.setObject(1, student.getName());
//        pstm.setObject(2, student.getAddress());
//        pstm.setObject(3, student.getSid());
//        
//        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean delete(String studentId) throws Exception {
        return  CrudUtil.executeUpdate("DELETE FROM student WHERE sid=?", studentId);
//        Connection connection = DBConnection.getInstance().getConnection();
//        
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM student WHERE sid=?");
//        
//        pstm.setObject(1, studentId);
//        
//        return pstm.executeUpdate() >0;
    }

    @Override
    public Student find(String studentId) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM student WHERE sid=?", studentId);
//        Connection connection = DBConnection.getInstance().getConnection();
//        
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM student WHERE sid=?");
//        
//        pstm.setObject(1, studentId);
//        
//        ResultSet rst = pstm.executeQuery();
        
        if (rst.next()){
            
            return new Student(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Student> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM student");
//        Connection connection = DBConnection.getInstance().getConnection();
//        
//        Statement stm = connection.createStatement();
//        
//        ResultSet rst = stm.executeQuery("SELECT * FROM student");
        
        ArrayList<Student> alStudents = new ArrayList<>();
        
        while(rst.next()){
            
            Student student = new Student(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
            
            alStudents.add(student);
            
        }
        
        return alStudents;
    }

    
    
}
