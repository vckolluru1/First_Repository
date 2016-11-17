package Satpi;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

public class connection {

	public connection() throws Exception {
		
		
		try{
			Scanner sc = new Scanner(System.in);
			int no = sc.nextInt();
			String name = sc.next();
			sc.next();
			String last = sc.next();
			System.out.println("venky");
			String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "venky";
		Connection con = DriverManager.getConnection(url,username,password);
		
		Statement st = con.createStatement();
		
	//	String query = "create table employ(eno number(5), ename varchar(20),esal number(8,2))";
		String query = "insert into employees values("+no+",'"+name+"','"+last+"')";
		st.executeUpdate(query);
		System.out.println("Table created into the database");
		
		con.close();
		}  catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new connection();

	}

}
