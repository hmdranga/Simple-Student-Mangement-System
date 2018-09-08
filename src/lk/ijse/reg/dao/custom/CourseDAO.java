/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.dao.custom;

import java.util.ArrayList;
import lk.ijse.reg.dao.CrudDAO;
import lk.ijse.reg.entity.Course;

/**
 *
 * @author A C E R
 */
public interface CourseDAO extends CrudDAO<Course,String>{
    public ArrayList<String> setVal() throws Exception;
}
