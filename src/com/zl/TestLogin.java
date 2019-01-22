package com.zl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;

//基本可以当作登录mysql数据库的模板
public class TestLogin {
	
	/*//法一：不报错则连接成功
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");  //抛出ClassNotFoundException。可通过ctrl+shift+t查找Driver类
		//方式二：com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
		//方式三：new com.mysql.jdbc.Driver();
		
		//2.获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping", "root","1064240329");  //抛出SQLException。参数：连接字符串、数据库用户名、密码
	}*/
	
	//测试连接
	@Test
	public void TestLogin() {
		try {
			login("zy", 18);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//用户登录方法  不太完美，更好的代码请看LoginModel.java
	public void login(String userName,int userAge) throws ClassNotFoundException, SQLException {
		//1.向数据库的大管家 DriverManager注册驱动。Load the Driver     通过Class的forName()方法在内存中创建一个Driver类的对象，反射IO？  
		Class.forName("com.mysql.jdbc.Driver");  //抛出ClassNotFoundException。可通过ctrl+shift+t查找Driver类
		//方式二：com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
		//方式三：new com.mysql.jdbc.Driver();
		
		//2.获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping", "root","1064240329");  //抛出SQLException。参数：连接字符串、数据库用户名、密码
		//3.创建执行sql语句的对象
		Statement st = conn.createStatement();
		//4.书写mysql语句    熟悉字符串的拼接方法
		String sql = "SELECT * from userinfo WHERE " + "UserName = '"+userName+"' and UserAge = '"+ userAge+"' ";
		//5.执行sql语句
		ResultSet rs = st.executeQuery(sql);  //这是执行查询语句的方法。  2.执行insert、update、delete语句：executeUpdate()。3.boolean execute(),执行select返回true，执行其他语句返回false 
		//6.对结果集进行处理
		if(rs.next()) {  //行光标移到第一行
			//System.out.println(rs.getInt(1));
			System.out.println("ID:" + rs.getInt("UserId"));
			System.out.println("恭喜您，" + userName+"登录成功");
			System.out.println(sql);
		}
		else {
			System.out.println("用户名或密码有误");
		}
		//7.释放资源,后得到的先关闭。类似队列
		if(rs != null)  rs.close();
		if(st != null)  st.close();
		if(conn != null)  conn.close();
	}

}
