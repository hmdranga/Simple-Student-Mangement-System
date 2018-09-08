/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.dao;

import lk.ijse.reg.dao.custom.impl.CourseDAOImpl;
import lk.ijse.reg.dao.custom.impl.QueryDAOImpl;
import lk.ijse.reg.dao.custom.impl.RegisterDAOImpl;
import lk.ijse.reg.dao.custom.impl.StudentDAOImpl;

/**
 *
 * @author A C E R
 */
public class DAOFactory {
    private static DAOFactory daoFactory;
    
    public enum DaoTypes{
        COURSE,REGISTER,STUDENT,QUERY;
    }
    
    private DAOFactory(){ 
    }
    
    public static DAOFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    
    public SuperDAO getDAO(DaoTypes daoType){
        switch(daoType){
            case COURSE:
                return new CourseDAOImpl();
            case REGISTER:
                return new RegisterDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
    
    
}
