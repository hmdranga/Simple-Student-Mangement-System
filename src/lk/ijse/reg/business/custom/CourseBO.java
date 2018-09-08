/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.business.custom;

import java.util.ArrayList;
import lk.ijse.reg.business.SuperBO;
import lk.ijse.reg.dto.CourseDTO;

/**
 *
 * @author A C E R
 */
public interface CourseBO extends SuperBO{
    
    public boolean saveCourse(CourseDTO dto) throws Exception;
    
    public ArrayList<CourseDTO> getAllCourses() throws Exception;
    
    public boolean deleteCourse(String courseId) throws Exception;
    
    public ArrayList<String> getCourseID() throws Exception;
}
