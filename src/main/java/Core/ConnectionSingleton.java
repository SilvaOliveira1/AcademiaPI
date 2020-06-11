package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

	private static Connection con = null;
	private static String url = "jdbc:postgresql://labsql.fapce.edu.br:3024/fap_2020_1";
	private static String user = "obd_2018210207";
	private static String pass = "obd_2018210207";

	public ConnectionSingleton() {
	}

	public static Connection getConexao() {
		if (con == null) {
			try {
				con = (Connection) DriverManager.getConnection(getUrl(), getUser(), getPass());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	public static String getUrl() {
		return url;
	}

	public static String getUser() {
		return user;
	}

	public static String getPass() {
		return pass;
	}

}