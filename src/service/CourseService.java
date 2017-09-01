package service;

import java.util.ArrayList;

import javax.servlet.jsp.jstl.sql.Result;

import dao.CourseDao;
import entity.Course;
import entity.Direction;
import entity.DirectoryLists;
import entity.Grade;
import entity.Sort;
import entity.Student;
import entity.CourseAndVideos;
import entity.Type;

public class CourseService {
	CourseDao cDao = new CourseDao();
	
	// 添加课程类型
	public boolean addCourseType(String direction,String sort,String type,String grade,int courseID){
		String sql="UPDATE course SET CDirection='"+direction+"',CSort='"+sort+"',CType='"+type+"',CClass='"+grade+"' WHERE CID='"+courseID+"'";
		if(cDao.update(sql)>0){
			return true;
		}else{
			return false;
		}
	}
	
	public ArrayList<CourseAndVideos> getFileName(Course course){
		ArrayList<CourseAndVideos> clist = new ArrayList<CourseAndVideos>();
		String sql = "select CAddress,VName from course,videos where CName like '%"+course.getCName()+"%' and course.identify=videos.identify";
		Result result = cDao.getList(sql);
		Object[][] data = result.getRowsByIndex();
		for (int i = 0; i < data.length; i++) {
			CourseAndVideos cv = new CourseAndVideos();
			cv.setCAddress(data[i][0].toString());
			cv.setVName(data[i][1].toString());
			clist.add(cv);
		}
		return clist;
	}
	
	// 保存课程的名称、地址
	public boolean saveCourse(String courseName,String coursePath){
		String sql="insert into course(CName,CAddress) values('"+courseName+"','"+coursePath+"')";
		if(cDao.update(sql)>0)
			return true;
		else
			return false;
	}
	
	// 保存文件名(视频名)
	public boolean saveFile(String fileName,String filePath,int courseID,int directoryListsID){
		String sql = "insert into videos(VCourseID,VDirectoryListsID,VName,VAddress) values('"+courseID+"','"+directoryListsID+"','"+fileName+"','"+filePath+"')";
		if(cDao.update(sql)>0)
			return true;
		else
			return false;
	}
	
	// 保存文件夹名(目录名)
	public boolean saveFolder(String folderName,String folderPath,int courseID){
		String sql = "insert into directorylists(DName,DCourseID,DAddress) values('"+folderName+"','"+courseID+"','"+folderPath+"')";
		if(cDao.update(sql)>0)
			return true;
		else
			return false;
	}
	
	// 获取课程的ID
	public ArrayList<Course> getCourseID(){
		ArrayList<Course> course=new ArrayList<Course>();
		String sql="SELECT * FROM course ORDER BY CID DESC LIMIT 1";
		Result result=cDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0; i<data.length; i++){
			Course c = new Course();
			c.setCID(Integer.parseInt(data[i][0].toString()));
			course.add(c);
		}
		return course;
	}
	
	// 获取当前文件夹ID
	public ArrayList<DirectoryLists> getDirectoryListsID(){
		ArrayList<DirectoryLists> slist=new ArrayList<DirectoryLists>();
		String sql="SELECT DID FROM directorylists ORDER BY DID DESC LIMIT 1";
		Result result=cDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			DirectoryLists d=new DirectoryLists();
			d.setDID(Integer.valueOf(data[i][0].toString()));
			slist.add(d);		
		}
		return slist;
	}

	// 获取方向  以便列举出来
	public ArrayList<Direction> getDirection(){
		ArrayList<Direction> slist=new ArrayList<Direction>();
		String sql="SELECT * FROM direction";
		Result result=cDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			Direction d=new Direction();
			d.setDir_ID(Integer.valueOf(data[i][0].toString()));
			d.setDir_Name(data[i][1].toString());
			slist.add(d);		
		}
		return slist;
	}
	
	// 获取分类  以便列举出来
	public ArrayList<Sort> getSort(){
		ArrayList<Sort> slist=new ArrayList<Sort>();
		String sql="SELECT * FROM sort";
		Result result=cDao.getList(sql);
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
	
	// 获取类型  以便列举出来
	public ArrayList<Type> getType(){
		ArrayList<Type> slist=new ArrayList<Type>();
		String sql="SELECT * FROM type";
		Result result=cDao.getList(sql);
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
	
	// 获取课程所属年级  以便列举出来
	public ArrayList<Grade> getGrade(){
		ArrayList<Grade> slist=new ArrayList<Grade>();
		String sql="SELECT * FROM grade";
		Result result=cDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			Grade g=new Grade();
			g.setGrade_ID(Integer.valueOf(data[i][0].toString()));
			g.setGrade_Name(data[i][1].toString());
			slist.add(g);		
		}
		return slist;
	}
	
	// 获取课程的ID
	public ArrayList<Course> getCourseList(){
		ArrayList<Course> course=new ArrayList<Course>();
		String sql="SELECT * FROM course";
		Result result=cDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0; i<data.length; i++){
			Course c = new Course();
			c.setCID(Integer.parseInt(data[i][0].toString()));
			c.setCName(data[i][1].toString());
			c.setCAddress(data[i][2].toString());
			c.setCDirection(data[i][3].toString());
			c.setCSort(data[i][4].toString());
			c.setCImgAddress(data[i][5].toString());
			c.setCClass(data[i][6].toString());
			c.setCContent(data[i][7].toString());
			course.add(c);
		}
		return course;
	}
	
	// 获取课程
	public Course getCourseList(Course course){
		Course c=new Course();
		String sql="select * from course where CID="+course.getCID();
		Result result =cDao.getList(sql);
		Object[][] data=result.getRowsByIndex();//二维表
		//将查询到的结果集转化为二维数组
		for(int i=0;i<data.length;i++){
			//把字符串解析成相应的整形值
			//结构体
			c.setCID(Integer.parseInt(data[i][0].toString()));
			c.setCName(data[i][1].toString());
			c.setCAddress(data[i][2].toString());
			c.setCDirection(data[i][3].toString());
			c.setCSort(data[i][4].toString());
			c.setCImgAddress(data[i][5].toString());
			c.setCClass(data[i][6].toString());
			c.setCContent(data[i][7].toString());
		}
		return c;
	}
	
	// 更新课程 修改课程信息
	public boolean updateCourse(Course c){
		String sql="UPDATE course SET CName ='"+c.getCName()+
				"', CAddress ='"+c.getCAddress()+
				"', CDirection ='"+c.getCDirection()+
				"', CSort ='"+c.getCSort()+
				"', CType ='"+c.getCType()+
				"', CImgAddress ='"+c.getCImgAddress()+
				"', CContent ='"+c.getCContent()+
				"' where CID="+c.getCID();
		if(cDao.update(sql)>0){
			return true;
		}else 
			return false;
	}
	
	// 添加封面图片
	public boolean addImg(Course course){
		String sql="insert into course(CImgAddress) values('"+course.getCImgAddress()+"')";	
		String[] params=new String[]{
				course.getCImgAddress()
				};
		if(cDao.update(sql,params)>0){
			return true;
		}else
			return false;
	}
	
	//删除课程
	public boolean deleteCourse(Course c){
		String sql="DELETE from course where CID="+c.getCID();
		if(cDao.update(sql)>0){
			return true;
		}else 
			return false;
	}
}
