/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.reg.business.custom.CourseBO;
import lk.ijse.reg.dao.DAOFactory;
import lk.ijse.reg.dao.custom.CourseDAO;
import lk.ijse.reg.dto.CourseDTO;
import lk.ijse.reg.entity.Course;


public class CourseBOImpl implements CourseBO {
    
    private CourseDAO courseDAOImpl;
    
    public CourseBOImpl(){
       this.courseDAOImpl = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.COURSE);
    }
//     = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.COURSE);
    @Override
    public boolean saveCourse(CourseDTO dto) throws Exception {
        return courseDAOImpl.save(new Course(dto.getCid(), dto.getName(), dto.getDuration()));


    }

    @Override
    public ArrayList<CourseDTO> getAllCourses() throws Exception {
        ArrayList<Course> allCourse = courseDAOImpl.getAll();
        ArrayList<CourseDTO> dtos = new ArrayList<>();
        
        for (Course course : allCourse) {
            CourseDTO courseDTO = new CourseDTO(course.getCid(),course.getName(),course.getDuration());
            dtos.add(courseDTO);
        }
        
        return dtos;
    }

    @Override
    public boolean deleteCourse(String courseId) throws Exception {
         return courseDAOImpl.delete(courseId);
    }

    @Override
    public ArrayList<String> getCourseID() throws Exception {
          return courseDAOImpl.setVal();
    }
    
}
