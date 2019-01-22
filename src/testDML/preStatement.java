package testDML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//用另一种更好的方式，来写sql语句
public class preStatement {

	public static void main(String[] args) {
		
		//从args数组里读入三个参数
		if(args.length != 3) {
			System.out.println("请输入三个参数：姓名、密码、年龄");
			System.exit(-1);
		}
		
		String userName = args[0];
		String userPassword = args[1];
		int userAge = 0;
		try {
			userAge = Integer.parseInt(args[2]);
		}catch (NumberFormatException e) {
			System.out.println("年龄必须为数字");
			//记得退出
			System.exit(-1);
		}
		
		//数据库处理部分
		PreparedStatement pst = null;
		Connection conn = null;
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接							
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping","root","1064240329");
			//3.创建执行sql语句的对象
			pst = conn.prepareStatement("insert into userinfo values (null,?,?,?)");  //?代表占位符
			//4.给每个占位符传入参数，下标从1开始
			pst.setString(1, userName);
			pst.setString(2, userPassword);
			pst.setInt(3, userAge);
			//5.执行更新
			pst.executeUpdate();
			
 		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//6.TODO 释放资源
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
