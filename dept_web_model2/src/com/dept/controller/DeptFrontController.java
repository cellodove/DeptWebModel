package com.dept.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dept.service.DeptAddService;
import com.dept.service.DeptDeleteService;
import com.dept.service.DeptDetailService;
import com.dept.service.DeptListSevice;
import com.dept.service.DeptupdateService;
import com.dept.service.Deptupdate_svaeService;
import com.dept.util.Action;
import com.dept.util.ActionCommand;

public class DeptFrontController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	// HTTP 요청을 파악하여 커맨드 핸들러에 전송한다.
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 서블릿 맵핑명을 설정한다.
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());
		// 포워딩 정보를 저장한다.
		ActionCommand actionCommand = null;
		// 메소드를 규격화한다.
		Action action = null;
		// 맵핑명을 지정하고 서블릿 클래스를 설정한다.
		if (pathURL.equals("/List.do")) {// 리스트
			action = new DeptListSevice();
			System.out.println("DeptFrontController 조회");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 맵핑명을 지정하고 서블릿 클래스를 설정한다.
		} else if (pathURL.equals("/Insert_view.do")) {//등록 화면
			actionCommand = new ActionCommand();
			actionCommand.setRedirect(false);
			actionCommand.setPath("./Insert.jsp");

		}else if (pathURL.equals("/Insert.do")) {// 등록
			action = new DeptAddService();
			System.out.println("DeptFrontController 입력");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (pathURL.equals("/Listview.do")) {// 상세보기
			action = new DeptDetailService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 맵핑명을 지정하고 서블릿 클래스를 설정한다.
		} else if (pathURL.equals("/Deptdelete.do"))// 삭제
		{
			action = new DeptDeleteService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 맵핑명을 지정하고 서블릿 클래스를 설정한다.
		}else if (pathURL.equals("/Deptupdate.do")) {// 수정(조회)
			action = new DeptupdateService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
								    
		} else if (pathURL.equals("/Deptupdate_save.do")) {// 수정(저장)
			action = new Deptupdate_svaeService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		// 전송된 방식에 따라 forward 방식과 redirect 방식을 처리한다.
		if (actionCommand != null) {
			// isRedirect 메소드 값이 false이면 forward 방식이고 true이면 redirect 방식이 된다.
			if (actionCommand.isRedirect()) {
				response.sendRedirect(actionCommand.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(actionCommand.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	// HTTP 요청이 get 메소드 방식인지를 확인하고 service 메소드를 호출한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	// HTTP 요청이 post 메소드 방식인지를 확인하고 service 메소드를 호출한다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}
}
