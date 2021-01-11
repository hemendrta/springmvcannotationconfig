package springmvcdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;

import springmvcdemo.model.Employee;

@org.springframework.transaction.annotation.Transactional
@EnableTransactionManagement
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public EmployeeDaoImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	public EmployeeDaoImpl() {

	}

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = this.hibernateTemplate.loadAll(Employee.class);
		return employees;
	}

	public Employee getEmployee(int employeeId) {

		Employee employee = this.hibernateTemplate.get(Employee.class, employeeId);
		return employee;

	}

	@org.springframework.transaction.annotation.Transactional(readOnly = false)
	public boolean saveOrUpdateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.saveOrUpdate(employee);
		return true;
	}

	@org.springframework.transaction.annotation.Transactional(readOnly = false)
	public void deleteEmployee(int id) {

		Employee employee = this.hibernateTemplate.get(Employee.class, id);
		this.hibernateTemplate.delete(employee);

	}

}
