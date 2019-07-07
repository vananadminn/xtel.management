package com.xtel.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.xtel.service.service_employee;

@Controller
@RequestMapping("employee")
public class controller_delete_employee {

	@Autowired
	private service_employee service = new service_employee();

	@RequestMapping("/delete")
	public String delete(ModelMap model, @RequestParam("id") String id) {
		service.delete(id);
		return "redirect:/employee/list.html";

	}
}
