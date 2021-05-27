import java.sql.*;

class MysqlCon {

	private static final String jdbcURL = "jdbc:mysql://localhost:3306/crm?autoReconnect=true&useSSL=false";
	private static final String jdbcUsername = "remoteuser";
	private static final String jdbcPassword = "crms3cr3T";

	public static void main(String args[]) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded! Connecting as "+jdbcURL+" "+jdbcUsername+" "+jdbcPassword);
			Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
