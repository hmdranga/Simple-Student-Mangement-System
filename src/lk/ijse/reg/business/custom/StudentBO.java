/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.business.custom;

import java.util.ArrayList;
import lk.ijse.reg.business.SuperBO;
import lk.ijse.reg.dto.StudentDTO;


/**
 *
 * @author A C E R
 */
public interface StudentBO extends SuperBO{
    
    public boolean saveStudent(StudentDTO dto) throws Exception;
    
    public ArrayList<StudentDTO> getAllStudents() throws Exception;
    
    public boolean deleteCourse(String studentId) throws Exception;
}
