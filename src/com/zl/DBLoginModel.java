package com.zl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//�����������������ݿ�ģ��
public class DBLoginModel {

	public static void main(String[] args) {
		
		ResultSet rs = null;
		Statement st = null;
		Connection conn = null;
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping", "root", "1064240329");
			//3.����ִ��sql���Ķ���
			st = conn.createStatement();
			//4.��дsql���
			String sql = "Select * from userinfo";
			//5.ִ��sql���,���ؽ����
			rs = st.executeQuery(sql);
			//6.�Խ�������д���
			while(rs.next()) {
				//rs.next();  //˵��rs.next()ִ�к󣬼����ж��Ƿ������ݣ�����������ݻ���������һ��
				System.out.println("id:"+rs.getInt("UserId")+",Name:"+rs.getString("UserName"));
			}
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//7.�ͷ���Դ
				if(rs != null) {
					rs.close();
					rs = null;  //rsִ��close()�������Զ����Լ����ó�null�ˣ��˴���Ҫ��Ա���
				}
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
