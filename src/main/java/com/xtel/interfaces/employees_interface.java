package com.xtel.interfaces;

import java.util.ArrayList;
import com.xtel.entity.employee;

public interface employees_interface<emp> {

	public ArrayList<employee> getAllEmployees();

	public void insert(employee emp);

	public void update(employee emp);

	public void delete(String id);

	public employee find(String id);

	public ArrayList<employee> searchByName(String name);
}
