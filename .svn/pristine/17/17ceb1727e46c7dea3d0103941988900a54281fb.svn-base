package service;

import java.util.ArrayList;

import javax.servlet.jsp.jstl.sql.Result;

import dao.FileDao;
import entity.FormatVideo;


public class FileService {
	FileDao fd = new FileDao();
	public ArrayList<FormatVideo> getList(){
		ArrayList<FormatVideo> Afv=new ArrayList<FormatVideo>();
		String sql="select * from formatvideo";
		Result result=fd.getList(sql);
		// Object
		Object[] data=result.getRowsByIndex();
		for(int i=0; i<data.length; i++){
			FormatVideo fv = new FormatVideo();
			fv.setFName(data[i].toString());
			Afv.add(fv);
		}
		return Afv;
	}
}
