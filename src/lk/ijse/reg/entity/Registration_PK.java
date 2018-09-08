/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.entity;

/**
 *
 * @author A C E R
 */
public class Registration_PK {
    private String cid;
    private String sid;

    public Registration_PK(String cid, String sid) {
        this.cid = cid;
        this.sid = sid;
    }

    public Registration_PK() {
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

    @Override
    public String toString() {
        return "Registration_PK{" + "cid=" + cid + ", sid=" + sid + '}';
    }
    
}
