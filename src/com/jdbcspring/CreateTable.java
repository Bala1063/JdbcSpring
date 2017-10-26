/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbcspring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author BA391760
 */
public class CreateTable {

    private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }
//creating a table
    public void createTable() {
        jt.execute("create table emp(empno number(6),empname varchar(20))");
        System.out.println("Table Created");
    }
//droping a table
    public void dropTable() {
        jt.execute("drop table emp");
        System.out.println("Table Droped");
    }
//inserting new row
    public void insertRecord(int empno, String name) {
        int[] types = {Types.NUMERIC, Types.VARCHAR};
        Object[] params = {empno, name};
        jt.update("insert into emp values(?,?)", params, types);
        System.out.println("Inserted");
    }
//retrieving all records using list
    public void getAllRecords() {
        List list = jt.queryForList("Select * from emp");
        for (Object o : list) {
            System.out.println(o);
        }
    }
//Retrieving all records using map 
    public void getEmps() {
        List<Map<String, Object>> list = jt.queryForList("Select * from emp");
        for (Map<String, Object> map : list) {
            Iterator<Map.Entry<String, Object>> i = map.entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry<String, Object> e = i.next();
                System.out.println(e.getKey() + "  " + e.getValue());
            }
        }

    }
      //Viewing single record external  rowmapper
     public void viewEmpCreatingRowmapperExternally(int empno)
     {
     String sql="Select * from emp where empno=?";
     Employee employee=(Employee)jt.queryForObject(sql,new Object[] {empno},new EmpRowMapper());
     System.out.println(employee);
     }
     class EmpRowMapper implements RowMapper
     {

     @Override
     public Employee mapRow(ResultSet rs, int i) throws SQLException {
     Employee employee=new Employee();
     employee.setEmpno(rs.getInt(1));
     employee.setEmpname(rs.getString(2));
     return employee;
     }
        
     }

    // viewing single record without external rowmapper
    public void viewEmpCreatingRowMapperInternally(int empno) {
        String sql = "Select * from emp where empno=?";
        Employee employee = (Employee) jt.queryForObject(sql, new Object[]{empno}, new RowMapper<Employee>() {

            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setEmpno(rs.getInt(1));
                employee.setEmpname(rs.getString(2));
                return employee;
            }
        });
        System.out.println(employee);
    }
}
