package com.xtel.controller.employee;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xtel.entity.employee;
import com.xtel.service.service_employee;

@Controller
@RequestMapping("employee")
public class controller_add_employee {

	@Autowired
	private service_employee service = new service_employee();

	@RequestMapping("add")
	public String accessAddEmployee() {
		return "employee/add";
	}

	@PostMapping(params = "addEmployee")
	public String postProduct(ModelMap model, employee emp, @RequestParam("name") String name,
			@RequestParam("phone") String phone, @RequestParam("age") int age, @RequestParam("address") String address,
			@RequestParam("email") String email, @RequestParam("id_card") String id_card,
			@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("date_start_work") String date_start_work, @RequestParam("position") String position,
			@RequestParam("status") String status) {
		String id = UUID.randomUUID().toString();
		try {
			emp.setId(id);
			emp.setName(name);
			emp.setPhone(phone);
			emp.setAge(age);
			emp.setAddress(address);
			emp.setEmail(email);
			emp.setId_card(id_card);
			emp.setUsername(username);
			emp.setPassword(password);
			emp.setDate_start_work(date_start_work);
			emp.setDate_do_work_official(null);
			emp.setDate_end_work(null);
			emp.setStatus(status);
			emp.setPosition(position);
			service.insert(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/employee/list.html";
	}
}
