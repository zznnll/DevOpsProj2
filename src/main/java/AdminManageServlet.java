
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class AdminManageServlet
 */
@WebServlet("/AdminManageServlet")
public class AdminManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3306/admindetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String INSERT_ADMINS_SQL = "INSERT INTO AdminDetails"
			+ " (name, date, gender, phone, role, type) VALUES " + " (?, ?, ?,?,?);";
	private static final String SELECT_ADMIN_BY_ID = "select name,date,gender,phone,role,type from AdminDetails where name =?";
	private static final String SELECT_ALL_ADMINS = "select * from AdminDetails ";
	private static final String DELETE_ADMINS_SQL = "delete from AdminDetails where name = ?;";
	private static final String UPDATE_ADMINS_SQL = "update AdminDetails set name = ?,date= ?, gender =?, phone=?, role =?, type =? where name = ?;";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminManageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/AdminManageServlet/delete":
				deleteAdmin(request, response);
				break;
			case "/AdminManageServlet/edit":
				showEditForm(request, response);
				break;
			case "/AdminManageServlet/update":
				updateAdmin(request, response);
				break;
			case "/AdminManageServlet/dashboard":
				listAdmins(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listAdmins(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Admin> admins = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADMINS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String date = rs.getString("date");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String role = rs.getString("role");
				String type = rs.getString("type");
				admins.add(new Admin(name, date, gender, phone, role, type));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// adminManagement.jsp
		request.setAttribute("listAdmins", admins);
		request.getRequestDispatcher("/adminManagement.jsp").forward(request, response);
	}

	// method to get parameter, query database for existing user data and redirect
	// to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String name = request.getParameter("name");
		Admin existingAdmin = new Admin("", "", "", "", "", "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_BY_ID);) {
			preparedStatement.setString(1, name);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				name = rs.getString("name");
				String date = rs.getString("date");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String role = rs.getString("role");
				String type = rs.getString("type");
				existingAdmin = new Admin(name, date, gender, phone, role, type);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("admin", existingAdmin);
		request.getRequestDispatcher("/adminEdit.jsp").forward(request, response);
	}

	// method to update the user table base on the form data
	private void updateAdmin(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
	//Step 1: Retrieve value from the request
	String oriName = request.getParameter("oriName");
	 String name = request.getParameter("name");
	 String date = request.getParameter("date");
	 String gender = request.getParameter("gender");
	 String phone = request.getParameter("phone");
	 String role = request.getParameter("role");
	 String type = request.getParameter("type");


	 //Step 2: Attempt connection with database and execute update user SQL query
	 try (Connection connection = getConnection(); PreparedStatement statement =
	connection.prepareStatement(UPDATE_ADMINS_SQL);) {
	 statement.setString(1, name);
	 statement.setString(2, date);
	 statement.setString(3, gender);
	 statement.setString(4, phone);
	 statement.setString(5, role);
	 statement.setString(6, type);
	 statement.setString(7, oriName);
	 int i = statement.executeUpdate();
	 }
	 //Step 3: redirect back to UserServlet (note: remember to change the url to your project name)
	 response.sendRedirect("http://localhost:8090/DevOpsProj1/AdminManageServlet/dashboard");
	}

	private void deleteAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String name = request.getParameter("name");
		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ADMINS_SQL);) {
			statement.setString(1, name);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to your project name)
		response.sendRedirect("http://localhost:8090/DevOpsProj1/AdminManageServlet/dashboard");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
