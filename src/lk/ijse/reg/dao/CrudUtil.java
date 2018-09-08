/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lk.ijse.reg.db.DBConnection;

/**
 *
 * @author A C E R
 */
public class CrudUtil {
    private static PreparedStatement getPreparedStatement(String sql,Object...args)throws Exception{
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pstm.setObject(i+1,args[i]);  
        }
        return pstm;
    }
    
    
    public static boolean executeUpdate(String sql,Object...args)throws Exception{
    
    return getPreparedStatement(sql, args).executeUpdate()>0;
    }
    
    public static ResultSet executeQuery(String sql,Object...args)throws Exception{
        return getPreparedStatement(sql, args).executeQuery();
    }

}
