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

import lk.ijse.reg.dao.custom.CourseDAO;
import lk.ijse.reg.db.DBConnection;
import lk.ijse.reg.entity.Course;

/**
 *
 * @author A C E R
 */
public class CourseDAOImpl implements CourseDAO{

    public boolean save(Course entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO course VALUES (?,?,?)", entity.getCid(),entity.getName(),entity.getDuration());
//       Connection connection = DBConnection.getInstance().getConnection();
//        
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO course VALUES (?,?,?)");
//        
//        Course course = (Course) entity;
//        pstm.setObject(1, course.getCid());
//        pstm.setObject(2, course.getName());
//        pstm.setObject(3, course.getDuration());
//        
////        return pst;
//m.executeUpdate() > 0;
    }

    public boolean update(Course course) throws Exception {
         return CrudUtil.executeUpdate("UPDATE course SET name=?, duration=? WHERE cid=?", course.getName(),course.getDuration(),course.getCid());
//        Connection connection = DBConnection.getInstance().getConnection();
//        
//        PreparedStatement pstm = connection.prepareStatement("UPDATE course SET name=?, duration=? WHERE cid=?");
//        
//        pstm.setObject(1, course.getName());
//        pstm.setObject(2, course.getDuration());
//        pstm.setObject(3, course.getCid());
//        
//        return pstm.executeUpdate()>0;
    }

    public boolean delete(String courseId) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM course WHERE cid=?", courseId);
//        Connection connection = DBConnection.getInstance().getConnection();
//        
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM course WHERE cid=?");
//        
//        pstm.setObject(1, courseId);
//        
//        return pstm.executeUpdate() >0;
    }

    public Course find(String courseId) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM course WHERE cid=?", courseId);
        if(rst.next()){
            return new Course(rst.getString(1),
                   rst.getString(2),
                   rst.getString(3));
        
        }else{
            return null;
        }
//         Connection connection = DBConnection.getInstance().getConnection();
//        
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM course WHERE cid=?");
//        
//        pstm.setObject(1, courseId);
//        
//        ResultSet rst = pstm.executeQuery();
//        
//        if (rst.next()){
//            
//            return new Course(rst.getString(1),
//                    rst.getString(2),
//                    rst.getString(3));
//        }else{
//            return null;
//        }
    }

    public ArrayList<Course> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM course");
        ArrayList<Course> alCourse = new ArrayList<>();
        
        while(rst.next()){
            
            Course course = new Course(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
            
            alCourse.add(course);
        }
        return alCourse;
    }
        
//        Connection connection = DBConnection.getInstance().getConnection();
//        
//        Statement stm = connection.createStatement();
//        
//        ResultSet rst = stm.executeQuery("SELECT * FROM course");
//        
//        ArrayList<Course> alCourse = new ArrayList<>();
//        
//        while(rst.next()){
//            
//            Course course = new Course(rst.getString(1),
//                    rst.getString(2),
//                    rst.getString(3));
//            
//            alCourse.add(course);
//            
//        }
//        
//        return alCourse;
    
    @Override
    public  ArrayList<String>setVal() throws Exception{
        ResultSet rst = CrudUtil.executeQuery("Select cid from course");
          ArrayList<String> courses = new ArrayList<>();
            while (rst.next()){
                courses.add(rst.getString("cid"));
            }
            return courses;
    }
    
//      Connection connection = DBConnection.getInstance().getConnection();
//        
//        Statement stmt = connection.createStatement();
//        
//        ResultSet rst = stmt.executeQuery("Select cid from course");
//        
//       ArrayList<String> courses = new ArrayList<>();
//            while (rst.next()){
//                courses.add(rst.getString("cid"));
//            }
//            return courses;
//    }
}
