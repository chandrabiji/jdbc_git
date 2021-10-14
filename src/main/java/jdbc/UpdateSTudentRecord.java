package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateSTudentRecord {

	public static void main(String[] args) {
		try {
			//step1:Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step2:Establish the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/9pmist", "root", "root");
			//step3:Prepare the statement
			Statement st = con.createStatement();
			//step4:Execute the query
			int n = st.executeUpdate("UPDATE STUDENT SET sname='Sai',marks=98 WHERE sno=100");
			if(n!=0){
				System.out.println("---Student Table Updated Successfully----");
			}else{
				System.out.println("Notable to updated.Please try again....");
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
