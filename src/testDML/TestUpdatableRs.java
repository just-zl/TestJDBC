package testDML;
//可更新的结果集。了解即可

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdatableRs {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping","root","1064240329");
			Statement st = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE  //当并发访问结果集时，可以进行更新操作
					);
			//st.executeUpdate("UPDATE userinfo set UserName = 'Updatable' where UserId = 13");
			ResultSet rs = st.executeQuery("select * from userinfo");
			rs.next();
			
			//更新一行数据
			/*rs.updateString("UserName", "Updatable1");  //在内存里执行的操作
			rs.updateRow();  //在数据库里更新相关信息
			*/
			
			//插入新行
			/*rs.moveToInsertRow();  //在结果集最后一条记录后面插入一行新的数据
			rs.updateString("UserName", "Updatable2");
			rs.updateString("UserPassword", "Updatable2");
			rs.updateInt("UserAge", 2);
			rs.insertRow();*/
			
			//将光标移到新建的行
			rs.moveToCurrentRow();
			
			/*//删除行
			rs.absolute(4);  //直接定位到第4行
			rs.deleteRow();*/
			
			//取消更新
			rs.cancelRowUpdates();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
