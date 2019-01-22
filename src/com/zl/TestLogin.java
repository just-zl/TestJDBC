package com.zl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;

//�������Ե�����¼mysql���ݿ��ģ��
public class TestLogin {
	
	/*//��һ�������������ӳɹ�
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");  //�׳�ClassNotFoundException����ͨ��ctrl+shift+t����Driver��
		//��ʽ����com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
		//��ʽ����new com.mysql.jdbc.Driver();
		
		//2.��ȡ����
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping", "root","1064240329");  //�׳�SQLException�������������ַ��������ݿ��û���������
	}*/
	
	//��������
	@Test
	public void TestLogin() {
		try {
			login("zy", 18);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//�û���¼����  ��̫���������õĴ����뿴LoginModel.java
	public void login(String userName,int userAge) throws ClassNotFoundException, SQLException {
		//1.�����ݿ�Ĵ�ܼ� DriverManagerע��������Load the Driver     ͨ��Class��forName()�������ڴ��д���һ��Driver��Ķ��󣬷���IO��  
		Class.forName("com.mysql.jdbc.Driver");  //�׳�ClassNotFoundException����ͨ��ctrl+shift+t����Driver��
		//��ʽ����com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
		//��ʽ����new com.mysql.jdbc.Driver();
		
		//2.��ȡ����
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping", "root","1064240329");  //�׳�SQLException�������������ַ��������ݿ��û���������
		//3.����ִ��sql���Ķ���
		Statement st = conn.createStatement();
		//4.��дmysql���    ��Ϥ�ַ�����ƴ�ӷ���
		String sql = "SELECT * from userinfo WHERE " + "UserName = '"+userName+"' and UserAge = '"+ userAge+"' ";
		//5.ִ��sql���
		ResultSet rs = st.executeQuery(sql);  //����ִ�в�ѯ���ķ�����  2.ִ��insert��update��delete��䣺executeUpdate()��3.boolean execute(),ִ��select����true��ִ��������䷵��false 
		//6.�Խ�������д���
		if(rs.next()) {  //�й���Ƶ���һ��
			//System.out.println(rs.getInt(1));
			System.out.println("ID:" + rs.getInt("UserId"));
			System.out.println("��ϲ����" + userName+"��¼�ɹ�");
			System.out.println(sql);
		}
		else {
			System.out.println("�û�������������");
		}
		//7.�ͷ���Դ,��õ����ȹرա����ƶ���
		if(rs != null)  rs.close();
		if(st != null)  st.close();
		if(conn != null)  conn.close();
	}

}
