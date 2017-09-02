package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import entity.Course;
import entity.Direction;
import entity.DirectoryLists;
import entity.Grade;
import entity.Sort;
import entity.Student;
import entity.CourseAndVideos;
import entity.Type;
import filter.videoFilter;
import service.CourseService;

public class CourseServlet extends HttpServlet {
	CourseService cService=new CourseService();
	String fileName;		// �ļ���
	String filePath;		// �ļ���ַ
	String fileType;		// �ļ�����
	String folderName;		// �ļ�����
	String folderPath;		// �ļ��е�ַ
	String courseName;		// �γ���
	String coursePath;		// �γ̵�ַ
	int courseID;
	int directoryListsID;
	String direction;
	String sort;
	String type;
	String grade;
	
	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String op=request.getParameter("op");
		String op1=request.getParameter("op1");
		String op2=request.getParameter("op2");
		
		direction=request.getParameter("dir");
		sort=request.getParameter("sort");
		type=request.getParameter("type");
		grade=request.getParameter("grade");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		
		// ��ȡ��ǰ�γ�ID
		if("list".equals(op)){
			ArrayList<Course> slist=new ArrayList<Course>();
			slist=cService.getCourseID();
			for(int i=0;i<slist.size();i++){
				Course s=slist.get(i);
				System.out.println(s);
			}
		}
		
