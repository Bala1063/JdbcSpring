/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdbcspring;

/**
 *
 * @author BA391760
 */
public class Employee {
    private int empno;
    private String empname;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    @Override
    public String toString() {
        return "Employee{" + "empno=" + empno + ", empname=" + empname + '}';
    }
    
    
}
