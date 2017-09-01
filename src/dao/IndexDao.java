package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class IndexDao {
	public static final String DRIVER="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://127.0.0.1:3306/onlinestudy";
	public static final String USER="root";
    public static final String PWD="root";
    
    Connection getCon() throws ClassNotFoundException,SQLException{
    	Class.forName(DRIVER);
		Connection con=DriverManager.getConnection(URL,USER,PWD);
		return con;
    }
	
	public Result getList(String sql){
		 Result result=null;
			try {
//				1.��������
				Connection con=getCon();
//				2.����״̬��
				Statement stmt=con.createStatement();//����������һ��Statementʵ����ͨ����ִ���޲�����SQL���ʱ������ʵ����
//				3.���ɽ����
				ResultSet rs=stmt.executeQuery(sql);//���ؽ����
//				4.���н������
				//�������ݿ�ʱresultset��ʼ�պ����ݿⱣ����ϵ����ӳ��һ����ά��result�����˷���ִ����ʱ�����Ͻӿںͽ�������ᱻ���գ����ܱ���ʹ�ã��������������ط�ʹ�á�
				result=ResultSupport.toResult(rs);//
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	}
}