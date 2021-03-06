package service;

import java.util.ArrayList;

import javax.servlet.jsp.jstl.sql.Result;

import dao.StudentDao;
import entity.Student;

public class StudentService {
	StudentDao sDao = new StudentDao();
	
	// 添加学生
	public boolean add(Student student){
		String sql="insert into student(SStudentID,SName,SSex,SDepartment,SClass,SIntroduction,SEmail,SImg,SContactWay) values(?,?,?,?,?,?,?,?,?)";	
		String[] params=new String[]{
			student.getSStudentID(),
			student.getSName(),
			student.getSSex(),
			student.getSDepartment(),
			student.getSClass(),
			student.getSIntroduction(),
			student.getSEmail(),
			student.getSImg(),
			student.getSContactWay()
		};
		if(sDao.update(sql,params)>0){
			return true;
		}else
			return false;
	}
	
	// 获取学生列表
	public ArrayList<Student> getList(){
		ArrayList<Student> slist=new ArrayList<Student>();
		String sql="select * from student";
		Result result=sDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			Student s=new Student();
			s.setSID(Integer.valueOf(data[i][0].toString()));
			s.setSStudentID(data[i][1].toString());
			s.setSName(data[i][2].toString());
			s.setSSex(data[i][3].toString());
			s.setSDepartment(data[i][4].toString());
			s.setSClass(data[i][5].toString());
			s.setSIntroduction(data[i][6].toString());
			s.setSEmail(data[i][7].toString());
			s.setSImg(data[i][8].toString());
			s.setSContactWay(data[i][9].toString());
			slist.add(s);		
		}
		return slist;
	}
	
	public Student getstudent(Student student){
		Student s=new Student();
		String sql="select * from student where SID="+student.getSID();
		Result result =sDao.getList(sql);
		Object[][] data=result.getRowsByIndex();	//二维表
		//将查询到的结果集转化为二维数组
		for(int i=0;i<data.length;i++){
			//把字符串解析成相应的整形值
			//结构体
			s.setSID(Integer.valueOf(data[i][0].toString()));
			s.setSStudentID(data[i][1].toString());
			s.setSName(data[i][2].toString());
			s.setSSex(data[i][3].toString());
			s.setSDepartment(data[i][4].toString());
			s.setSClass(data[i][5].toString());
			s.setSIntroduction(data[i][6].toString());
			s.setSEmail(data[i][7].toString());
			s.setSImg(data[i][8].toString());
			s.setSContactWay(data[i][9].toString());
		}
		return s;
	}

	public boolean update(Student s){
		String sql="UPDATE student SET SStudentID ='"+s.getSStudentID()+
				"', SName ='"+s.getSName()+
				"', SSex ='"+s.getSSex()+
				"', SDepartment ='"+s.getSDepartment()+
				"', SClass ='"+s.getSClass()+
				"', SIntroduction ='"+s.getSIntroduction()+
				"', SEmail ='"+s.getSEmail()+
				"', SImg ='"+s.getSImg()+
				"', SContactWay ='"+s.getSContactWay()+
				"' where SID="+s.getSID();
		if(sDao.update(sql)>0){
			return true;
		}else 
			return false;
	}
	
	// 删除学生
	public boolean delete(Student s){
		String sql="DELETE from student where SID="+s.getSID();
		if(sDao.update(sql)>0){
			return true;
		}else 
			return false;
	}
	
	public Student getstudent(Student student,int j){
		Student s=new Student();
		String sql="";
		if(j==1){
			sql="select * from student where SName="+student.getSName();
		}
		if(j==2){
			sql="select * from student where SDepartment="+student.getSDepartment();
		}
		if(j==3){
			sql="select * from student where SStudentID="+student.getSStudentID();
		}
		Result result =sDao.getList(sql);
		Object[][] data=result.getRowsByIndex();//二维表
		//将查询到的结果集转化为二维数组
		for(int i=0;i<data.length;i++){
			//把字符串解析成相应的整形值
			//结构体
			s.setSID(Integer.valueOf(data[i][0].toString()));
			s.setSStudentID(data[i][1].toString());
			s.setSName(data[i][2].toString());
			s.setSSex(data[i][3].toString());
			s.setSDepartment(data[i][4].toString());
			s.setSClass(data[i][5].toString());
			s.setSIntroduction(data[i][6].toString());
			s.setSEmail(data[i][7].toString());
			s.setSImg(data[i][8].toString());
			s.setSContactWay(data[i][9].toString());
		}
		return s;
	}
	
	public ArrayList<Student> getList(Student stu,int j){
		ArrayList<Student> slist=new ArrayList<Student>();
		String sql="";
		if(j==1){
			sql="select * from student where SName="+stu.getSName();
		}
		if(j==2){
			sql="select * from student where SDepartment="+stu.getSDepartment();
		}
		if(j==3){
			sql="select * from student where SStudentID="+stu.getSStudentID();
		}
		Result result=sDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			Student s=new Student();
			s.setSID(Integer.valueOf(data[i][0].toString()));
			s.setSStudentID(data[i][1].toString());
			s.setSName(data[i][2].toString());
			s.setSSex(data[i][3].toString());
			s.setSDepartment(data[i][4].toString());
			s.setSClass(data[i][5].toString());
			s.setSIntroduction(data[i][6].toString());
			s.setSEmail(data[i][7].toString());
			s.setSImg(data[i][8].toString());
			s.setSContactWay(data[i][9].toString());
			slist.add(s);		
		}
		return slist;
	}

	public Student getstudentNew(Student student){
		Student s=new Student();
		String sql="select * from student where SName = '"+student.getSName()+"' and SPwd = '"+student.getSPwd()+"'";
		Result result =sDao.getList(sql);
		Object[][] data=result.getRowsByIndex();//二维表
		//将查询到的结果集转化为二维数组
		for(int i=0;i<data.length;i++){
			//把字符串解析成相应的整形值
			//结构体
			s.setSID(Integer.valueOf(data[i][0].toString()));
			s.setSStudentID(data[i][1].toString());
			s.setSName(data[i][2].toString());
			s.setSSex(data[i][3].toString());
			s.setSDepartment(data[i][4].toString());
			s.setSClass(data[i][5].toString());
			s.setSIntroduction(data[i][6].toString());
			s.setSEmail(data[i][7].toString());
			s.setSImg(data[i][8].toString());
			s.setSContactWay(data[i][9].toString());
		}
		return s;
	}
}
