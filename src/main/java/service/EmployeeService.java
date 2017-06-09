package service;

import java.sql.SQLException;

import servlet.Employee;

public interface EmployeeService {
	Employee getEmployeeInfo(int empNo) throws SQLException;
}
