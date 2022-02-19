

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		String e = request.getParameter("email");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/workeremail","root",
					"password");
						
		PreparedStatement ps = con.prepareStatement("insert into WORKEREMAIL values(?)");
		
		ps.setString(1, e);
		
		int i = ps.executeUpdate();
		
		if (i > 0) {
			PrintWriter writer = response.getWriter();
			writer.println("<h1>" + "You have successfully added your email!" + "<h1>");
		
			writer.close();
		}
		
	}
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
			}
			// TODO Auto-generated method stub
			doGet(request, response);
			}
		}
	
