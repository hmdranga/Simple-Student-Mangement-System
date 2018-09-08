/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.reg.business.BOFactory;
import lk.ijse.reg.business.SuperBO;
import lk.ijse.reg.business.custom.CourseBO;
import lk.ijse.reg.business.custom.RegisterBO;
import lk.ijse.reg.dao.DAOFactory;
import lk.ijse.reg.dao.custom.RegisterDAO;
import lk.ijse.reg.dto.RegisterDTO;
import lk.ijse.reg.entity.Registration;
import lk.ijse.reg.entity.Registration_PK;


public class RegisterBOImpl implements RegisterBO {
    
    RegisterDAO registerDAOImpl;

    public RegisterBOImpl() {
       this.registerDAOImpl = (RegisterDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.REGISTER);
    }
    
    @Override
    public boolean saveRegister(RegisterDTO dto) throws Exception {
       return registerDAOImpl.save(new Registration(dto.getCid(), dto.getSid(), dto.getDate(), dto.getFee()));

    }

    @Override
    public ArrayList<RegisterDTO> getAllRegisters() throws Exception {
         ArrayList<Registration> allRegisters = registerDAOImpl.getAll();
        ArrayList<RegisterDTO> dtos = new ArrayList<>();
        
        for (Registration register : allRegisters) {
            RegisterDTO registerDTO = new RegisterDTO(register.getRegistration_pk().getCid(), register.getRegistration_pk().getSid(), register.getReg_date(), register.getFee());
            dtos.add(registerDTO);
        }
        
        return dtos;
    }

    @Override
    public ArrayList<String> getValRegisters() throws Exception {
        CourseBO courseBOImpl = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.COURSE);
        return courseBOImpl.getCourseID(); 
    }

    @Override
    public boolean deleteRegister(RegisterDTO dto) throws Exception {
        Registration_PK key=new Registration_PK(dto.getCid(), dto.getSid());
        return registerDAOImpl.delete(key);
    }
    
}
