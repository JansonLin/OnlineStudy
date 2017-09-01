package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;

import service.LogRegService;

/**
 * Servlet implementation class logRegServlet
 */
@WebServlet("/logRegServlet")
public class LogRegServlet extends HttpServlet {
	LogRegService lrService=new LogRegService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String op=request.getParameter("op");
		
		
		if("log".equals(op)){
			String sStudentID=request.getParameter("SStudentID");
			String sPwd=request.getParameter("SPwd");
			if(lrService.log(sStudentID, sPwd)) {
				Student student = new Student();
				student.setSStudentID(request.getParameter(sStudentID));
				student.setSPwd(request.getParameter(sPwd));
				request.getSession().setAttribute("student", student);
				response.sendRedirect("../index.jsp");
			}else{
				out.print("<script>alert('�˺Ż�������������µ�¼��');history.back();</script>"); 
			}
		}
		
		if("reg".equals(op)){
			String sStudentID=request.getParameter("SStudentID1");
			String sPwd=request.getParameter("SPwd1");
			String SPwdConfirm=request.getParameter("SPwdConfirm1");
			if(lrService.searchSStudentID(sStudentID)){
				out.print("<script>alert('���˺��ѱ�ע�ᣡ');history.back();</script>");
			}else{
				if(lrService.reg(sStudentID, sPwd)){ //�����ת   �����ݿ��в�������
			    	
					out.print("<script>alert('ע��ɹ�!,���¼');history.back();</script>");
				}else {
					out.print("<script>alert('ע��ʧ��,����ϵ����Ա��');history.back();</script>");
				}
			}
			
	    }
		
	out.flush();
	out.close();
	}
}
