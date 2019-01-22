package testDML;
//可滚动的结果集。一般使用next()往下找，有无随意翻滚的功能依赖于不同的数据库厂商提供的jdbc的开发包

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
					ResultSet.TYPE_SCROLL_INSENSITIVE,  //设置对滚动不敏感
					ResultSet.CONCUR_READ_ONLY  //当并发访问结果集时，只能只读访问
					);
			ResultSet rs = st.executeQuery("select * from userinfo order by UserAge");
			rs.next();  //取第一条记录
			System.out.println(rs.getString(2));  //输出按年龄排序的结果集的第一条记录的第一个字段，也就是用户名
			//System.out.println(rs.getString("UserName"));  //和上一条结果一致
			
			rs.last();  //取最后一条记录
			System.out.println(rs.getString(2));
			System.out.println(rs.isLast());  //判断是不是最后一条记录
			System.out.println(rs.isAfterLast());
			System.out.println(rs.getRow());  //返回 记录 的总个数
			
			rs.previous();
			System.out.println(rs.getString(2));
			
			rs.absolute(8);  //读取到指定的行
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
