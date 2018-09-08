/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author A C E R
 */
public class Registration {
    private Registration_PK registration_pk;
    private Date  reg_date;
    private BigDecimal fee;

    public Registration(Registration_PK registration_pk, Date reg_date, BigDecimal fee) {
        this.registration_pk = registration_pk;
        this.reg_date = reg_date;
        this.fee = fee;
    }
    public Registration(String cid, String sid, Date reg_date, BigDecimal fee) {
        this.registration_pk = new Registration_PK(cid, sid);
        this.reg_date = reg_date;
        this.fee = fee;
    }
   

    public Registration() {
    }

    /**
     * @return the registration_pk
     */
    public Registration_PK getRegistration_pk() {
        return registration_pk;
    }

    /**
     * @param registration_pk the registration_pk to set
     */
    public void setRegistration_pk(Registration_PK registration_pk) {
        this.registration_pk = registration_pk;
    }

    /**
     * @return the reg_date
     */
    public Date getReg_date() {
        return reg_date;
    }

    /**
     * @param reg_date the reg_date to set
     */
    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    /**
     * @return the fee
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Registration{" + "registration_pk=" + registration_pk + ", reg_date=" + reg_date + ", fee=" + fee + '}';
    }
    
}
