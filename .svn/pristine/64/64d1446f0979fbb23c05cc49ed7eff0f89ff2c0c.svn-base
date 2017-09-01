package service;

import dao.AdminDao;

public class AdminService {
	AdminDao aDao=new AdminDao();
	public boolean adminLog(String AName,String APwd){
		String sql="select * from admin where AName='"+AName+"' and APwd='"+APwd+"'";
		if(aDao.getData(sql)>0)
			return true;
		else
			return false;
	   }
}
