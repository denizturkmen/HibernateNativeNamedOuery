package com.denizturkmen.Client;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Util.HibernateUtil;

public class NamedNativeQueryEmployeeById {

	public static void main(String[] args) {
		
		int empId=1;
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query<Employee> query = session.getNamedNativeQuery("EmployeebyId");
			query.setParameter("empId", empId);
			Employee employee = query.uniqueResult();
			//System.out.println(employee.getDepartment().getDepartmentName());
			System.out.println(employee);
			
		}catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			if(session != null) {
				session.close();
			}
		}
		
	}
}
