package com.xtel.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xtel.dao.dao_employee;
import com.xtel.entity.employee;
import com.xtel.interfaces.employees_interface;

@Service
public class service_employee implements employees_interface<employee> {

	@Autowired
	private dao_employee dao = new dao_employee();

	public ArrayList<employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

	public void insert(employee emp) {
		dao.insert(emp);
	}

	public void update(employee emp) {
		// TODO Auto-generated method stub
		dao.update(emp);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	public employee find(String id) {
		// TODO Auto-generated method stub
		return dao.find(id);
	}

	public ArrayList<employee> searchByName(String name) {
		// TODO Auto-generated method stub
		return dao.searchByName(name);
	}

}
