package satpi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JDBCServlet
 */
@WebServlet("/JDBCServlet")
public class JDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			Scanner sc = new Scanner(System.in);
		/*	int no = sc.nextInt();
			String name = sc.next();
			sc.next();
			String last = sc.next();*/
			String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "venky";
		Connection con = DriverManager.getConnection(url,username,password);
		
		Statement st = con.createStatement();
		
		String query = "create table venky(eno number(5), ename varchar(20),esal int(8,2),lname varchar(20)";
		//String query = "insert into employees values("+no+",'"+name+"','"+last+"')";
		st.executeUpdate(query);
		System.out.println("Table created into the database");
		
		con.close();
		}  catch(Exception e)
		{
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
