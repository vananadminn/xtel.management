package com.xtel.controller.employee;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xtel.entity.employee;
import com.xtel.service.service_employee;

@Controller
@RequestMapping("employee")
public class controller_list_employee {

	@Autowired
	private service_employee service = new service_employee();

	@RequestMapping()
	public String accessHomeEmployee() {
		return "employee/list";
	}

	@RequestMapping("list")
	public String accessListEmployee(ModelMap model) {
		List<employee> list = new ArrayList<employee>();
		list = service.getAllEmployees();
		if (list.size() > 0 && list != null) {
			model.addAttribute("list", list);
		} else {
			model.addAttribute("listIsEmpty", "Employee list is empty");
		}
		return "employee/list";
	}

}
