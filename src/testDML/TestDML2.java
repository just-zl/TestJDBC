package testDML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//�ڿ���̨�������ݣ����뵽���ݿ���

public class TestDML2 {

	public static void main(String[] args) {
		
		//��һ��ͨ�������������
		/*Scanner scanner = new Scanner(System.in);  //����̨�������
		System.out.println("ע���һ�����������û���");
		String userName = scanner.nextLine();
		System.out.println("ע��ڶ������������û�����");
		String userPassword = scanner.nextLine();
		System.out.println("ע����������������û�����");
		int userAge = Integer.parseInt(scanner.next());*/
		
		//������ͨ��args[]���鴫�����
		//���ж�����Ĳ��������Ƿ�Ϸ�
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
		
		new TestDML2().insert(userName, userPassword, userAge);
	}
	
	public void insert(String userName,String userPassword,int userAge) {
		
		Statement  st = null;
		Connection conn = null;
		
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping","root","1064240329");
			//3.����ִ��sql���Ķ���
			st = conn.createStatement();
			//4.��дsql���
			String sql = "insert into userinfo values (null,'"+userName+"','"+userPassword+"','"+userAge+"')";
			//5.ִ��sql���
System.out.println(sql);
			st.executeUpdate(sql);
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
