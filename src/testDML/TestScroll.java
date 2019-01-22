package testDML;
//�ɹ����Ľ������һ��ʹ��next()�����ң��������ⷭ���Ĺ��������ڲ�ͬ�����ݿ⳧���ṩ��jdbc�Ŀ�����

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestScroll {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping","root","1064240329");
			Statement st = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,  //���öԹ���������
					ResultSet.CONCUR_READ_ONLY  //���������ʽ����ʱ��ֻ��ֻ������
					);
			ResultSet rs = st.executeQuery("select * from userinfo order by UserAge");
			rs.next();  //ȡ��һ����¼
			System.out.println(rs.getString(2));  //�������������Ľ�����ĵ�һ����¼�ĵ�һ���ֶΣ�Ҳ�����û���
			//System.out.println(rs.getString("UserName"));  //����һ�����һ��
			
			rs.last();  //ȡ���һ����¼
			System.out.println(rs.getString(2));
			System.out.println(rs.isLast());  //�ж��ǲ������һ����¼
			System.out.println(rs.isAfterLast());
			System.out.println(rs.getRow());  //���� ��¼ ���ܸ���
			
			rs.previous();
			System.out.println(rs.getString(2));
			
			rs.absolute(8);  //��ȡ��ָ������
			System.out.println(rs.getString(2));
			
			rs.close();
			st.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
