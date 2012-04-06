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

		// jdbc:MySQL://[host:port],[host:port].../[database][?参数名1][=参数值1][&参数名2][=参数值2]...

		// <module id="sms" version="1.0.0"> <service-point id="smssender"
		// interface="weaver.sms.SmsService"> <invoke-factory> <construct
		// class="weaver.sms.JdbcSmsService"> <set property="type"
		// value="Mysql"/> <set property="host" value="59.57.246.61"/> <set
		// property="port" value="3306"/> <set property="dbname" value="mas
		// <set property="dbcharset" value="GBK"/> <set property="username"
		// value="OATEST"/> <set property="password" value="123456789"/> <set
		// property="sql"
		// value="insert into api_mt_BBB(mobiles,content,is_wap) values(?,?,0)"/>
		// </construct> </invoke-factory> </service-point> </module>

		String url = "jdbc:MySql://59.57.246.61:3306/mas?user=OATEST&password=123456789&dbcharset=gb2312&characterEncoding=gb2312";
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
