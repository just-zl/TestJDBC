package com.zl;
//���õĵ�¼ģ��

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BetterModel {

	public static void main(String[] args) {
		
		Connection conn = null;
 		PreparedStatement pst = null;
		
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping", "root", "1064240329");
			//3.����ִ��sql���Ķ���
			pst = conn.prepareStatement("insert into userinfo values (null,?,?,?)");
			//4.����Ϊռλ���������
			pst.setString(1, "preStatement");
			pst.setString(2, "preStatement");
			pst.setInt(3, 222);
			//5.ִ�и���
			pst.executeUpdate();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//6.�ͷ���Դ
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
