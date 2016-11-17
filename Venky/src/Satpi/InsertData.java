package Satpi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData  {

	public InsertData() {
		
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter NO");
			int no = sc.nextInt();
			System.out.println("Enter name");
			String name = sc.next();
			System.out.println("Enter Salary");
			//sc.next();
			double sal = sc.nextDouble();
		/*	System.out.println("Last");
			sc.next();
			String last = sc.nextLine();
			System.out.println("Venky"); */
			String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "venky";
		Connection con = DriverManager.getConnection(url,username,password);
		
		
		
	//	String query = "create table employ(eno number(5), ename varchar(20),esal number(8,2))";
	//	String query = "insert into employees values("+no+",'"+name+"',"+sal+")";
		String query = "insert into employees values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,no);
		ps.setString(2,name);
		ps.setDouble(3,sal);
		
		//System.out.println(query);
		ps.executeUpdate();
		
		
		con.close();
		}  catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
new InsertData();
		
	}

}
