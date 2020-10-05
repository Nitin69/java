/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo2.dao;

import com.example.demo2.model.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Asus06
 */
public interface EmployeeDao extends CrudRepository<Employee, Integer>{
    
}
