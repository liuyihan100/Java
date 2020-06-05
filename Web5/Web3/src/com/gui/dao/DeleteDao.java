package com.gui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.gui.util.JDBCUtil;

public class DeleteDao {
	
	public static int delete(int id){
		Connection conn = null;
		PreparedStatement state = null;
		int result = -1;
		try {
			conn = JDBCUtil.getConnect();
			String sql = "delete from employees where employee_id = ?";
			state = conn.prepareStatement(sql);
			state.setObject(1, id);
			result = state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeSource(conn, state, null);
		}
		return result;
	}
}
