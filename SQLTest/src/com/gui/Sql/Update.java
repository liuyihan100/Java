package com.gui.Sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.gui.util.JDBCUtil;

public class Update {
	
	@Test
	public void update(){
		Connection conn = null;
		PreparedStatement state = null;
		try {
			//1����������
			conn = JDBCUtil.getConnection();
			//2��Ԥ����sql��䣬����preparedStatementʵ��
			String sql = "update employees set last_name = ? where last_name = ?";
			state = conn.prepareStatement(sql);
			//3�����ռλ��
			state.setString(1, "˧");
			state.setString(2, "��");
			//4��ִ�����
			state.execute();
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			//5���ر���Դ
			JDBCUtil.closeSource(conn, state);
		}
	}
}
