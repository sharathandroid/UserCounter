package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserCounter
 */
public class UserCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int random=0;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCounter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Random randomGenerator= new Random();
		random++;
		response.setContentType("text/html");
		response.getWriter()
			.append("<html> <body>")
			.append("User Count is " + random)
			.append("You are getting response from the doGet")
			.append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter()
		.append("<html> <body>")
		.append("You are getting response from the doPost")
		.append("</body></html>");
	}

}
