package com.dept.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dept.dao.DeptDAO;
import com.dept.dto.DeptDTO;
import com.dept.util.Action;
import com.dept.util.ActionCommand;

public class DeptDetailService implements Action{

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DeptDAO deptDAO = new DeptDAO();
		DeptDTO deptDTO = new DeptDTO();
		int deptno = Integer.parseInt(request.getParameter("deptno"));

		deptDTO= deptDAO.selectById(deptno);
		if(deptDTO == null) {
			System.out.println("상세보기 실패");
			return null;
		}
		request.setAttribute("deptDTO", deptDTO);
		ActionCommand actionCommand = new ActionCommand( );
		actionCommand.setRedirect(false);
		actionCommand.setPath("./Listview.jsp"); 
		return actionCommand;

	}
}
