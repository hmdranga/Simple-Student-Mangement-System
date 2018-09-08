/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.business.custom;

import java.util.ArrayList;
import lk.ijse.reg.business.SuperBO;
import lk.ijse.reg.dto.RegisterDTO;

/**
 *
 * @author A C E R
 */
public interface RegisterBO extends SuperBO{
    
   public boolean saveRegister(RegisterDTO dto) throws Exception;
   
   public ArrayList<RegisterDTO> getAllRegisters() throws Exception;
   
   public ArrayList<String>getValRegisters() throws Exception;
   
   public boolean deleteRegister(RegisterDTO dto) throws Exception;
}
