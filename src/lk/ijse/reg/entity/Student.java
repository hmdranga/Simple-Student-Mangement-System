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
public class Student {
    private String sid;
    private String name;
    private String address;

    public Student() {
    }

    public Student(String sid, String name, String address) {
        this.sid = sid;
        this.name = name;
        this.address = address;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + "sid=" + sid + ", name=" + name + ", address=" + address + '}';
    }
    
    
}
