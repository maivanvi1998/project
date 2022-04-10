package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import context.DBContext;

public class Function {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean login(String user, String pass) throws ClassNotFoundException, SQLException {
		Connection conn = new DBContext().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select count(*) as count from Account where username=? and pass=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, user);
		ps.setString(2, pass);

		rs = ps.executeQuery();
		int count = 0;

		if (rs.next()) {
			count = (rs.getInt("count"));
		}

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void createAccount(String user, String pass) throws ClassNotFoundException, SQLException {
		Connection conn = new DBContext().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "insert into account(username,pass) values (?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, user);
		ps.setString(2, pass);
		ps.execute();
		ps.close();
	}

	public boolean exists(String user) throws ClassNotFoundException, SQLException {
		Connection conn = new DBContext().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select count(*) as count from Account where username=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, user);
		rs = ps.executeQuery();

		int count = 0;
		if (rs.next()) {
			count = rs.getInt("count");
		}

		if (count != 0) {
			return true;
		}
		return false;
	}
}

//	public static void main(String[] args) {
//		try {
//			if (exists("mvv")) {
//				System.out.println("da ton tai");
//			} else {
//				createAccount("mvv", "123", 1, "dsds","sadad","Asds");
//				System.out.println("thanh cong");
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
