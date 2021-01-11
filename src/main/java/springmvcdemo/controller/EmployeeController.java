package springmvcdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import springmvcdemo.dao.EmployeeDao;
import springmvcdemo.model.Employee;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	// show add employee form

	@RequestMapping("/employeeForm")
	public ModelAndView displayAddEmployee() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageTitle", "Flexton Inc: Employee Registration Page");
		modelAndView.setViewName("employeeForm");
		return modelAndView;

	}

	// save employee to the database

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	@ResponseBody()
	public RedirectView addEmployee(@ModelAttribute Employee employee, HttpServletRequest httpServletRequest) {
		// System.out.println(employee);
		// inserting the object to database.
		this.employeeDao.saveOrUpdateEmployee(employee);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(httpServletRequest.getContextPath() + "/");
		return redirectView;

	}

	// delete employee from database
	@RequestMapping("/deleteEmployeeRecord/{id}")
	public RedirectView deleteEmployeeRecord(@PathVariable("id") int id, HttpServletRequest httpServletRequest) {

		RedirectView redirectView = new RedirectView();
		this.employeeDao.deleteEmployee(id);

		// sending back the index page.
		redirectView.setUrl(httpServletRequest.getContextPath() + "/");
		return redirectView;
	}

	// update employee form display
	@RequestMapping("/updateEmployeeRecordForm/{id}")
	public ModelAndView updateEmployeeRecord(@PathVariable("id") int id, HttpServletRequest httpServletRequest) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("updateForm");

		// getting employee from database.
		Employee employee = this.employeeDao.getEmployee(id);
		modelAndView.addObject("employee", employee);
		modelAndView.addObject("pageTitle", "Flexton Inc: Employee Update Page");
		return modelAndView;
	}

}
