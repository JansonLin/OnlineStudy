package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Direction;
import entity.Grade;
import entity.Sort;
import entity.Type;
import service.IndexService;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
		IndexService iService=new IndexService();
		
		if("listDirection".equals(op)){
			ArrayList<Direction> d=new ArrayList<Direction>();
			d=iService.getDirection();
			request.getSession().setAttribute("d",d);
			
			ArrayList<Sort> s=new ArrayList<Sort>();
			s=iService.getSort();
			request.getSession().setAttribute("s",s);
			response.sendRedirect("../admin/createCourse.jsp");
		}
		
		out.flush();
		out.close();
	}

}
