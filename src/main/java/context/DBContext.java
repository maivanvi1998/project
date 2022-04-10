package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.batch.Main;

public class DBContext {

	private final String user = "sa";
	private final String pass = "123456";
	private final String severName = "\\MSSQLSERVER01";
	private final String dbName = "ShoppingDB";
	private final String portNumber = "1433";
	private final String instance = "";

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		String dbURL = "jdbc:sqlserver://" + severName + ":" + portNumber + "\\" + instance + ";databaseName ="
				+ dbName;
		if (instance == null || instance.trim().isEmpty()) {
			dbURL = "jdbc:sqlserver://" + severName + ":" + portNumber + ";databaseName =" + dbName;
		}
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(dbURL, user, pass);

	}
}
