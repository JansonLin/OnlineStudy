package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class StudentDao {
	public static final String DRIVER="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://127.0.0.1:3306/onlinestudy";
	public static final String USER="root";
    public static final String PWD="root";
    
    Connection getCon() throws ClassNotFoundException,SQLException{
    	Class.forName(DRIVER);
		Connection con=DriverManager.getConnection(URL,USER,PWD);
		return con;
    }

    public int getData(String sql){
		int result=0;
		try {
			Connection con=getCon();
			Statement stmt=con.createStatement();//����������һ��Statementʵ����ͨ����ִ���޲�����SQL���ʱ������ʵ����
//			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);//���ؽ����
			
//			if(rs.next()){
//				result=1;
//				System.out.println("11....."+result);
//			}
			ArrayList<Object> l = new ArrayList<Object>();
			Object o = new Object();
			while(rs.next()){
				result++;
				l.add(o);
			}
			System.out.println(l.size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
    
    // ����
    public int update(String sql){ 
		int result=0;
		try { 
			Connection con=getCon();
			Statement stmt=con.createStatement();
			result=stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
    
    // ��ȡ���ݿ��е�����   �����
    public Result getList(String sql){
		 Result result=null;
			try {
				Connection con=getCon();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				result=ResultSupport.toResult(rs);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
	}
    
    // ���´���
    public int update(String sql,String[] params){
		 int result=0;
		 try {
				Connection con=getCon();
				PreparedStatement pstmt=con.prepareStatement(sql);//ִ�д���SQL���
				for(int i=0;i<params.length;i++){
					/*String str=new String(params[i].getBytes("gbk"),"iso-8859-1");
					System.out.println(str);
					str=new String(str.getBytes("iso-8859-1"),"utf-8");
					System.out.println(str);*/
					pstmt.setObject(i+1, params[i]);
					
				}
				result=pstmt.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				// TODO: handle exception
			}
		 return result;
	 }
}
