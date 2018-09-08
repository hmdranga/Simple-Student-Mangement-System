/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.business;

import lk.ijse.reg.business.custom.impl.CourseBOImpl;
import lk.ijse.reg.business.custom.impl.RegisterBOImpl;
import lk.ijse.reg.business.custom.impl.StudentBOImpl;



/**
 *
 * @author A C E R
 */
public class BOFactory {
    private static BOFactory boFactory;

    private static BOFactory bOFactory;
    
    public enum BoTypes{
        COURSE, REGISTER,STUDENT;
    }
    
    private BOFactory(){
        
    }
    
    public static BOFactory getInstance(){
        if (bOFactory == null){
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }
    
    public SuperBO getBO(BoTypes boType){
        switch(boType){
            case COURSE:
                return new CourseBOImpl();
            case STUDENT:
                return new StudentBOImpl();
            case REGISTER:
                return new RegisterBOImpl();
            default:
                return null;
        }
    }
}
