package springmvcdemo.controller;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvcdemo.dao.EmployeeDao;
import springmvcdemo.model.Employee;

@Controller
public class MainController {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping("/")
	public ModelAndView displayHome(HttpServletRequest request) {
		List<Employee> employees = employeeDao.getEmployees();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageTitle", "Flexton Inc: Home Page");
		modelAndView.addObject("employees", employees);
		modelAndView.setViewName("index");
		return modelAndView;
	}

}
