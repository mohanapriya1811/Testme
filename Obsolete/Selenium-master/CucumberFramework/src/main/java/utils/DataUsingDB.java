package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.util.SystemOutLogger;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DataUsingDB {

	public static Object[][] getData() throws ClassNotFoundException, SQLException {

		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/sys";

		String uName = "root";
		String pwd = "Scope@123";

		Class.forName(jdbc_driver);

		Connection conn = DriverManager.getConnection(jdbc_url, uName, pwd);

		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

		String sql = "Select * From Testleaf.CompanyDetails";

		ResultSet result = stmt.executeQuery(sql);
		result.last();

		Object[][] data = new Object[result.getRow()][1];
		Map<Object, Object> map = new HashMap<>();
		/*
		 * Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		 * ResultSet.CONCUR_READ_ONLY); ResultSetMetaData meta = result.getMetaData();
		 * result.next(); System.out.println(result.getFetchSize());
		 * System.out.println(meta.getColumnCount());
		 */
		// result.first();
		// int row = result.getRow();
		// result.absolute(row);
		// result.first();
		// System.out.println(result.getRow());
		result.beforeFirst();
		// System.out.println(result.getRow());

		while (result.next()) {

			map = new HashMap<>();
			String username = result.getString("username");
			String password = result.getString("pwd");
			String companyname = result.getString("companyname");
			String firstname = result.getString("firstname");
			String lastname = result.getString("lastname");

			// System.out.println(username);

			map.put("username", username);
			map.put("password", password);
			map.put("companyname", companyname);
			map.put("firstname", firstname);
			map.put("lastname", lastname);
			// System.out.println(map);
			int row = result.getRow();
			data[row - 1][0] = map;
			System.out.println(data[row - 1][0]);
		}
		return data;

	}
	
	/*
	 * public static void main(String[] args) throws ClassNotFoundException,
	 * SQLException { getData();
	 * 
	 * }
	 */
}
