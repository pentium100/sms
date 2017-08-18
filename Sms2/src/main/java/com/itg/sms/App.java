package com.itg.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws SQLException {


		String url = "jdbc:MySql://172.16.10.201:3306/mas?&dbcharset=gb2312&characterEncoding=gb2312";
		//String url = "jdbc:MySql://59.57.246.61:3306/mas?&dbcharset=gb2312&characterEncoding=gb2312";
		Connection conn = DriverManager.getConnection(url, "OATEST", "123456789");

		//Statement st = conn.createStatement();
		PreparedStatement ps = conn.prepareStatement(
			      "insert into api_mt_BBB(mobiles,content,is_wap) values(?,?,0)");

		String[] mobiles = args[0].split("&");

		for (String mobile : mobiles) {
			ps.setString(1, mobile);
			ps.setString(2, args[1]);
			ps.executeUpdate();
		}
		ps.close();
		conn.close();

	}
}
