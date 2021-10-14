package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudentRecord {

	public static void main(String[] args) {
		try {
			//step1:Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step2:Establish the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/9pmist", "root", "root");
			//step3:Prepare the statement
			Statement st = con.createStatement();
			//step4:Execute the query
			int n = st.executeUpdate("INSERT INTO STUDENT VALUES(100,'ABC',90)");
			if(n!=0){
				System.out.println("Successfully Student Record Inserted....");
			}else{
				System.out.println("Notable to Inserted.Please try again....");
			}
			//step5:Close the statement and connection
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
