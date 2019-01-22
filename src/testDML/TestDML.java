package testDML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//练习mysql的DML(Data Manipulation Language)数据操作语言：update、delete、insert
public class TestDML {

	public static void main(String[] args) {
		
		Statement st = null;
		Connection coon = null;
		
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.建立连接
			coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping", "root", "1064240329");
			//3.创建执行sql语句的对象
			st = coon.createStatement();
			//4.书写sql语句   此处为插入语句
			String sql = "insert into userinfo values (null,'zl','1233','23')";
			//5.执行sql语句
			st.executeUpdate(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//释放资源
			try {
				if(st!=null) {
					st.close();
					st = null;
				}
				if(coon != null) {
					coon.close();
					coon = null;
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
