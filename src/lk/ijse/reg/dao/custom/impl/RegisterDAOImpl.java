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
import lk.ijse.reg.dao.custom.RegisterDAO;
import lk.ijse.reg.db.DBConnection;
import lk.ijse.reg.entity.Registration;
import lk.ijse.reg.entity.Registration_PK;

/**
 *
 * @author A C E R
 */
public class RegisterDAOImpl implements RegisterDAO {

    @Override
    public boolean save(Registration entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO registration VALUES (?,?,curdate(),?)", entity.getRegistration_pk().getCid(),entity.getRegistration_pk().getSid(),entity.getFee());
        
//        Connection connection = DBConnection.getInstance().getConnection();
//        
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO registration VALUES (?,?,curdate(),?)");
//        
//        Registration registration = (Registration) entity;
//        pstm.setObject(1, registration.getRegistration_pk().getCid());
//        pstm.setObject(2, registration.getRegistration_pk().getSid());
//        //pstm.setObject(3, registration.getReg_date());
//        pstm.setObject(3, registration.getFee());
//        
//        return pstm.executeUpdate() > 0;
    }

    /**
     *
     * @param registration
     * @return
     * @throws Exception
     */
    @Override
    public boolean update(Registration registration) throws Exception {
            return CrudUtil.executeUpdate("UPDATE registration SET reg_date=curdate(), fee=? WHERE cid=? AND sid=?", registration.getFee(),registration.getRegistration_pk().getCid(),registration.getRegistration_pk().getSid());
//        Connection connection = DBConnection.getInstance().getConnection();
//        
//        PreparedStatement pstm = connection.prepareStatement("UPDATE registration SET reg_date=curdate(), fee=? WHERE cid=? AND sid=?");
//        
//        //pstm.setObject(1, registration.getReg_date());
//        pstm.setObject(1, registration.getFee());
//        pstm.setObject(2, registration.getRegistration_pk().getCid());
//        pstm.setObject(3, registration.getRegistration_pk().getSid());
//        
//        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean delete(Registration_PK key) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM registration WHERE cid=? AND sid=?", key.getCid(),key.getSid());
//      Connection connection = DBConnection.getInstance().getConnection();
//        
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM registration WHERE cid=? AND sid=?");
//        
//        pstm.setObject(1, key.getCid());
//        pstm.setObject(2, key.getSid());
//        
//        return pstm.executeUpdate() >0;
    }

    @Override
    public Registration find( Registration_PK key) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM registration WHERE cid=? AND sid=?",key.getCid(),key.getSid());
        if(rst.next()){
             return new Registration(rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getBigDecimal(4));
        }
        return null;
}
//      Connection connection = DBConnection.getInstance().getConnection();
//        
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM registration WHERE cid=? AND sid=?");
//
//        pstm.setObject(1, key.getCid());
//        pstm.setObject(2, key.getSid());
//        
//        ResultSet rst = pstm.executeQuery();
//        
//        if (rst.next()){
//            return new Registration(rst.getString(1),
//                    rst.getString(2),
//                    rst.getDate(3),
//                    rst.getBigDecimal(4));
//        }
//        
//        return null;
// }

    @Override
    public ArrayList<Registration> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM registration");
//        Connection connection = DBConnection.getInstance().getConnection();
//        
//        Statement stm = connection.createStatement();
//        
//        ResultSet rst = stm.executeQuery("SELECT * FROM registration");
//        
        ArrayList<Registration> alRegistrations = new ArrayList<>();
        
        while (rst.next()){
            
            Registration registerDTO = new Registration(rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getBigDecimal(4));
            
            alRegistrations.add(registerDTO);
        }
        
        return alRegistrations;
    }
     
}
