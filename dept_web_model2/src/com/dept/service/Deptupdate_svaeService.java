package com.dept.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dept.dao.DeptDAO;
import com.dept.dto.DeptDTO;
import com.dept.util.Action;
import com.dept.util.ActionCommand;

public class Deptupdate_svaeService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DeptDAO deptdao = new DeptDAO();
		DeptDTO deptdto = new DeptDTO();
		ActionCommand actionCommand = new ActionCommand();
		
		int result= 0;
		int deptno = Integer.parseInt(request.getParameter("deptno"));
//		System.out.println("deptupdate_save deptno"+deptno);
		try {
				deptdto.setDeptno(deptno);
				deptdto.setDname(request.getParameter("dname"));
				deptdto.setLoc(request.getParameter("loc"));
			
				result = deptdao.update(deptdto);
				System.out.println("result(Deptupdate_svaeService) : "+result);
				if(result == 0) {
					System.out.println("부서 등록 실패");
					return null;
				}
				System.out.println("부서 등록 완료");			
				actionCommand.setRedirect(true);			
				actionCommand.setPath("./List.do");
				return actionCommand;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
