package service;

import java.util.ArrayList;

import javax.servlet.jsp.jstl.sql.Result;

import dao.IndexDao;
import entity.Direction;
import entity.Sort;

public class IndexService {
	IndexDao iDao=new IndexDao();
	
	// 获取方向  以便列举出来
	public ArrayList<Direction> getDirection(){
		ArrayList<Direction> slist=new ArrayList<Direction>();
		String sql="SELECT * FROM direction";
		Result result=iDao.getList(sql);
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
		Result result=iDao.getList(sql);
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
		
}
