package com.gui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.gui.util.JDBCUtil;

public class UpdateDao {
	
	public static int update(int id,int employeeId,String firstName,String lastName,int salary){
		Connection conn = null;
		PreparedStatement state = null;
		int result = -1;
		try {
			conn = JDBCUtil.getConnect();
			String sql = "update employees set employee_id = ? , first_name = ? ,last_name = ? , salary = ? where employee_id = ?";
			state = conn.prepareStatement(sql);
			state.setObject(5, id);
			state.setObject(1, employeeId);
			state.setObject(2, firstName);
			state.setObject(3, lastName);
			state.setObject(4, salary);
			result = state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeSource(conn, state, null);
		}
		return result;
	}
}
