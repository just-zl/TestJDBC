package testDML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//批处理，一下处理多条sql语句

public class TestBatch {

	public static void main(String[] args) {
		
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping","root","1064240329");
			
			/* 
			 * **********法一******************
			//3.创建执行sql语句的对象
			Statement st = conn.createStatement();
			//4.批处理sql语句
			st.addBatch("insert into userinfo values (null,'Batch1','Batch1','1')");
			st.addBatch("insert into userinfo values (null,'Batch2','Batch2','2')");
			st.addBatch("insert into userinfo values (null,'Batch3','Batch3','3')");
			st.executeBatch();
			//5.释放资源
			st.close();
			********************************
			*/
			
			/*
			 * ***********法二***************
			//3.创建执行sql语句的对象
			PreparedStatement pst = conn.prepareStatement("insert into userinfo values (null,?,?,?)");
			pst.setString(1, "Batch4");
			pst.setString(2, "Batch4");
			pst.setInt(3, 4);
			pst.addBatch();
			
			pst.setString(1, "Batch5");
			pst.setString(2, "Batch5");
			pst.setInt(3, 5);
			pst.addBatch();
			
			pst.setString(1, "Batch6");
			pst.setString(2, "Batch6");
			pst.setInt(3, 6);
			pst.addBatch();
			
			pst.executeBatch();
			
			//释放资源
			pst.close();
			*********************************
			*/
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

}
