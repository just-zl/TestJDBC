package testDML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//����һ�ָ��õķ�ʽ����дsql���
public class preStatement {

	public static void main(String[] args) {
		
		//��args�����������������
		if(args.length != 3) {
			System.out.println("�������������������������롢����");
			System.exit(-1);
		}
		
		String userName = args[0];
		String userPassword = args[1];
		int userAge = 0;
		try {
			userAge = Integer.parseInt(args[2]);
		}catch (NumberFormatException e) {
			System.out.println("�������Ϊ����");
			//�ǵ��˳�
			System.exit(-1);
		}
		
		//���ݿ⴦����
		PreparedStatement pst = null;
		Connection conn = null;
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ����							
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping","root","1064240329");
			//3.����ִ��sql���Ķ���
			pst = conn.prepareStatement("insert into userinfo values (null,?,?,?)");  //?����ռλ��
			//4.��ÿ��ռλ������������±��1��ʼ
			pst.setString(1, userName);
			pst.setString(2, userPassword);
			pst.setInt(3, userAge);
			//5.ִ�и���
			pst.executeUpdate();
			
 		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//6.TODO �ͷ���Դ
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
