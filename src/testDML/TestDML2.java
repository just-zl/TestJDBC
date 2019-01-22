package testDML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//在控制台输入数据，插入到数据库中

public class TestDML2 {

	public static void main(String[] args) {
		
		//法一，通过键盘输入参数
		/*Scanner scanner = new Scanner(System.in);  //控制台输入对象
		System.out.println("注册第一步：请输入用户名");
		String userName = scanner.nextLine();
		System.out.println("注册第二步：请输入用户密码");
		String userPassword = scanner.nextLine();
		System.out.println("注册第三步：请输入用户年龄");
		int userAge = Integer.parseInt(scanner.next());*/
		
		//法二，通过args[]数组传入参数
		//先判断输入的参数个数是否合法
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
		
		new TestDML2().insert(userName, userPassword, userAge);
	}
	
	public void insert(String userName,String userPassword,int userAge) {
		
		Statement  st = null;
		Connection conn = null;
		
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping","root","1064240329");
			//3.创建执行sql语句的对象
			st = conn.createStatement();
			//4.书写sql语句
			String sql = "insert into userinfo values (null,'"+userName+"','"+userPassword+"','"+userAge+"')";
			//5.执行sql语句
System.out.println(sql);
			st.executeUpdate(sql);
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//释放资源
			try {
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
