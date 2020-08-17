package com.dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dept.dto.DeptDTO;

public class DeptDAO {
	private static DeptDAO deptDAO = new DeptDAO();
	
	private int result = 0;

	public DeptDAO() {
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			System.out.println(dataSource + "연결되었습니다.(DAO)");
		} catch (Exception e) {
			System.out.println("DB 연결 실패  (DAO) :" + e);
			return;
		}
	}

	public static DeptDAO getInstance() {
		return deptDAO;
	}

	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int nextval() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			StringBuffer query = new StringBuffer();
			query.append("SELECT MAX(deptno) ").append("FROM dept");
			preparedStatement = connection.prepareStatement(query.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				result = resultSet.getInt("MAX(deptno)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement, resultSet);
		}
		return result;
	}

	public int insert(DeptDTO deptDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			StringBuffer query = new StringBuffer();
			query.append("insert into dept(deptno,dname,loc) values(?,?,?)");
			preparedStatement = connection.prepareStatement(query.toString());
			preparedStatement.setInt(1, deptDTO.getDeptno());
			preparedStatement.setString(2, deptDTO.getDname());
			preparedStatement.setString(3, deptDTO.getLoc());
			System.out.println(deptDTO.toString());
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement, null);
		}
		return result;
	}

	public List<DeptDTO> selectList() {
		List<DeptDTO> list = new ArrayList<>();

		Connection connection = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null; 
		try { 
			Context context = new InitialContext( ); 
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc"); 
			connection = dataSource.getConnection( );
			String sql = "select deptno,dname,loc from dept";
//			System.out.println("List : "+sql);
			System.out.println();
			preparedStatement = connection.prepareStatement(sql);
				 

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				DeptDTO deptDTO = new DeptDTO();
				deptDTO.setDeptno(resultSet.getInt("deptno"));
				deptDTO.setDname(resultSet.getString("dname"));
				deptDTO.setLoc(resultSet.getString("loc"));
				list.add(deptDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	public DeptDTO selectById(int deptno) {
		DeptDTO deptDTO = new DeptDTO();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			String sql = "SELECT deptno,dname,loc FROM dept WHERE deptno = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, deptno);
//			System.out.println("selectById deptno : "+deptno);
			resultSet = preparedStatement.executeQuery();
//			System.out.println("selectById try쿼리문 : "+sql);
			while (resultSet.next()) {
//				System.out.println("selectById while문 쿼리문 : "+sql);
				deptDTO.setDeptno(resultSet.getInt("deptno"));
				deptDTO.setDname(resultSet.getString("dname"));
				deptDTO.setLoc(resultSet.getString("loc"));
				deptDTO.toString();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement, resultSet);
		}
		return deptDTO;
	}

	public int del(int deptno) {
//		System.out.println("삭제 1");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
//			System.out.println("삭제 2 try 안에");
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "DELETE FROM dept WHERE deptno = ?";
//			System.out.println("삭제 3 sql"+sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, deptno);
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement, null);
		}
		return result;
	}

	public int update(DeptDTO deptDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
//		System.out.println("update DAO");
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			StringBuffer query = new StringBuffer();
			query.append("UPDATE dept SET dname = ?, ");
			query.append("loc = ? ");
			query.append("WHERE deptno = ?");

			preparedStatement = connection.prepareStatement(query.toString());
			preparedStatement.setString(1, deptDTO.getDname());
			preparedStatement.setString(2, deptDTO.getLoc());
			preparedStatement.setInt(3, deptDTO.getDeptno());
			System.out.println("update DAO"+deptDTO.getDname());
			System.out.println("update DAO"+deptDTO.getLoc());
			System.out.println("update DAO"+deptDTO.getDeptno());
			System.out.println(query.toString());
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement, null);
		}
		return result;
	}

}
