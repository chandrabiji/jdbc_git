package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class GetSTudentDetails {

	public static void main(String[] args) {
		try {
			//step1:Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step2:Establish the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/9pmist", "root", "root");
			//step3:Prepare the statement
			Statement st = con.createStatement();
			//step4:Execute the query
			ResultSet rs = st.executeQuery("select * from student");
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnName(1)+"\t"+rsmd.getColumnName(2)+"\t"+rsmd.getColumnName(3));
			System.out.println("------------------------------------");
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
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
