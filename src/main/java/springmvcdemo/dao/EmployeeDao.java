package springmvcdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import springmvcdemo.model.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployees();

	public Employee getEmployee(int id);

	@Transactional
	public boolean saveOrUpdateEmployee(Employee employee);

	public void deleteEmployee(int id);

}
