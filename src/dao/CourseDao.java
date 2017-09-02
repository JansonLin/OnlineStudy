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

public class CourseDao {
	public static final String DRIVER="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://127.0.0.1:3306/onlinestudy";
	public static final String USER="root";
    public static final String PWD="root";
    
    Connection getCon() throws ClassNotFoundException,SQLException{
    	Class.forName(DRIVER);
		Connection con=DriverManager.getConnection(URL,USER,PWD);
		return con;
    }
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
	
	public int getData(String sql){
		int result=0;
		try {
			Connection con=getCon();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				result = 1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public Result getList(String sql){
		 Result result=null;
			try {
//				1.创建连接
				Connection con=getCon();
//				2.生成状态集
				Statement stmt=con.createStatement();//创建并返回一个Statement实例，通常在执行无参数的SQL语句时创建该实例。
//				3.生成结果集
				ResultSet rs=stmt.executeQuery(sql);//返回结果集
//				4.进行结果处理
				//操作数据库时resultset会始终和数据库保持联系，再映射一个二维表result（当此方法执行完时，以上接口和结果集将会被回收，不能被再使用），可以在其他地方使用。
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
	public int update(String sql,String[] params){
		 int result=0;
		 try {
				Connection con=getCon();
				PreparedStatement pstmt=con.prepareStatement(sql);//执行带参SQL语句
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
