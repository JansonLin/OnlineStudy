package service;

import java.util.ArrayList;

import javax.servlet.jsp.jstl.sql.Result;

import dao.AllCourseDao;
import entity.Course;
import entity.Direction;
import entity.DirectoryLists;
import entity.Sort;
import entity.Type;
import entity.Video;

public class AllCourseService {
	AllCourseDao clDao=new AllCourseDao();
	
	// 获取方向 direction
	public ArrayList<Direction> getDirectoryListsID(){
		ArrayList<Direction> slist=new ArrayList<Direction>();
		String sql="SELECT * FROM direction";
		Result result=clDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			Direction d=new Direction();
			d.setDir_ID(Integer.valueOf(data[i][0].toString()));
			d.setDir_Name(data[i][1].toString());
			slist.add(d);		
		}
		return slist;
	}
	
	// 获取分类 Sort
	public ArrayList<Sort> getSortID(){
		ArrayList<Sort> slist=new ArrayList<Sort>();
		String sql="SELECT * FROM sort";
		Result result=clDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			Sort s=new Sort();
			s.setSort_ID(Integer.valueOf(data[i][0].toString()));
			s.setSort_Name(data[i][1].toString());
			s.setSort_State(data[i][2].toString());
			slist.add(s);		
		}
		return slist;
	}
		
	public ArrayList<Sort> getSortID(int did){
		ArrayList<Sort> slist=new ArrayList<Sort>();
		String sql="SELECT * FROM sort where sort_State="+did;
		Result result=clDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			Sort s=new Sort();
			s.setSort_ID(Integer.valueOf(data[i][0].toString()));
			s.setSort_Name(data[i][1].toString());
			s.setSort_State(data[i][2].toString());
			slist.add(s);		
		}
		return slist;
	}
	// 获取方向 direction
	public ArrayList<Type> getTypeID(){
		ArrayList<Type> slist=new ArrayList<Type>();
		String sql="SELECT * FROM type";
		Result result=clDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			Type t=new Type();
			t.setType_ID(Integer.valueOf(data[i][0].toString()));
			t.setType_Name(data[i][1].toString());
			t.setType_State(data[i][2].toString());
			slist.add(t);		
		}
		return slist;
	}
	
	// 获取课程列表
	public ArrayList<Course> getCourseList(){
		ArrayList<Course> slist=new ArrayList<Course>();
		String sql="SELECT * FROM course";
		Result result=clDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			Course c=new Course();
			c.setCID(Integer.valueOf(data[i][0].toString()));
			c.setCName(data[i][1].toString());
			c.setCAddress(data[i][2].toString());
			c.setCDirection(data[i][3].toString());
			c.setCSort(data[i][4].toString());
			c.setCType(data[i][5].toString());
			c.setCImgAddress(data[i][6].toString());
			c.setCClass(data[i][7].toString());
			c.setCContent(data[i][8].toString());
			slist.add(c);		
		}
		return slist;
	}
	public ArrayList<Course> getCourseList(String sname){
		ArrayList<Course> slist=new ArrayList<Course>();
		String sql="SELECT CID,CName,CAddress,CDirection,CSort,CType,CImgAddress,CClass,CContent FROM sort,course where sort_ID=CSort and sort_Name='"+sname+"'";
		Result result=clDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			Course c=new Course();
			c.setCID(Integer.valueOf(data[i][0].toString()));
			c.setCName(data[i][1].toString());
			c.setCAddress(data[i][2].toString());
			c.setCDirection(data[i][3].toString());
			c.setCSort(data[i][4].toString());
			c.setCType(data[i][5].toString());
			c.setCImgAddress(data[i][6].toString());
			c.setCClass(data[i][7].toString());
			c.setCContent(data[i][8].toString());
			slist.add(c);		
		}
		return slist;
	}
	
	// 获取课程列表
	public ArrayList<DirectoryLists> getDirectoryLists(int courseID){
		ArrayList<DirectoryLists> slist=new ArrayList<DirectoryLists>();
		String sql="select * from directorylists WHERE DCourseID='"+courseID+"'";
		Result result=clDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			DirectoryLists d=new DirectoryLists();
			d.setDID(Integer.valueOf(data[i][0].toString()));
			d.setDCourseID(Integer.valueOf(data[i][1].toString()));
			d.setDName(data[i][2].toString());
			d.setDAddress(data[i][3].toString());
			slist.add(d);		
		}
		return slist;
	}
	
	// 获取视频列表
	public ArrayList<Video> getVideoLists(int courseID){
		ArrayList<Video> slist=new ArrayList<Video>();
		String sql="select * from videos WHERE VCourseID='"+courseID+"'";
		Result result=clDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			Video v=new Video();
			v.setVID(Integer.valueOf(data[i][0].toString()));
			v.setVCourseID(Integer.valueOf(data[i][1].toString()));
			v.setVDirectoryListsID(Integer.valueOf(data[i][2].toString()));
			v.setVName(data[i][3].toString());
			v.setVAddress(data[i][4].toString());
			slist.add(v);		
		}
		return slist;
	}
	
	
}
