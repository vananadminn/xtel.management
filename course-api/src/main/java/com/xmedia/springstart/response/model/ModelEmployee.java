package com.xmedia.springstart.response.model;

import com.xmedia.springstart.model.Employee.Employee;

import java.util.Date;

public class ModelEmployee {
    public static Employee update(Employee model, int id) {
        Date date = new Date();
        model.setId(id);
        model.setName(model.getName());
        model.setPhone(model.getPhone());
        model.setEmail(model.getEmail());
        model.setEmployeeDate(model.getEmployeeDate());
        model.setEndDate(model.getEndDate());
        model.setStatus(model.getStatus());
        model.setNote(model.getNote());
        model.setStatusProject(model.getStatusProject());
        return model;
    }

    public static Employee set(Employee modelEmp) {
        Date date = new Date();
        modelEmp.setName(modelEmp.getName());
        modelEmp.setPhone(modelEmp.getPhone());
        modelEmp.setEmail(modelEmp.getEmail());
        modelEmp.setStartDate(date);
        modelEmp.setStatus(true);
        modelEmp.setNote(modelEmp.getNote());
        modelEmp.setCreatedBy(modelEmp.getCreatedBy());
        modelEmp.setStatusProject(modelEmp.getStatusProject());
        return modelEmp;
    }
}
