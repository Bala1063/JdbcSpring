/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdbcspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author BA391760
 */
public class TestMain {
    public static void main(String args[])
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("JdbcSpringConfig.xml");
        CreateTable createTable=context.getBean(CreateTable.class);
        //creating table
       // createTable.createTable();
        //inserting record
       // createTable.insertRecord(391762,"Vicky");
        //retriveing all records using list
      //  createTable.getAllRecords();
        //retriving all records map
      // createTable.getEmps();
        // retriving single record rowmapper internally and externally 
        createTable.viewEmpCreatingRowMapperInternally(391760);
        createTable.viewEmpCreatingRowmapperExternally(391760);
        
    }
}
