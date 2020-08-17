package com.dept.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dept.dao.DeptDAO;
import com.dept.util.Action;
import com.dept.util.ActionCommand;

public class DeptListSevice implements Action{

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		DeptDAO deptDAO= new DeptDAO();
		
		List<?> deptList = new ArrayList<Object>();
		deptList = deptDAO.selectList();
		
		request.setAttribute("deptlist", deptList);
		ActionCommand actionCommand = new ActionCommand( );
		actionCommand.setRedirect(false);
		System.out.println("부서 정보 조회");
		actionCommand.setPath("./List.jsp");
		return actionCommand;
	}
	

}
