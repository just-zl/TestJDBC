package testDML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//��ϰmysql��DML(Data Manipulation Language)���ݲ������ԣ�update��delete��insert
public class TestDML {

	public static void main(String[] args) {
		
		Statement st = null;
		Connection coon = null;
		
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��������
			coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping", "root", "1064240329");
			//3.����ִ��sql���Ķ���
			st = coon.createStatement();
			//4.��дsql���   �˴�Ϊ�������
			String sql = "insert into userinfo values (null,'zl','1233','23')";
			//5.ִ��sql���
			st.executeUpdate(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//�ͷ���Դ
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
