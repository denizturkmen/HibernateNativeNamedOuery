package com.denizturkmen.Entity;


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;



@Entity
@Table(name="employee_table")
//Sql yazdığımınz içün java classları ile değil tablonun isimleriyle ilgilencez
@NamedNativeQueries(value = { 
		@NamedNativeQuery(name = "getTotalSalary", query = "select dept.DepartmentName as "
				+ "DepartmentName, sum(emp.salary) as TotalSalary from department_table dept left outer join "
				+ " employee_table emp  on dept.Department_Id=emp.Department_Id  group by  dept.Department_Id "
				+ "having  sum(emp.salary)>200000"),
		@NamedNativeQuery(name = "Employee.byId", query = "SELECT *FROM employee_table WHERE employee_id=:empId",resultClass=Employee.class) 
		})

public class Employee {

	@Id
	@Column(name="Employee_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer employeeId;
	
	@Column(name="Employee_Name",length=60,nullable=false)
	private String employeeName;
	
	@Column(name="Date_of_joining")
	private Date doj;
	
	@Column(name="Salary")
	private Double salary;
	
	@Column(name="Bonus")
	private BigDecimal bonus;
	
	@Column(name="Designation",length=50)
	private String designation;
	
	@Column(name="Email",unique=true,length=50)
	private String email;
	
	@ManyToOne
	@JoinColumn(name="Department_ID")
	private Department department;
	
	
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public BigDecimal getBonus() {
		return bonus;
	}
	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", doj=" + doj + ", salary="
				+ salary + ", bonus=" + bonus + ", designation=" + designation + ", email=" + email + ", department="
				+ department + "]";
	}


	
	
}
