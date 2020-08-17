package com.dept.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dept.dao.DeptDAO;
import com.dept.dto.DeptDTO;
import com.dept.util.Action;
import com.dept.util.ActionCommand;

public class DeptDeleteService implements Action{

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionCommand actionCommand = new ActionCommand( ); 
		int result = 0; 		
		int deptno = Integer.parseInt(request.getParameter("deptno"));	
		DeptDAO deptDAO = new DeptDAO();
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter( ); 
		DeptDTO deptDTO = new DeptDTO();
		deptDTO= deptDAO.selectById(deptno);
		out.println("<script>"); 
		out.println("alert('"+deptDTO.getDeptno()+"번의"+deptDTO.getDname()+","+
		deptDTO.getLoc() +"내용을 삭제하였습니다.');"); 
		out.println("location.href='./List.do';"); 
		out.println("</script>");
		out.close( ); 
		result = deptDAO.del(deptDTO.getDeptno());
		if(result == 0) {
			System.out.println("부서 삭제 실패");
			return null;
		}
		System.out.println("부서 삭제 성공");
		actionCommand.setRedirect(true); 
		actionCommand.setPath("./List.do"); 
		return actionCommand;
	}

	
}
