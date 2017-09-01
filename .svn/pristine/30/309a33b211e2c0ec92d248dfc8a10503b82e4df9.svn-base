package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

public class AdminLogServlet extends HttpServlet {
	AdminService aService=new AdminService();
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
		String aName=request.getParameter("AName");
		String aPwd=request.getParameter("APwd");
		
		if("adminLog".equals(op)){
			if(aService.adminLog(aName, aPwd)) {
				request.getSession().setAttribute("aName", aName);	
				response.sendRedirect("adminIndex.jsp");
			}else{
				out.print("<script>alert('’À∫≈ªÚ√‹¬Î¥ÌŒÛ£¨«Î÷ÿ–¬µ«¬º£°');history.back();</script>"); 
			}
		}
		out.flush();
		out.close();
	}

}