		// �γ�����ѡ��
		if("getCourseType".equals(op)){
			ArrayList<Direction> d=new ArrayList<Direction>();
			d=cService.getDirection();
			request.getSession().setAttribute("d",d);
			
			ArrayList<Sort> s=new ArrayList<Sort>();
			s=cService.getSort();
			request.getSession().setAttribute("s",s);
			
			ArrayList<Type> t=new ArrayList<Type>();
			t=cService.getType();
			request.getSession().setAttribute("t",t);
			
			ArrayList<Grade> g=new ArrayList<Grade>();
			g=cService.getGrade();
			request.getSession().setAttribute("g",g);
			response.sendRedirect("../admin/createCourse.jsp");
		}
		// ���ɿγ�
		if("createCourse".equals(op1)){
			File file=getDir();
			printFiles(file,1);
			response.sendRedirect("../admin/createCourse.jsp");
		}
		// ��ӿγ�����
		if("addCourseType".equals(op2)){
			System.out.println(direction);
			System.out.println(sort);
			System.out.println(type);
			System.out.println(grade);
			if(cService.addCourseType(direction,sort,type,grade,courseID)){
				response.sendRedirect("../admin/createCourse.jsp");
				out.print("<script>alert('������ͳɹ�')</script>");
			}else{
				out.print("<script>alert('���ɿγ̴���');history.back();</script>"); 
			}
		}
		// �γ��б�
		if("courseList".equals(op)){
			ArrayList<Course> course=new ArrayList<Course>();
			course=cService.getCourseList();
			request.getSession().setAttribute("course", course);
			response.sendRedirect("../admin/courseList.jsp");
		}
		// ���ͼƬ
		if("addImg".equals(op)){
			SmartUpload smart=new SmartUpload();
			JspFactory _jspxFactory = null;
			PageContext pageContext = null;
			_jspxFactory = JspFactory.getDefaultFactory();
			pageContext = _jspxFactory.getPageContext(this,request,response,"",true,8192,true);
			smart.initialize(pageContext);
		    try {
				smart.upload();
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    String ext=smart.getFiles().getFile(0).getFileExt();
  		    String fileName=Calendar.getInstance().YEAR+"_"+Calendar.getInstance().MONTH+"_"+
  		    		 Calendar.getInstance().DAY_OF_YEAR+"_"+Calendar.getInstance().HOUR_OF_DAY+"_"+
  		    		 Calendar.getInstance().MINUTE+"_"+Calendar.getInstance().SECOND+(int)(Math.random()*1000)+
  		    		 "."+ext;
  		    String basepath=this.getServletContext().getRealPath("/");
  		    try {
				smart.getFiles().getFile(0).saveAs(basepath+"sFiles"+java.io.File.separator+fileName);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		    String realPath="sFiles/"+fileName+"";
  		    Course course=new Course();
  		    course.setCImgAddress(realPath);
  		  if(cService.addImg(course)){
				ArrayList<Course> slist=new ArrayList<Course>();
				slist=cService.getCourseList();
				request.getSession().setAttribute("slist", slist);
				response.sendRedirect("../student/studentlist.jsp");
			}else{
				out.print("<script>alert('���ʧ�ܣ�����ϵ����Ա��');history.back()</script>");
			}
		}
		// ɾ���γ�
		if("delCourse".equals(op)){
			String id=request.getParameter("id");
			Course c=new Course();
			c.setCID(Integer.valueOf(id));
			if(cService.deleteCourse(c)){
				ArrayList<Course> course=new ArrayList<Course>();
				course=cService.getCourseList();
				request.getSession().setAttribute("course", course);
				response.sendRedirect("../admin/courseList.jsp");
			}else{
				out.print("<script>alert('ɾ��ʧ�ܣ�����ϵ����Ա��');history.back()</script>");
			}
		}
		// �޸Ŀγ�1
		if("modifyCourse".equals(op)){
			Course c=new Course();
			c.setCID(Integer.valueOf(request.getParameter("id")));
			Course course=cService.getCourseList(c);
			request.getSession().setAttribute("course", course);
			response.sendRedirect("../admin/modifyCourse.jsp");
		}
		//�޸Ŀγ�2
		if ("updateCourse".equals(op)) {
			SmartUpload smart = new SmartUpload();
			try {
				JspFactory _jspxFactory = null;
				PageContext pageContext = null;
				_jspxFactory = JspFactory.getDefaultFactory();
				pageContext = _jspxFactory.getPageContext(this, request, response, "", true, 8192, true);
				smart.initialize(pageContext);
				smart.upload();

				String ext = smart.getFiles().getFile(0).getFileExt();
				String fileName = Calendar.getInstance().YEAR + "_" + Calendar.getInstance().MONTH + "_"
						+ Calendar.getInstance().DAY_OF_YEAR + "_" + Calendar.getInstance().HOUR_OF_DAY + "_"
						+ Calendar.getInstance().MINUTE + "_" + Calendar.getInstance().SECOND
						+ (int) (Math.random() * 1000) + "." + ext;
				String basepath = this.getServletContext().getRealPath("/");
				smart.getFiles().getFile(0).saveAs(basepath + "sFiles" + java.io.File.separator + fileName);
				String realPath = "sFiles/" + fileName + "";
				// String id=smart.getRequest().getParameter("id");�˷����õ���ֵΪnull
				// System.out.println(id);
				String courseID = request.getParameter("id");
				// System.out.println(ssid);
				Course c = new Course();
				c.setCID(Integer.valueOf(courseID));
				c.setCName(smart.getRequest().getParameter("CName"));
				c.setCAddress(smart.getRequest().getParameter("CAddr"));
				c.setCDirection(smart.getRequest().getParameter("CDir"));
				c.setCSort(smart.getRequest().getParameter("CSort"));
				c.setCType(smart.getRequest().getParameter("CType"));
				c.setCClass(smart.getRequest().getParameter("CClass"));
				c.setCImgAddress(realPath);
				c.setCContent(smart.getRequest().getParameter("CContent"));
				if (cService.updateCourse(c)) {
					ArrayList<Course> course=new ArrayList<Course>();
					course=cService.getCourseList();
					request.getSession().setAttribute("course", course);
					response.sendRedirect("../admin/courseList.jsp");
				} else {
					out.print("<script>alert('����ʧ�ܣ�����ϵ����Ա��');history.back()</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		out.flush();
		out.close();
	}
	
	public void printFiles(File file,int tab) {  
		if(file.isDirectory()){  
			
	        File next[] = file.listFiles();      //����ֵ���ļ����ļ��У�������������  
	        for(int i=0;i<next.length;i++){  
	            for(int j=0;j<tab;j++)          //���|--����ʶ���εı��  
	                System.out.print("|--");    //ʹ��print������println�����Ա���ÿ�εĻ���  
	            if(next[i].isFile()){
	            	fileName=next[i].getName();
	                filePath=next[i].getPath().replace("\\","\\\\");
	                
//	                fileType=fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
//	                String type[] = { "avi", "flv", "wmv", "mov", "mkv", "mp4", "rmvb", "asf", "navi", "3gp", "WebM", "dat" };
	                
	                Pattern pattern = Pattern.compile(".(avi|flv|wmv|mov|mkv|mp4|rmvb|asf|navi|3gp|WebM|dat)$");
               	 	Matcher matcher = pattern.matcher(filePath);
               	 	
	                while(matcher.find()){
	                	System.out.println(matcher.group());
	                	System.out.println("����һ����Ƶ�ļ�");
		            	System.out.println(fileName);//��ӡ�ļ����ļ��е����� 
		                System.out.println(filePath);
		                System.out.println(fileType);
		                if(cService.saveFile(fileName,filePath,courseID,directoryListsID)){
		                	System.out.println(courseName+"�ļ�������ɹ�"+"\n"+coursePath+"�ļ�·������ɹ�");
		                	continue;
		                }else
		    				System.out.println(courseName+"�ļ�������ʧ��"+"\n"+coursePath+"�ļ�·������ʧ��");
	                }
	            }else{
	            	System.out.println("����һ���ļ���");
	            	folderName=next[i].getName();
	            	folderPath=next[i].getPath().replace("\\","\\\\");
	            	System.out.println(folderName);
	            	System.out.println(folderPath);
	            	if(cService.saveFolder(folderName,folderPath,courseID)){
	                	System.out.println(folderName+"�ļ�������ɹ�"+"\n"+folderPath+"�ļ�·������ɹ�");
		            	// ��ȡ�ļ���ID
	                	ArrayList<DirectoryLists> slist=new ArrayList<DirectoryLists>();
	 	    			slist=cService.getDirectoryListsID();
	 	    			for(int j=0;j<slist.size();j++){
	 	    				DirectoryLists d=slist.get(j);
	 	    				System.out.println("��ǰ�ļ��е�ID�ǣ�"+d.getDID());
	 	    				directoryListsID=d.getDID();
	 	    			}
	            	}else
	    				System.out.println(folderName+"�ļ�������ʧ��"+"\n"+folderPath+"�ļ�·������ʧ��");
	            	if(next[i].isDirectory())  
	                    printFiles(next[i],tab+1);  //�ݹ��������  
	            }
	        } 
	    }
	}
	
	public File getDir() {
		Scanner sc=new Scanner(System.in);
        System.out.println("�������ļ���·����");
        while(true){
        	String line = sc.nextLine();
            File file =new File(line);
            if(!file.exists()){
                System.out.println("�ļ��в����ڣ����������룡");
            }else if(file.isFile()){
                System.out.println("��������ļ�·�������������룡");
            }else{
                courseName = file.getName();
                coursePath = file.getPath().replace("\\","\\\\");
                System.out.println("��ǰ�γ̵�������:"+courseName);
                System.out.println("��ǰ�γ̵ĵ�ַ��:"+coursePath);
                if(cService.saveCourse(courseName,coursePath)){
                	System.out.println(courseName+"\t�γ�������ɹ�"+"\n"+coursePath+"\t�γ�·������ɹ�");
                	// ��ȡ�γ�ID
                	// ��ȡ��ǰ�γ�ID
	                ArrayList<Course> slist=new ArrayList<Course>();
	    			slist=cService.getCourseID();
	    			for(int i=0;i<slist.size();i++){
	    				Course s=slist.get(i);
	    				System.out.println("��ǰ�γ̵�ID�ǣ�"+s.getCID());
	    				courseID=s.getCID();
	    			}
                }else
    				System.out.println(courseName+"�γ�������ʧ��"+"\n"+coursePath+"�γ�·������ʧ��");
                return file;
            }
        }
    }
	
	
	public void getFileName(){
		Course course = new Course();
		course.setCName("Ajax");//ģ�´�ֵ����
		ArrayList<CourseAndVideos> clist = new ArrayList<CourseAndVideos>();
		clist = cService.getFileName(course);
		for(int i=0; i<clist.size();i++){
			System.out.println(clist.get(i).getCAddress()+"\\"+clist.get(i).getVName());
		}
	}
}