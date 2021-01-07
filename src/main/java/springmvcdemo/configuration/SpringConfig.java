package springmvcdemo.configuration;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springmvcdemo.dao.EmployeeDao;
import springmvcdemo.dao.EmployeeDaoImpl;
import springmvcdemo.model.Employee;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "springmvcdemo")
public class SpringConfig {

	/* ViewResolver to identify the views location and extension. */

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();

		// setting the location where the views are located.
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");

		// setting the extension as we return string which does not have the location
		// and extension of the view.
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

	/* CommonsMultipartResolver for file uploading purposes. */

	@Bean
	public CommonsMultipartResolver commonsMultipartResolver() {

		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		return commonsMultipartResolver;

	}

	/* HibernateTemplate to perform CRUD operations. */

	@Bean(name = "hibernateTemplate")
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();

		// setting sessionfactory
		hibernateTemplate.setSessionFactory(sessionFactory);
		return hibernateTemplate;
	}

	/*
	 * SessionFactory for opening the session and performing the operations. Here we
	 * will also specify hibernate properties and entity classes location and names.
	 */

	@Bean(name = "sessionFactory")
	public SessionFactory sessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);

		// setting hibernate properties
		localSessionFactoryBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		localSessionFactoryBuilder.setProperty("hibernate.show_sql", "true");
		localSessionFactoryBuilder.setProperty("hibernate.hbm2ddl.auto", "create");

		// specifying the location of package in which the annotated classes are present
		// basically classes with @Entity annotation.
		localSessionFactoryBuilder.scanPackages("springmvcdemo.model");
		localSessionFactoryBuilder.addAnnotatedClass(Employee.class);
		return localSessionFactoryBuilder.buildSessionFactory();
	}

	/* DataSource object for setting the connection properties. */

	@Bean(name = "dataSource")
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// setting database properties.
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springdatabase");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;

	}

	/*
	 * Transaction Manager for persisting the changes during create, delete and
	 * update operations.
	 */

	@Bean(name = "hibernateTransactionManager")
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {

		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;

	}

	@Bean(name="employeeDao")
	public EmployeeDao employeeDao(HibernateTemplate hibernateTemplate) {

		EmployeeDao employeeDao = new EmployeeDaoImpl(hibernateTemplate);
		return employeeDao;
	}

}
