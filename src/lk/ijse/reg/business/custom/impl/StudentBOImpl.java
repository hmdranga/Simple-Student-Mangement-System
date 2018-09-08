/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.reg.business.custom.StudentBO;
import lk.ijse.reg.dao.DAOFactory;
import lk.ijse.reg.dao.custom.StudentDAO;
import lk.ijse.reg.dto.StudentDTO;
import lk.ijse.reg.entity.Student;


public class StudentBOImpl implements StudentBO {
   // StudentDAO studentDAO = DAOFactory.getInstance().
    StudentDAO studentDAO;

    public StudentBOImpl() {
        this.studentDAO=(StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.STUDENT);
    }
    
    
    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
       
       // Student student = new Student(dto.getSid(), dto.getName(), dto.getAddress());
        return studentDAO.save(new Student(dto.getSid(), dto.getName(), dto.getAddress()));
        
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        ArrayList<Student> allStudent = studentDAO.getAll();
        ArrayList<StudentDTO> dtos = new ArrayList<>();
        
        for (Student student : allStudent) {
            StudentDTO studentDTO = new StudentDTO(student.getSid(),student.getName(),student.getAddress());
            dtos.add(studentDTO);
        }
        
        return dtos;
    }

    @Override
    public boolean deleteCourse(String studentId) throws Exception {
         return studentDAO.delete(studentId);
    }
    
}
