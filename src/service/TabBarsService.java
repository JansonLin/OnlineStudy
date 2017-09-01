package service;

import java.util.ArrayList;

import javax.servlet.jsp.jstl.sql.Result;

import dao.TabBarsDao;
import entity.Direction;
import entity.Sort;
import entity.Student;
import entity.Type;

public class TabBarsService {
	TabBarsDao tbDao = new TabBarsDao();
	
	// ��ӷ�����
	public boolean addDirection(String name){
		String sql="insert into direction(dir_Name) values('"+name+"')";	
		if(tbDao.update(sql)>0){
			return true;
		}else
			return false;
	}
	// ��ӷ�����
	public boolean addSort(String name){
		String sql="insert into sort(sort_Name) values('"+name+"')";	
		if(tbDao.update(sql)>0){
			return true;
		}else
			return false;
	}
	// ���������
	public boolean addType(String name){
		String sql="insert into type(type_Name) values('"+name+"')";	
		if(tbDao.update(sql)>0){
			return true;
		}else
			return false;
	}
	
	// �г�Direction
	public ArrayList<Direction> getDirectionList(){
		ArrayList<Direction> slist=new ArrayList<Direction>();
		String sql="select * from direction";
		Result result=tbDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			Direction d=new Direction();
			d.setDir_ID(Integer.valueOf(data[i][0].toString()));
			d.setDir_Name(data[i][1].toString());
			slist.add(d);		
		}
		return slist;
	}
	// �г�sort
	public ArrayList<Sort> getSortList(){
		ArrayList<Sort> slist=new ArrayList<Sort>();
		String sql="select * from sort";
		Result result=tbDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			Sort s=new Sort();
			s.setSort_ID(Integer.valueOf(data[i][0].toString()));
			s.setSort_Name(data[i][1].toString());
			slist.add(s);		
		}
		return slist;
	}
	// �г�type
	public ArrayList<Type> getTypeList(){
		ArrayList<Type> slist=new ArrayList<Type>();
		String sql="select * from type";
		Result result=tbDao.getList(sql);
		Object[][] data=result.getRowsByIndex();
		for(int i=0;i<data.length;i++){
			Type t=new Type();
			t.setType_ID(Integer.valueOf(data[i][0].toString()));
			t.setType_Name(data[i][1].toString());
			System.out.println(data[i][0].toString());
			System.out.println(data[i][1].toString());
			slist.add(t);		
		}
		return slist;
	}
	
	public Direction getDirection(Direction direction){
		Direction d=new Direction();
		String sql="select * from dirction where dir_ID="+direction.getDir_ID();
		Result result =tbDao.getList(sql);
		Object[][] data=result.getRowsByIndex();	//��ά��
		//����ѯ���Ľ����ת��Ϊ��ά����
		for(int i=0;i<data.length;i++){
			//���ַ�����������Ӧ������ֵ
			//�ṹ��
			d.setDir_ID(Integer.valueOf(data[i][0].toString()));
			d.setDir_Name(data[i][1].toString());
		}
		return d;
	}
	// �޸�direction��ֵ
	public boolean modifyDirection(Direction d){
		String sql="UPDATE direction SET dir_Name ='"+d.getDir_Name()+"' where dir_ID="+d.getDir_ID();
		if(tbDao.update(sql)>0){
			return true;
		}else 
			return false;
	}
	// �޸�Sort��ֵ
	public boolean modifySort(Sort s){
		String sql="UPDATE sort SET sort_Name ='"+s.getSort_Name()+"' where sort_ID="+s.getSort_ID();
		if(tbDao.update(sql)>0){
			return true;
		}else 
			return false;
	}
	// �޸�Type��ֵ
	public boolean modifyType(Type t){
		String sql="UPDATE type SET type_Name ='"+t.getType_Name()+"' where type_ID="+t.getType_ID();
		if(tbDao.update(sql)>0){
			return true;
		}else 
			return false;
	}
	// ɾ��������
	public boolean deleteDirection(Direction d){
		String sql="DELETE from direction where dir_ID="+d.getDir_ID();
		if(tbDao.update(sql)>0){
			return true;
		}else 
			return false;
	}
	// ɾ��������
	public boolean deleteSort(Sort s){
		String sql="DELETE from sort where sort_ID="+s.getSort_ID();
		if(tbDao.update(sql)>0){
			return true;
		}else 
			return false;
	}
	// ɾ��������
	public boolean deleteType(Type t){
		String sql="DELETE from type where type_ID="+t.getType_ID();
		if(tbDao.update(sql)>0){
			return true;
		}else 
			return false;
	}
}
