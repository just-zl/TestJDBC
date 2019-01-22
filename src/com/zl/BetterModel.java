package com.zl;
//更好的登录模板

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BetterModel {

	public static void main(String[] args) {
		
		Connection conn = null;
 		PreparedStatement pst = null;
		
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping", "root", "1064240329");
			//3.创建执行sql语句的对象
			pst = conn.prepareStatement("insert into userinfo values (null,?,?,?)");
			//4.依次为占位符传入参数
			pst.setString(1, "preStatement");
			pst.setString(2, "preStatement");
			pst.setInt(3, 222);
			//5.执行更新
			pst.executeUpdate();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//6.释放资源
			try {
				if(pst != null) {
					pst.close();
					pst = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
