package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import servlet.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	static Connection connection;

    {
        try {
            connection = createConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public Employee getEmployeeInfo(int empNo) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement statement = connection.prepareStatement("select * from employees where emp_no=? ");
        statement.setInt(1,empNo);

        ResultSet resultSet = statement.executeQuery();
     //   ArrayList<Employee> employeeList=new ArrayList<Employee>();
        //use resultset
        Employee employee = new Employee();

        while (resultSet.next()) {
            employee.setEmpNo(resultSet.getInt(1));
            employee.setBirthDate(resultSet.getDate(2));
            employee.setFirstName(resultSet.getString(3));
            employee.setLastName(resultSet.getString(4));
            employee.setGender(resultSet.getString(5));
            employee.setHireDate(resultSet.getDate(6));
          //  employeeList.add(employee);
        }
        return employee;
	}

	private Connection createConnection() throws ClassNotFoundException, SQLException {
        //register driver
       Class.forName("com.mysql.jdbc.Driver");

        //establish connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root1234");

        return connection;
    }

}
