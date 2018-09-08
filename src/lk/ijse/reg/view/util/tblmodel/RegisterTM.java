/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.view.util.tblmodel;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author A C E R
 */
public class RegisterTM {
    private String sid;
    private String cid;
    private Date date;
    private BigDecimal fee;

    public RegisterTM(String sid, String cid, Date date, BigDecimal fee) {
        this.sid = sid;
        this.cid = cid;
        this.date = date;
        this.fee = fee;
    }

    public RegisterTM() {
    }

    /**
     * @return the sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
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
        return "RegisterTM{" + "sid=" + sid + ", cid=" + cid + ", date=" + date + ", fee=" + fee + '}';
    }
    
}
