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

import entity.Direction;
import entity.Sort;
import entity.Student;
import entity.Type;
import service.TabBarsService;

/**
 * Servlet implementation class TabBarsServlet
 */
@WebServlet("/TabBarsServlet")
public class TabBarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TabBarsServlet() {
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
		
		TabBarsService tbService=new TabBarsService();
		
		// �������б�
		if("directionList".equals(op)){
			ArrayList<Direction> direction=new ArrayList<Direction>();
			direction=tbService.getDirectionList();
			request.getSession().setAttribute("direction", direction);
			response.sendRedirect("../admin/TabBarsManagement/directionOperation.jsp");
		}
		
		// �������б�
		if("sortList".equals(op)){
			ArrayList<Sort> sort=new ArrayList<Sort>();
			sort=tbService.getSortList();
			request.getSession().setAttribute("sort", sort);
			response.sendRedirect("../admin/TabBarsManagement/sortOperation.jsp");
		}
		
		// �������б�
		if("typeList".equals(op)){
			ArrayList<Type> type=new ArrayList<Type>();
			type=tbService.getTypeList();
			request.getSession().setAttribute("type", type);
			response.sendRedirect("../admin/TabBarsManagement/typeOperation.jsp");
		}
		// ���direction
		if("addDirection".equals(op)){
			String name=request.getParameter("add");
			if(tbService.addDirection(name)) {
				ArrayList<Direction> direction=new ArrayList<Direction>();
				direction=tbService.getDirectionList();
				request.getSession().setAttribute("direction", direction);
				response.sendRedirect("../admin/TabBarsManagement/directionOperation.jsp");
			}else{
				out.print("<script>alert('��ӳ������������');history.back();</script>"); 
			}
		}
		// ���sort
		if("addSort".equals(op)){
			String name=request.getParameter("add");
			if(tbService.addSort(name)) {
				ArrayList<Sort> sort=new ArrayList<Sort>();
				sort=tbService.getSortList();
				request.getSession().setAttribute("sort", sort);
				response.sendRedirect("../admin/TabBarsManagement/sortOperation.jsp");
			}else{
				out.print("<script>alert('��ӳ������������');history.back();</script>"); 
			}
		}
		// ���type
		if("addType".equals(op)){
			String name=request.getParameter("add");
			if(tbService.addType(name)) {
				ArrayList<Type> type=new ArrayList<Type>();
				type=tbService.getTypeList();
				request.getSession().setAttribute("type", type);
				response.sendRedirect("../admin/TabBarsManagement/typeOperation.jsp");
			}else{
				out.print("<script>alert('��ӳ������������');history.back();</script>"); 
			}
		}
		// ɾ��direction
		if("delDiretion".equals(op)){
			String id=request.getParameter("id");
			Direction d=new Direction();
			d.setDir_ID(Integer.valueOf(id));
			if(tbService.deleteDirection(d)){
				ArrayList<Direction> direction=new ArrayList<Direction>();
				direction=tbService.getDirectionList();
				request.getSession().setAttribute("direction", direction);
				response.sendRedirect("../admin/TabBarsManagement/directionOperation.jsp");
			}else{
				out.print("<script>alert('ɾ��ʧ�ܣ�����ϵ����Ա��');history.back()</script>");
			}
		}
		// ɾ��sort
		if("delSort".equals(op)){
			String id=request.getParameter("id");
			Sort s=new Sort();
			s.setSort_ID(Integer.valueOf(id));
			if(tbService.deleteSort(s)){
				ArrayList<Sort> sort=new ArrayList<Sort>();
				sort=tbService.getSortList();
				request.getSession().setAttribute("sort", sort);
				response.sendRedirect("../admin/TabBarsManagement/sortOperation.jsp");
			}else{
				out.print("<script>alert('ɾ��ʧ�ܣ�����ϵ����Ա��');history.back()</script>");
			}
		}
		// ɾ��type
		if("delType".equals(op)){
			String id=request.getParameter("id");
			Type t=new Type();
			t.setType_ID(Integer.valueOf(id));
			if(tbService.deleteType(t)){
				ArrayList<Type> type=new ArrayList<Type>();
				type=tbService.getTypeList();
				request.getSession().setAttribute("type", type);
				response.sendRedirect("../admin/TabBarsManagement/typeOperation.jsp");
			}else{
				out.print("<script>alert('ɾ��ʧ�ܣ�����ϵ����Ա��');history.back()</script>");
			}
		}
		// �޸�direction
		if("modifyDirection".equals(op)){
			String id=request.getParameter("id");
			String newName=request.getParameter("name");
			Direction d=new Direction();
			d.setDir_ID(Integer.valueOf(id));
			d.setDir_Name(newName);
			if(tbService.modifyDirection(d)){
				ArrayList<Direction> direction=new ArrayList<Direction>();
				direction=tbService.getDirectionList();
				request.getSession().setAttribute("direction", direction);
				response.sendRedirect("../admin/TabBarsManagement/directionOperation.jsp");
			}else{
				out.print("<script>alert('����ʧ�ܣ�����ϵ����Ա��');history.back()</script>");
			}
		}
		//�޸�sort
		if("modifySort".equals(op)){
			String id=request.getParameter("id");
			String newName=request.getParameter("name");
			Sort s=new Sort();
			s.setSort_ID(Integer.valueOf(id));
			s.setSort_Name(newName);
			if(tbService.modifySort(s)){
				ArrayList<Sort> sort=new ArrayList<Sort>();
				sort=tbService.getSortList();
				request.getSession().setAttribute("sort", sort);
				response.sendRedirect("../admin/TabBarsManagement/sortOperation.jsp");
			}else{
				out.print("<script>alert('����ʧ�ܣ�����ϵ����Ա��');history.back()</script>");
			}
		}
		//�޸�sort
		if("modifyType".equals(op)){
			String id=request.getParameter("id");
			String newName=request.getParameter("name");
			Type t=new Type();
			t.setType_ID(Integer.valueOf(id));
			t.setType_Name(newName);
			if(tbService.modifyType(t)){
				ArrayList<Type> type=new ArrayList<Type>();
				type=tbService.getTypeList();
				request.getSession().setAttribute("type", type);
				response.sendRedirect("../admin/TabBarsManagement/typeOperation.jsp");
			}else{
				out.print("<script>alert('����ʧ�ܣ�����ϵ����Ա��');history.back()</script>");
			}
		}
		out.flush();
		out.close();
	}

}
