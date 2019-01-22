package testDML;
//�ɸ��µĽ�������˽⼴��

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
					ResultSet.CONCUR_UPDATABLE  //���������ʽ����ʱ�����Խ��и��²���
					);
			//st.executeUpdate("UPDATE userinfo set UserName = 'Updatable' where UserId = 13");
			ResultSet rs = st.executeQuery("select * from userinfo");
			rs.next();
			
			//����һ������
			/*rs.updateString("UserName", "Updatable1");  //���ڴ���ִ�еĲ���
			rs.updateRow();  //�����ݿ�����������Ϣ
			*/
			
			//��������
			/*rs.moveToInsertRow();  //�ڽ�������һ����¼�������һ���µ�����
			rs.updateString("UserName", "Updatable2");
			rs.updateString("UserPassword", "Updatable2");
			rs.updateInt("UserAge", 2);
			rs.insertRow();*/
			
			//������Ƶ��½�����
			rs.moveToCurrentRow();
			
			/*//ɾ����
			rs.absolute(4);  //ֱ�Ӷ�λ����4��
			rs.deleteRow();*/
			
			//ȡ������
			rs.cancelRowUpdates();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
