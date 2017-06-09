package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;
import service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;
	private StringBuilder employeeIdHolder;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        employeeService=(EmployeeService) new EmployeeServiceImpl();
        employeeIdHolder = new StringBuilder();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String employeeId = request.getParameter("employeeId");
		
		try {
			Employee employee=employeeService.getEmployeeInfo(Integer.parseInt(employeeId));
			response.setContentType("text/html");
			employeeIdHolder.append(employeeId);
			response.getWriter()
				.append("<html> <body>")
				.append("Employee Id: " + employee.getEmpNo())
				.append("<br>")
				.append("Employee Name: " + employee.getFirstName())
				.append("<br>")
				.append("BirthDate: " + employee.getBirthDate())
				.append("</body></html>");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
