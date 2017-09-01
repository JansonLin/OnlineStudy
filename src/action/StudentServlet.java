package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import entity.Student;
import service.StudentService;

/**
 * Servlet implementation class studentServlet
 */
@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String op=request.getParameter("op");
		String sStudentID=request.getParameter("SStudentID");
		String sPwd=request.getParameter("SPwd");
		StudentService sService = new StudentService();
		
		if(op == null){
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
				e.printStackTrace();
			}
  		    
  		    String realPath="sFiles/"+fileName+"";
  		    
  		    Student student=new Student();
  		    String name=new String(smart.getRequest().getParameter("SName"));
  		    student.setSStudentID(smart.getRequest().getParameter("SStudentID"));
  		    student.setSName(name);
  		    student.setSSex(smart.getRequest().getParameter("SSex"));
  		    student.setSDepartment(smart.getRequest().getParameter("SDepartment"));
  		    student.setSClass(smart.getRequest().getParameter("SClass"));
  		    student.setSIntroduction(smart.getRequest().getParameter("SIntroduction"));
  		    student.setSEmail(smart.getRequest().getParameter("SEmail"));
  		    student.setSImg(realPath);
  		    student.setSContactWay(smart.getRequest().getParameter("SContactWay"));
  		    student.setSPwd(smart.getRequest().getParameter("SPwd"));
			if(sService.add(student)){
				ArrayList<Student> slist=new ArrayList<Student>();
				slist=sService.getList();
				request.getSession().setAttribute("slist", slist);
				response.sendRedirect("../admin/StudentManagement/studentList.jsp");
			}else{
				out.print("<script>alert('添加失败！请联系管理员！');history.back()</script>");
			}
		}
		
		if("list".equals(op)){
			ArrayList<Student> slist=new ArrayList<Student>();
			slist=sService.getList();
			request.getSession().setAttribute("slist", slist);
			response.sendRedirect("../admin/StudentManagement/studentList.jsp");
		}
		
		if("getstudent".equals(op)){
			Student s=new Student();
			s.setSID(Integer.valueOf(request.getParameter("id")));
			Student student=sService.getstudent(s);
			request.getSession().setAttribute("student", student);
			response.sendRedirect("../admin/StudentManagement/studentUpdate.jsp");
		}
		
		if("update".equals(op)){
			SmartUpload smart=new SmartUpload();
            try {
				JspFactory _jspxFactory = null;
				 PageContext pageContext = null;
				 _jspxFactory = JspFactory.getDefaultFactory();
				 pageContext = _jspxFactory.getPageContext(this,request,response,"",true,8192,true);
				 smart.initialize(pageContext);
			     smart.upload();
			     
			     String ext=smart.getFiles().getFile(0).getFileExt();
			     
			     String fileName=Calendar.getInstance().YEAR+"_"+Calendar.getInstance().MONTH+"_"+
			    		 Calendar.getInstance().DAY_OF_YEAR+"_"+Calendar.getInstance().HOUR_OF_DAY+"_"+
			    		 Calendar.getInstance().MINUTE+"_"+Calendar.getInstance().SECOND+(int)(Math.random()*1000)+
			    		 "."+ext;
			     
			     String basepath=this.getServletContext().getRealPath("/");
			     
			     smart.getFiles().getFile(0).saveAs(basepath+"sFiles"+java.io.File.separator+fileName);
			     String realPath="sFiles/"+fileName+""; 
			     String ssid=request.getParameter("id");
			     
			     Student s=new Student();
			     s.setSID(Integer.valueOf(ssid));
			     s.setSStudentID(smart.getRequest().getParameter("SStudentID"));
			     s.setSName(smart.getRequest().getParameter("SName"));
			     s.setSSex(smart.getRequest().getParameter("SSex"));
			     s.setSDepartment(smart.getRequest().getParameter("SDepartment"));
			     s.setSClass(smart.getRequest().getParameter("SClass"));
			     s.setSIntroduction(smart.getRequest().getParameter("SIntroduction"));
			     s.setSEmail(smart.getRequest().getParameter("SEmail"));
			     s.setSImg(realPath);
			     s.setSContactWay(smart.getRequest().getParameter("SContactWay"));
			     
			     if(sService.update(s)){
			    	 ArrayList<Student> slist=new ArrayList<Student>();
			    	 slist=sService.getList();
			    	 request.getSession().setAttribute("slist", slist);
			    	 response.sendRedirect("../admin/StudentManagement/studentList.jsp");
			     }else{
			    	 out.print("<script>alert('更新失败！请联系管理员！');history.back()</script>");
			     }
			} catch (Exception e) {
    			e.printStackTrace();
    		}
		}
		
		// 删除学生
		if("del".equals(op)){
			String id=request.getParameter("id");
			Student s=new Student();
			s.setSID(Integer.valueOf(id));
			if(sService.delete(s)){
				ArrayList<Student> slist=new ArrayList<Student>();
				slist=sService.getList();
				request.getSession().setAttribute("slist", slist);
				response.sendRedirect("../admin/StudentManagement/studentList.jsp");
			}else{
				out.print("<script>alert('删除失败！请联系管理员！');history.back()</script>");
			}
		}
		
		// 查看详情
		if("details".equals(op)){
			String id=request.getParameter("id");
			Student s=new Student();
			s.setSID(Integer.valueOf(id));
			Student student=sService.getstudent(s);
			request.getSession().setAttribute("student", student);
			response.sendRedirect("../admin/StudentManagement/studentDetails.jsp");
		}
		
		// 查询
		if("sea".equals(op)){
			String i=request.getParameter("i");
			int j=Integer.parseInt(i);
			System.out.println(j);
			String str=request.getParameter("j");
			Student stu=new Student();
			ArrayList<Student> slist=new ArrayList<Student>();
			if(j==1){
				stu.setSName(str);
				slist=sService.getList(stu,j);
				request.getSession().setAttribute("slist", slist);
				response.sendRedirect("../admin/StudentManagement/studentList.jsp");
			}
			else if(j==2){
				stu.setSDepartment(str);
				slist=sService.getList(stu,j);
				request.getSession().setAttribute("slist", slist);
				response.sendRedirect("../admin/StudentManagement/studentList.jsp");
			}
			else if(j==3){
				stu.setSStudentID(str);
				slist=sService.getList(stu,j);
				request.getSession().setAttribute("slist", slist);
				response.sendRedirect("../admin/StudentManagement/studentList.jsp");
			}else{
				out.print("<script>alert('获取参数失败！请联系管理员！');history.back()</script>");
			}
		
		}
		out.flush();
		out.close();
	}

}
