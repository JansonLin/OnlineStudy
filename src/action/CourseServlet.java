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
	String fileName;		// 文件名
	String filePath;		// 文件地址
	String fileType;		// 文件类型
	String folderName;		// 文件夹名
	String folderPath;		// 文件夹地址
	String courseName;		// 课程名
	String coursePath;		// 课程地址
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
		
		// 获取当前课程ID
		if("list".equals(op)){
			ArrayList<Course> slist=new ArrayList<Course>();
			slist=cService.getCourseID();
			for(int i=0;i<slist.size();i++){
				Course s=slist.get(i);
				System.out.println(s);
			}
		}
		
		// 课程类型选择
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
		// 生成课程
		if("createCourse".equals(op1)){
			File file=getDir();
			printFiles(file,1);
			response.sendRedirect("../admin/createCourse.jsp");
		}
		// 添加课程类型
		if("addCourseType".equals(op2)){
			System.out.println(direction);
			System.out.println(sort);
			System.out.println(type);
			System.out.println(grade);
			if(cService.addCourseType(direction,sort,type,grade,courseID)){
				response.sendRedirect("../admin/createCourse.jsp");
				out.print("<script>alert('添加类型成功')</script>");
			}else{
				out.print("<script>alert('生成课程错误！');history.back();</script>"); 
			}
		}
		// 课程列表
		if("courseList".equals(op)){
			ArrayList<Course> course=new ArrayList<Course>();
			course=cService.getCourseList();
			request.getSession().setAttribute("course", course);
			response.sendRedirect("../admin/courseList.jsp");
		}
		// 添加图片
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
				out.print("<script>alert('添加失败！请联系管理员！');history.back()</script>");
			}
		}
		// 删除课程
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
				out.print("<script>alert('删除失败！请联系管理员！');history.back()</script>");
			}
		}
		// 修改课程1
		if("modifyCourse".equals(op)){
			Course c=new Course();
			c.setCID(Integer.valueOf(request.getParameter("id")));
			Course course=cService.getCourseList(c);
			request.getSession().setAttribute("course", course);
			response.sendRedirect("../admin/modifyCourse.jsp");
		}
		//修改课程2
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
				// String id=smart.getRequest().getParameter("id");此方法得到的值为null
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
					out.print("<script>alert('更新失败！请联系管理员！');history.back()</script>");
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
			
	        File next[] = file.listFiles();      //返回值是文件和文件夹，存在于数组中  
	        for(int i=0;i<next.length;i++){  
	            for(int j=0;j<tab;j++)          //输出|--当做识别层次的标记  
	                System.out.print("|--");    //使用print而不是println，可以避免每次的换行  
	            if(next[i].isFile()){
	            	fileName=next[i].getName();
	                filePath=next[i].getPath().replace("\\","\\\\");
	                
//	                fileType=fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
//	                String type[] = { "avi", "flv", "wmv", "mov", "mkv", "mp4", "rmvb", "asf", "navi", "3gp", "WebM", "dat" };
	                
	                Pattern pattern = Pattern.compile(".(avi|flv|wmv|mov|mkv|mp4|rmvb|asf|navi|3gp|WebM|dat)$");
               	 	Matcher matcher = pattern.matcher(filePath);
               	 	
	                while(matcher.find()){
	                	System.out.println(matcher.group());
	                	System.out.println("这是一个视频文件");
		            	System.out.println(fileName);//打印文件或文件夹的名字 
		                System.out.println(filePath);
		                System.out.println(fileType);
		                if(cService.saveFile(fileName,filePath,courseID,directoryListsID)){
		                	System.out.println(courseName+"文件名保存成功"+"\n"+coursePath+"文件路径保存成功");
		                	continue;
		                }else
		    				System.out.println(courseName+"文件名保存失败"+"\n"+coursePath+"文件路径保存失败");
	                }
	            }else{
	            	System.out.println("这是一个文件夹");
	            	folderName=next[i].getName();
	            	folderPath=next[i].getPath().replace("\\","\\\\");
	            	System.out.println(folderName);
	            	System.out.println(folderPath);
	            	if(cService.saveFolder(folderName,folderPath,courseID)){
	                	System.out.println(folderName+"文件名保存成功"+"\n"+folderPath+"文件路径保存成功");
		            	// 获取文件夹ID
	                	ArrayList<DirectoryLists> slist=new ArrayList<DirectoryLists>();
	 	    			slist=cService.getDirectoryListsID();
	 	    			for(int j=0;j<slist.size();j++){
	 	    				DirectoryLists d=slist.get(j);
	 	    				System.out.println("当前文件夹的ID是："+d.getDID());
	 	    				directoryListsID=d.getDID();
	 	    			}
	            	}else
	    				System.out.println(folderName+"文件名保存失败"+"\n"+folderPath+"文件路径保存失败");
	            	if(next[i].isDirectory())  
	                    printFiles(next[i],tab+1);  //递归调用自身  
	            }
	        } 
	    }
	}
	
	public File getDir() {
		Scanner sc=new Scanner(System.in);
        System.out.println("请输入文件夹路径：");
        while(true){
        	String line = sc.nextLine();
            File file =new File(line);
            if(!file.exists()){
                System.out.println("文件夹不存在，请重新输入！");
            }else if(file.isFile()){
                System.out.println("输入的是文件路径，请重新输入！");
            }else{
                courseName = file.getName();
                coursePath = file.getPath().replace("\\","\\\\");
                System.out.println("当前课程的名称是:"+courseName);
                System.out.println("当前课程的地址是:"+coursePath);
                if(cService.saveCourse(courseName,coursePath)){
                	System.out.println(courseName+"\t课程名保存成功"+"\n"+coursePath+"\t课程路径保存成功");
                	// 获取课程ID
                	// 获取当前课程ID
	                ArrayList<Course> slist=new ArrayList<Course>();
	    			slist=cService.getCourseID();
	    			for(int i=0;i<slist.size();i++){
	    				Course s=slist.get(i);
	    				System.out.println("当前课程的ID是："+s.getCID());
	    				courseID=s.getCID();
	    			}
                }else
    				System.out.println(courseName+"课程名保存失败"+"\n"+coursePath+"课程路径保存失败");
                return file;
            }
        }
    }
	
	
	public void getFileName(){
		Course course = new Course();
		course.setCName("Ajax");//模仿传值过来
		ArrayList<CourseAndVideos> clist = new ArrayList<CourseAndVideos>();
		clist = cService.getFileName(course);
		for(int i=0; i<clist.size();i++){
			System.out.println(clist.get(i).getCAddress()+"\\"+clist.get(i).getVName());
		}
	}
}