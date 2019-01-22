package com.zl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//更加完美的连接数据库模板
public class DBLoginModel {

	public static void main(String[] args) {
		
		ResultSet rs = null;
		Statement st = null;
		Connection conn = null;
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping", "root", "1064240329");
			//3.创建执行sql语句的对象
			st = conn.createStatement();
			//4.书写sql语句
			String sql = "Select * from userinfo";
			//5.执行sql语句,返回结果集
			rs = st.executeQuery(sql);
			//6.对结果集进行处理
			while(rs.next()) {
				//rs.next();  //说明rs.next()执行后，既能判断是否还有数据，且如果有数据还能往后移一个
				System.out.println("id:"+rs.getInt("UserId")+",Name:"+rs.getString("UserName"));
			}
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//7.释放资源
				if(rs != null) {
					rs.close();
					rs = null;  //rs执行close()方法后，自动将自己设置成null了，此处主要针对笔试
				}
				if(st != null) {
					st.close();
					st = null;
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
