package testDML;
//��DML����ͬ��ִ�У�(ɾ�������¡����)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping","root","1064240329");
			//3.��ֹ�Զ��ύ
			conn.setAutoCommit(false);  //Ĭ��Ϊtrue
			//4.�ø������
			st = conn.createStatement();
			st.addBatch("insert into userinfo values (null,'Transaction1','Transaction1','1')");
			st.addBatch("insert into userinfo values (null,'Transaction2','Transaction2','2')");
			st.executeBatch();
			//5.�ֶ��ύ
			conn.commit();  
			//6.�Ļ���
			conn.setAutoCommit(true); 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			//***********************************
			try {
				if(conn != null) {
					conn.rollback();  //��ִ��sql��������ִ�лع���������������䶼��ִ��
					conn.setAutoCommit(true);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			//***********************************
		} finally {
			//�ͷ���Դ
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
