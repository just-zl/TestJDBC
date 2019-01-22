package testDML;
//让DML操作同步执行，(删除、更新、添加)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping","root","1064240329");
			//3.阻止自动提交
			conn.setAutoCommit(false);  //默认为true
			//4.该干嘛干嘛
			st = conn.createStatement();
			st.addBatch("insert into userinfo values (null,'Transaction1','Transaction1','1')");
			st.addBatch("insert into userinfo values (null,'Transaction2','Transaction2','2')");
			st.executeBatch();
			//5.手动提交
			conn.commit();  
			//6.改回来
			conn.setAutoCommit(true); 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			//***********************************
			try {
				if(conn != null) {
					conn.rollback();  //若执行sql语句出错，则执行回滚，让上面两条语句都不执行
					conn.setAutoCommit(true);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			//***********************************
		} finally {
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
