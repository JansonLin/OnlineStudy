package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Course;
import entity.Direction;
import entity.DirectoryLists;
import entity.Sort;
import entity.Student;
import entity.Type;
import entity.Video;
import service.AllCourseService;

/**
 * Servlet implementation class CourseList
 */
@WebServlet("/CourseList")
public class AllCourseServlet extends HttpServlet {
	int courseID;
	int directoryListsID;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllCourseServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String op=request.getParameter("op");
		AllCourseService acService =new AllCourseService();
		
		// 获取方向
		if("list".equals(op)){
			ArrayList<Direction> direction=new ArrayList<Direction>();
			direction=acService.getDirectoryListsID();
			request.getSession().setAttribute("direction", direction);
			
			ArrayList<Sort> sort=new ArrayList<Sort>();
			sort=acService.getSortID();
			request.getSession().setAttribute("sort", sort);
			
			ArrayList<Type> type=new ArrayList<Type>();
			type=acService.getTypeID();
			request.getSession().setAttribute("type", type);
			
			response.sendRedirect("../allCourse.jsp");
		}
		
		if("courseList".equals(op)){
			ArrayList<Course> courseList=new ArrayList<Course>();
			courseList=acService.getCourseList();
			request.getSession().setAttribute("courseList", courseList);
			for(int i=0;i<courseList.size();i++){
				Course s=courseList.get(i);
				System.out.println("当前课程的ID是："+s.getCID());
				courseID=s.getCID();
			}
			response.sendRedirect("../allCourse.jsp");
		}
		if("DAndVList".equals(op)){
			ArrayList<DirectoryLists> directoryLists=new ArrayList<DirectoryLists>();
			directoryLists=acService.getDirectoryLists(courseID);
			request.getSession().setAttribute("directoryLists", directoryLists);
			
			ArrayList<Video> video=new ArrayList<Video>();
			video=acService.getVideoLists(courseID);
			request.getSession().setAttribute("video", video);
			response.sendRedirect("../video.jsp");
		}
		
		//janson  sortlist和对应的service
		if("getlist".equals(op)){
			int did = Integer.parseInt(request.getParameter("did"));
			if(did==0){
				ArrayList<Sort> sort=new ArrayList<Sort>();
				sort=acService.getSortID();
				request.getSession().setAttribute("sort", sort);
			}else{
				ArrayList<Sort> sort=new ArrayList<Sort>();
				sort=acService.getSortID(did);
				request.getSession().setAttribute("sort", sort);
			}
			response.sendRedirect("../allCourse.jsp");
		}
		
		//courselist和对应的service
		if("getCourseList".equals(op)){
			String sname = request.getParameter("sname");
			ArrayList<Course> courseList=new ArrayList<Course>();
			courseList = acService.getCourseList(sname);
			request.getSession().setAttribute("courseList", courseList);
			response.sendRedirect("../allCourse.jsp");
		}
		out.flush();
		out.close();
	}

}
