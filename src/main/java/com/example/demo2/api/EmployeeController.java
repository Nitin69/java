/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo2.api;

import com.example.demo2.dao.EmployeeDao;
import com.example.demo2.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus06
 */
@RestController
@RequestMapping
public class EmployeeController {
    @Autowired
    private EmployeeDao repository;
    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee){
        Employee save = repository.save(employee);
        return "succesfully saved";
    }
    @PostMapping("/adds")
    public String addEmployees(@RequestBody List<Employee> e){
        repository.saveAll(e);
        return "done";
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return repository.findById(id).orElse(null);
    }
    @GetMapping("/employees")
    public Iterable<Employee> getEmployees(){
        return repository.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        Employee e = repository.findById(id).get();
        if(e==null){
            return "not found";
        }
        repository.deleteById(id);
        return "deleted";
    }
    @PutMapping("/update")
    public String updateById(@RequestBody Employee e){
        Employee employee = repository.findById(e.getId()).get();
        if(employee==null){
            return "not found";
        }
        employee.setName(e.getName());
        repository.save(employee);
        return "updated"+employee.getName();
    }
}
