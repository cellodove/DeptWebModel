package com.dept.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/DBManager")
public class DBManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = null;
		Boolean bool = true;
		
		//웹브라우저에서 처리할 데이터의 MIME 타입과 인코딩을 지정한다. 
		response.setContentType("text/html; charset=UTF-8");
		
		//내용을 출력할 수 있는 출력 스트림을 생성한다. 
		PrintWriter out = response.getWriter();
		
		try	{
			//서버 설정의 자원과 데이터베이스 관련 자원을 관리한다. 
			Context context = new InitialContext();
			
			//JNDI를 설정하여 컨테이너의 리소스 정의에 관한 컨텍스트를 생성한다. 
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			
			//커넥션 객체를 생성한다. 
			connection = dataSource.getConnection();
			if (bool == true) {
				out.println("연결되었습니다.DBManager");
			}
		}catch(Exception e){ 
			out.println("연결에 실패했습니다.DBManager"); 
			e.printStackTrace( );
			//자원 해제를 한다. 
		}finally { 
			try { 
				connection.close( ); 
				} catch (SQLException e) { 
					e.printStackTrace( ); 
					} 
			} 
		}

	
}
