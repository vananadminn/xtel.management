package com.xtel.controller.employee;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xtel.entity.employee;
import com.xtel.service.service_employee;

@Controller
@RequestMapping("employee")
public class controller_update_employee {

	@Autowired
	private service_employee service = new service_employee();

	@GetMapping("update")
	public String accessUpateEmployee() {
		return "employee/update";
	}

	@GetMapping("update/{id}")
	public String accessUpdate(ModelMap model, @PathVariable("id") String id, employee empId, HttpSession session) {
		empId = service.find(id);
		if (empId != null) {
			model.addAttribute("list", empId);
		} else {
			model.addAttribute("idIsEmpty", "Id not found");
		}
		return "employee/update";
	}

	@GetMapping(params = "updateEmployee")
	public String updateEmployee(ModelMap model, employee emp, @RequestParam("id") String id,
			@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("age") int age,
			@RequestParam("address") String address, @RequestParam("email") String email,
			@RequestParam("id_card") String id_card, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("date_start_work") String date_start_work,
			@RequestParam("date_do_work_official") String date_do_work_official,
			@RequestParam("date_end_work") String date_end_work, @RequestParam("position") String position,
			@RequestParam("status") String status) {
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
			emp.setDate_do_work_official(date_do_work_official);
			emp.setDate_end_work(date_end_work);
			emp.setStatus(status);
			emp.setPosition(position);
			service.update(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/employee/list.html";
	}

}
