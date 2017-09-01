package service;

import dao.LogRegDao;

public class LogRegService {
	LogRegDao lrDao=new LogRegDao();
	public boolean reg(String SStudentID,String SPwd){
		String sql="insert into student(SStudentID,SPwd) values('"+SStudentID+"','"+SPwd+"')";
		
		if(lrDao.update(sql)>0)
			return true;
		else
			return false;
	   }
	public boolean log(String SStudentID,String SPwd){
		String sql="select * from student where SStudentID='"+SStudentID+"' and SPwd='"+SPwd+"'";
		if(lrDao.getData(sql)>0)
			return true;
		else
			return false;
	   }
	public boolean searchSStudentID(String SStudentID){
		String sql="select * from student where SStudentID='"+SStudentID+"'";
		if(lrDao.getData(sql)>0)
			return true;
		else
			return false;
	 }
}
