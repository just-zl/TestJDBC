package testDML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//������һ�´������sql���

public class TestBatch {

	public static void main(String[] args) {
		
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��������
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinshopping","root","1064240329");
			
			/* 
			 * **********��һ******************
			//3.����ִ��sql���Ķ���
			Statement st = conn.createStatement();
			//4.������sql���
			st.addBatch("insert into userinfo values (null,'Batch1','Batch1','1')");
			st.addBatch("insert into userinfo values (null,'Batch2','Batch2','2')");
			st.addBatch("insert into userinfo values (null,'Batch3','Batch3','3')");
			st.executeBatch();
			//5.�ͷ���Դ
			st.close();
			********************************
			*/
			
			/*
			 * ***********����***************
			//3.����ִ��sql���Ķ���
			PreparedStatement pst = conn.prepareStatement("insert into userinfo values (null,?,?,?)");
			pst.setString(1, "Batch4");
			pst.setString(2, "Batch4");
			pst.setInt(3, 4);
			pst.addBatch();
			
			pst.setString(1, "Batch5");
			pst.setString(2, "Batch5");
			pst.setInt(3, 5);
			pst.addBatch();
			
			pst.setString(1, "Batch6");
			pst.setString(2, "Batch6");
			pst.setInt(3, 6);
			pst.addBatch();
			
			pst.executeBatch();
			
			//�ͷ���Դ
			pst.close();
			*********************************
			*/
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

}
